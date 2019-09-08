package org.hnjk.service.impl;

import java.util.List;

import org.hnjk.dao.ExamStudentDao;
import org.hnjk.entity.ExamStudent;
import org.hnjk.service.ExamStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public  class ExamStudentServiceImpl implements ExamStudentService {
	
	@Autowired
	private ExamStudentDao examStudentDao;
	
	@Override
	public List<ExamStudent> findExamStudentByCoursewareIdAndStudentCode(String coursewareId, String studentCode) {
		return examStudentDao.findByCoursewareIdAndStudentCode(coursewareId,studentCode);
	}

	@Override
	public float getMaxScore(String coursewareId, String accountId) {
		
        return examStudentDao.getMaxScore(coursewareId, accountId);
	}

	@Override
	public ExamStudent getExamStudentById(String id) {
		return examStudentDao.getOne(id);
	}
	
}
