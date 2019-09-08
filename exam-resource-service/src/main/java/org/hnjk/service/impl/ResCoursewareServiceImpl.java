package org.hnjk.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.lang.StringUtils;
import org.hibernate.query.internal.NativeQueryImpl;
import org.hibernate.transform.Transformers;
import org.hnjk.dao.ResCoursewareDao;
import org.hnjk.entity.ResCoursewareObject;
import org.hnjk.service.ResCoursewareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ResCoursewareServiceImpl implements ResCoursewareService {

	@Autowired
	private ResCoursewareDao resCoursewareDao;
	
	@PersistenceContext
    private EntityManager entityManager;
	
	@Override
	public String getCoursewareIdByCoursewareCode(String coursewareCode) {
		return resCoursewareDao.getCoursewareIdByCoursewareCode(coursewareCode);
	}

	@Override
	public List<ResCoursewareObject> getCoursewareList(String queryCondition, Pageable pageable) {
		StringBuilder querySql = new StringBuilder("select courseware_code as coursewareCode, courseware_name as coursewareName, courseware_type as coursewareType, total_periods as totalPeriods from res_courseware where courseware_status=1");
		Map<String, String> params = new HashMap<String, String>();
		if(StringUtils.isNotBlank(queryCondition)) {
			querySql.append(" and (courseware_code like :condition or courseware_name like :courseName or courseware_type=:courseType)");
			params.put("condition", "%"+queryCondition+"%");
			params.put("courseName", "%"+queryCondition+"%");
			params.put("courseType", queryCondition);
		}
		
		Query query = entityManager.createNativeQuery(querySql.toString());
		query.unwrap(NativeQueryImpl.class).setResultTransformer(Transformers.aliasToBean(ResCoursewareObject.class));
		
		if(params!=null)
			params.keySet().forEach(key->query.setParameter(key, params.get(key)));
		
		query.setFirstResult(pageable.getPageNumber());
		query.setMaxResults(pageable.getPageSize());
		@SuppressWarnings("unchecked")
		List<ResCoursewareObject> objs = query.getResultList();
		return objs;
	}

}
