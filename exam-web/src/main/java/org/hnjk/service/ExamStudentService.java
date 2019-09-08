package org.hnjk.service;

import java.util.List;

import org.hnjk.entity.ExamStudent;

public interface ExamStudentService {
	/**
	 * @Title 根据课件id和学生code返回ExamStudent对象
	 * @param
	 * @return List
	 * 
	 */
	public List<ExamStudent> findExamStudentByCoursewareIdAndStudentCode(String coursewareId, String studentCode);
	
	/**
	 * 获取学生本门考试的最高成绩
	 * @param coursewareId
	 * @param accountId
	 * @return
	 */
	public float getMaxScore(String coursewareId, String accountId);
	
	/**
	 * 根据学生id获取学生对象
	 * @param id
	 * @return
	 */
	public ExamStudent getExamStudentById(String id);

}
