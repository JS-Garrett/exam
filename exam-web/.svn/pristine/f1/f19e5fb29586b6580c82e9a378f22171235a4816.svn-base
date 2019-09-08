package org.hnjk.service.impl;

import org.hnjk.jaxb.model.Course;
import org.hnjk.jaxb.util.CourseXmlConvertUtils;
import org.hnjk.service.ExamRuleXmlService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @ClassName: CourseXmlServiceImpl 
 * @Description: 课件xml服务实现类
 * @author ywx 
 * @date 2016-3-28 下午2:22:37
 */
@Service
@Transactional
public class ExamRuleXmlServiceImpl implements ExamRuleXmlService {
	@Value("${resourceIPAddress}")
	private String resourceUrl;

	/**
	 * 获取当前行为的配置xml
	 * @param coursewareId
	 * @param string
	 * @return
	 */
	@Override
	public Course findExamRule(String coursewareId,String xmlName) {
		String filePath = resourceUrl+coursewareId+"/"+xmlName+".xml";
		Course examRule = CourseXmlConvertUtils.examRuleXmlToHtml(filePath.replaceAll("\\\\","/"));
		return examRule;
	}
}
