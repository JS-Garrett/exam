package org.hnjk.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.hnjk.dao.ExamPaperAnswerDao;
import org.hnjk.dao.ExamPaperDao;
import org.hnjk.dao.ExamStudentDao;
import org.hnjk.entity.ExamPaper;
import org.hnjk.entity.ExamPaperAnswer;
import org.hnjk.entity.ExamStudent;
import org.hnjk.entity.Result;
import org.hnjk.jaxb.model.Course;
import org.hnjk.jaxb.model.CurQuestion;
import org.hnjk.jaxb.model.Ksconstraint;
import org.hnjk.jaxb.model.Option;
import org.hnjk.jaxb.model.Paper;
import org.hnjk.jaxb.model.Question;
import org.hnjk.jaxb.model.Questiontype;
import org.hnjk.jaxb.util.CourseXmlConvertUtils;
import org.hnjk.properties.ExamProperties;
import org.hnjk.service.ExamPaperAnswerService;
import org.hnjk.service.ExamPaperService;
import org.hnjk.service.ExamRuleXmlService;
import org.hnjk.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.alibaba.fastjson.JSONObject;

@Service
@Transactional
public class ExamPaperServiceImpl implements ExamPaperService {
	Logger logger = LoggerFactory.getLogger(ExamPaperServiceImpl.class);
	@Value("${ftp.useFtp}")
	private boolean useFtp;
	
	@Value("${resourceIPAddress}")
	private String resourceIPAddress;
	
	@Value("${localResourcePath}")
	private String localResourcePath;
	
	@Autowired
	private ExamStudentDao examStudentDao;
	
	@Autowired
	private ExamPaperDao examPaperDao;
	
	@Autowired
	private ExamPaperAnswerService examPaperAnswerService;
	
	@Autowired
	private ExamRuleXmlService examRuleXmlService;
	
	@Autowired
	private ExamPaperAnswerDao examPaperAnswerDao;

	@Override
	public Map<String, Object> getExamPaper(Course examRule, String paperFileName, ExamStudent examStudent, String isContinue) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		String resourceUrl = useFtp?resourceIPAddress : localResourcePath;
		String filePath = resourceUrl + paperFileName;
		Paper paper = CourseXmlConvertUtils.paperXmlToHtmlByURL(filePath.replaceAll("\\\\","/"));
		
		if(paper == null) throw new RuntimeException("试卷资源已不存在！");
		
//		List<Learningbehavior> learningBehaviors = examRule.getLearningbehaviors().getLearningbehavior();
		
		Ksconstraint ksConstraint = examRule.getConstraint().getKsconstraint();//获取考试约束
		
//		Scoringstandard scoringstandard = examRule.getScoringstandard();
		
		if("0".equals(isContinue)) {
			//试卷处理
			List<Question> questions = paper.getQuestions().getQuestion();
			for (Iterator<Question> qit = questions.iterator(); qit.hasNext();) {
				Question question = (Question) qit.next();
				String content = question.getContent().replace("<u>","（").replace("</u>","）");
				question.setContent(content);
			}
			
			examStudent.setEndTime(null);
			examStudent.setExamTime(ksConstraint.getCountdown_time());
			
			examStudentDao.save(examStudent);
			map.put("student", examStudent);
			ExamPaper examPaper = new ExamPaper();
			examPaper.setExamStudent(examStudent);
			examPaper.setPaperUrl(paperFileName);
			examPaper.setCoursewareCode(examStudent.getCoursewareId());
			examPaper.setCreateDate(new Date());
			String paperId = examPaperDao.save(examPaper).getId();
			map.put("paperId", paperId);
			
		} else {//继续未完成考试
			//根据paperId从缓存读取答案
			String answer = examPaperAnswerService.getAnswerByPaperId(examStudent.getExamPaper().getId());
			JSONObject answerObj = StringUtils.isBlank(answer)?new JSONObject():JSONObject.parseObject(answer);
			
			//根据paperId从缓存读取标记题目
			String mark = examPaperAnswerService.getMarkQuestionsByPaperId(examStudent.getExamPaper().getId());
//			logger.info(mark);
			JSONObject markObj = StringUtils.isBlank(mark)?new JSONObject():JSONObject.parseObject(mark);
			
			List<Questiontype> questiontype = paper.getQuestiontypes().getQuestiontype();
			for (Iterator<Questiontype> it_qtype = questiontype.iterator(); it_qtype.hasNext();) {
				Questiontype qtype = (Questiontype) it_qtype.next();
				List<CurQuestion> curQuestion = qtype.getCurQuestion();
				for (Iterator<CurQuestion> it_curQuestion = curQuestion.iterator(); it_curQuestion.hasNext();) {
					CurQuestion currentQuestion = (CurQuestion) it_curQuestion.next();
					String questionValue = answerObj.getString(currentQuestion.getQuestionId());
					
					String questionMark = markObj.getString(currentQuestion.getQuestionId());
					
					if(!StringUtils.isBlank(questionMark)) currentQuestion.setMarked(questionMark);
					
					if(!StringUtils.isBlank(questionValue)) currentQuestion.setDone(ExamProperties.QUESTION_DONE);
				}
			}
			
			//查找出已做题目，和已选择的选项 并进行标记
			List<Question> questions = paper.getQuestions().getQuestion();
			for (Iterator<Question> qit = questions.iterator(); qit.hasNext();) {
				Question question = (Question) qit.next();
				String content = question.getContent().replace("<u>","（").replace("</u>","）");
				question.setContent(content);
				
				String questionValue = answerObj.getString(question.getId());
				
//				String questionMark = answerObj.getString(question.getId());
				
				if(StringUtils.isBlank(questionValue)) continue;
				if(ExamProperties.QUESTION_TYPE_SINGLE.equals(question.getType()) || ExamProperties.QUESTION_TYPE_MULTIPLE.equals(question.getType())) {//单选题和多选择
					List<Option> options = question.getOption();
					for (Iterator<Option> oit = options.iterator(); oit.hasNext();) {
						Option option = (Option) oit.next();
						
						if(questionValue.contains(option.getId()))
							option.setSelected(ExamProperties.OPTION_SELECTED);
							
					}
				}else if(ExamProperties.QUESTION_TYPE_JUDGE.equals(question.getType())) {
					question.setChoice(questionValue);
				}
				
			}
			
			map.put("paperId", examStudent.getExamPaper().getId());
		}
		map.put("paper", paper);
		
		return map;
	}

	@Override
	public Paper getPaperById(String paperId) {
		ExamPaper examPaper = examPaperDao.getOne(paperId);
		String resourceUrl = useFtp?resourceIPAddress : localResourcePath;
		String filePath = resourceUrl + examPaper.getPaperUrl();
		Paper paper = CourseXmlConvertUtils.paperXmlToHtmlByURL(filePath.replaceAll("\\\\","/"));
		return paper;
	}

	@Override
	public Result inspectPaper(String paperId, Paper paper) {
		Map<String, Object> mapObj = new HashMap<String, Object>();
		List<Map<String, String>> questionResults = new ArrayList<Map<String, String>>();
		
		ExamPaper examPaper = examPaperDao.getOne(paperId);
		ExamStudent examStudent = examPaper.getExamStudent();
		
		List<Question> question = paper.getQuestions().getQuestion();
		List<CurQuestion> curQuestion = new ArrayList<CurQuestion>();
		List<Questiontype> questiontype = paper.getQuestiontypes().getQuestiontype();
		
		for (Iterator<Questiontype> iterator = questiontype.iterator(); iterator.hasNext();) {
			Questiontype qtype = (Questiontype) iterator.next();
			List<CurQuestion> tmpQuestion = qtype.getCurQuestion();
			curQuestion.addAll(tmpQuestion);
		}
		
		float score = 0;//试卷得分
		
		Iterator<Question> qit = question.iterator();
		
		String answer = examPaperAnswerService.getAnswerByPaperId(paperId);
		if(StringUtils.isBlank(answer)) {//试卷没有答案
			while(qit.hasNext()) {//遍历所有试卷题目
				Map<String, String> questionMap = new HashMap<String, String>();
				Question questionObj = (Question) qit.next();
				String questionId = questionObj.getId();
				questionMap.put("id", questionId);
				
				questionMap = setNoAnswerResult(questionMap, questionObj);
				
				questionResults.add(questionMap);
			}
		}else {//试卷有答案
			JSONObject answerObj = JSONObject.parseObject(answer);
			Set<String> keySet = answerObj.keySet();//答案的键集合
			
			while(qit.hasNext()) {//遍历所有试卷题目
				Map<String, String> questionMap = new HashMap<String, String>();
				Question questionObj = (Question) qit.next();
				String questionId = questionObj.getId();
				questionMap.put("id", questionId);
				if(keySet.contains(questionObj.getId())) {//试题在答案集合中
					String questionValue = answerObj.getString(questionId);
					//获取当前题目的分值
					float questionScore = 0;
					if(StringUtils.isBlank(questionValue)) {//在选择记录，但答案为空
						questionMap.put("isCorrect", ExamProperties.QUESTION_ERROR);
						continue;
					}else {
						//将答案保存到数据库
						ExamPaperAnswer examPaperAnswer = new ExamPaperAnswer();
						examPaperAnswer.setQuestionId(questionId);
						examPaperAnswer.setQuestionAnswer(questionValue);
						examPaperAnswer.setExamPaper(examPaper);
						examPaperAnswerDao.save(examPaperAnswer);
						for (Iterator<CurQuestion> iterator = curQuestion.iterator(); iterator.hasNext();) {
							CurQuestion currentQuestion = (CurQuestion) iterator.next();
							if(questionId.equals(currentQuestion.getQuestionId())) {
								questionScore = Float.parseFloat(currentQuestion.getScore());
								break;
							}
							continue;
						}
					}
					
					//对比答案
					//单选题
					String correct_answer = "";//正确答案
					if(ExamProperties.QUESTION_TYPE_SINGLE.equals(questionObj.getType())) {
						List<Option> options = questionObj.getOption();
						for (Iterator<Option> itoption = options.iterator(); itoption.hasNext();) {
							Option option = (Option) itoption.next();
							if("0".equals(option.getOptionIsCorrent())) {
								correct_answer = option.getId();
								break;
							}
							continue;
						}
						
						if(StringUtils.isBlank(questionValue)) {
							questionMap.put("correct_answer", correct_answer);
							continue;
						}
						
						if(!StringUtils.isBlank(correct_answer) && questionValue.equals(correct_answer)) {
							score += questionScore;
							questionMap.put("isCorrect", ExamProperties.QUESTION_CORRECT);
						}else {
							questionMap.put("isCorrect", ExamProperties.QUESTION_ERROR);
						}
						
					}else if(ExamProperties.QUESTION_TYPE_MULTIPLE.equals(questionObj.getType())) {
						List<Option> options = questionObj.getOption();
						Set<String> answer_arr = new HashSet<String>();
						String[] choice_answer = null;
						
						for (Iterator<Option> it_answer = options.iterator(); it_answer.hasNext();) {
							Option answer_option = (Option) it_answer.next();
							if("0".equals(answer_option.getOptionIsCorrent()))
								answer_arr.add(answer_option.getId());
							else
								continue;
						}
						
						correct_answer = StringUtils.join(answer_arr, ",");
						if(StringUtils.isBlank(questionValue)) {
							questionMap.put("correct_answer", correct_answer);
							continue;
						}
						
						choice_answer = questionValue.split(",");
						
						//如果正确的答案在选择的答案中都能找到，且答案个数一样，即为正确
						if(answer_arr.size() == choice_answer.length) {
							boolean isCorrect = true;
							for (String current_answer : answer_arr) {
								if(!questionValue.contains(current_answer)) {//答案错误-选择的答案没有包含所有正确答案就是错误
									isCorrect = false;
									break;
								}
							}
							if(isCorrect) {
								score += questionScore;
								questionMap.put("isCorrect", ExamProperties.QUESTION_CORRECT);
							}else {
								questionMap.put("isCorrect", ExamProperties.QUESTION_ERROR);
							}
						}else {
							questionMap.put("isCorrect", ExamProperties.QUESTION_ERROR);
						}
					}else if(ExamProperties.QUESTION_TYPE_JUDGE.equals(questionObj.getType())) {
						correct_answer = questionObj.getAnswer().getContent().trim();
						
						if(StringUtils.isBlank(questionValue)) {
							questionMap.put("correct_answer", correct_answer);
							continue;
						}
						
						if(!StringUtils.isBlank(correct_answer) && questionValue.equals(correct_answer)) {
							score += questionScore;
							questionMap.put("isCorrect", ExamProperties.QUESTION_CORRECT);
						}else {
							questionMap.put("isCorrect", ExamProperties.QUESTION_ERROR);
						}
					}
					questionMap.put("correct_answer", correct_answer);
					questionMap.put("choice_answer", questionValue);
				}else {//试题没有答案
					questionMap = setNoAnswerResult(questionMap, questionObj);
				}
				questionResults.add(questionMap);
			}
		}
		examStudent.setEndTime(new Date());
		examStudent.setScore(String.valueOf(score));
		examStudentDao.saveAndFlush(examStudent);
		mapObj.put("result", questionResults);
		mapObj.put("score", String.valueOf(score));
		return ResultUtil.success(mapObj);
	}

	private Map<String, String> setNoAnswerResult(Map<String, String> questionMap, Question questionObj) {
		questionMap.put("isCorrect", ExamProperties.QUESTION_ERROR);
		String correct_answer = "";//正确答案
		if(ExamProperties.QUESTION_TYPE_SINGLE.equals(questionObj.getType())) {
			List<Option> options = questionObj.getOption();
			for (Iterator<Option> itoption = options.iterator(); itoption.hasNext();) {
				Option option = (Option) itoption.next();
				if("0".equals(option.getOptionIsCorrent())) {
					correct_answer = option.getId();
					break;
				}
			}
		}else if(ExamProperties.QUESTION_TYPE_MULTIPLE.equals(questionObj.getType())) {
			List<Option> options = questionObj.getOption();
			Set<String> answerSet = new HashSet<String>();
			
			for (Iterator<Option> it_answer = options.iterator(); it_answer.hasNext();) {
				Option answer_option = (Option) it_answer.next();
				if("0".equals(answer_option.getOptionIsCorrent()))
					answerSet.add(answer_option.getId());
			}
			correct_answer = StringUtils.join(answerSet, ",");
		}else if(ExamProperties.QUESTION_TYPE_JUDGE.equals(questionObj.getType())) {
			correct_answer = questionObj.getAnswer().getContent().trim();
		}
		questionMap.put("correct_answer", correct_answer);
		return questionMap;
	}
	
	@Override
	public int getExamRedoTimes(String coursewareId) {
		Course examRule = examRuleXmlService.findExamRule(coursewareId, "imsmanifestext");//获取考试约束参数
		if(ExamProperties.CAN_REDO.equals(examRule.getConstraint().getKsconstraint().getCan_redo())) 
			return examRule.getConstraint().getKsconstraint().getRedoTimes();
		return 0;
	}
}
