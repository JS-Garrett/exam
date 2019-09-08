package org.hnjk.dao;

import java.util.List;

import org.hnjk.entity.ExamStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExamStudentDao extends JpaRepository<ExamStudent, String> {
	/**
	 * @Title 根据课件id和学生id返回ExamStudent对象集合
	 * @return List
	 * @param
	 * 
	 * */
	List<ExamStudent> findByCoursewareIdAndStudentCode(String coursewareId, String studentCode);
	
	/**
	 * @Title 根据课件id和学生id获得这个学生的降序数据集合
	 * @return List
	 * @param
	 * */
	@Query(value="select max(score) from exam_student where courseware_id=:coursewareId and student_code=:studentCode",nativeQuery=true)
	float getMaxScore(@Param("coursewareId")String coursewareId, @Param("studentCode")String studentCode);
	
}
