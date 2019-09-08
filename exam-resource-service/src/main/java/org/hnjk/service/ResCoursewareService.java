package org.hnjk.service;

import java.util.List;
import org.hnjk.entity.ResCoursewareObject;
import org.springframework.data.domain.Pageable;

public interface ResCoursewareService {
	public String getCoursewareIdByCoursewareCode(String coursewareCode);
	public List<ResCoursewareObject> getCoursewareList(String queryCondition, Pageable pageable);
}
