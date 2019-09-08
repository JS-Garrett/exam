package org.hnjk.dao;

import org.hnjk.entity.ResCourseware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ResCoursewareDao extends JpaRepository<ResCourseware, String> {
	@Query(value="select id from res_courseware where courseware_code=:coursewareCode limit 1",nativeQuery=true)
	public String getCoursewareIdByCoursewareCode(@Param("coursewareCode")String coursewareCode);
}
