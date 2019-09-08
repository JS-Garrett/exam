package org.hnjk.service;

import java.util.Map;

import org.hnjk.entity.ExamStudent;
import org.hnjk.entity.Result;
import org.hnjk.jaxb.model.Course;
import org.hnjk.jaxb.model.Paper;

public interface ExamPaperService {
	/**
	 * 获取试卷
	 * @param examRule
	 * @param paperFileName
	 * @param examStudent
	 * @param isContinue
	 * @return
	 */
	public Map<String, Object> getExamPaper(Course examRule, String paperFileName, ExamStudent examStudent, String isContinue);
	
	public Paper getPaperById(String paperId);
	
	public Result inspectPaper(String paperId, Paper paper);
	
	/**
	 * 获取考试重做次数
	 * @param coursewareId
	 * @param behaviorId
	 * @return
	 */
	public int getExamRedoTimes(String coursewareId);
}
