package org.hnjk.service;

public interface ExamPaperAnswerService {
	public void saveAnswer(String paperId, String answerStr);
	
	public String getAnswerByPaperId(String paperId);
	
	public void saveMark(String paperId, String mark);
	
	public String getMarkQuestionsByPaperId(String paperId); 
}
