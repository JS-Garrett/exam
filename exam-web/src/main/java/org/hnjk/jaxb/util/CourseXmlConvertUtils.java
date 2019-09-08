package org.hnjk.jaxb.util;

import org.hnjk.jaxb.model.Course;
import org.hnjk.jaxb.model.Paper;
import org.hnjk.util.JaxbUtil;

/**   
 * @Title: 文件名:PaperTemplateXmlConvertUtils 项目: v4-resoutce  
 * @Description:  课程模板XML转换工具
 * @author zhouwenhai
 * @date 2016-1-21 上午14:40:00
 * @version V1.0   
 *
 */
public class CourseXmlConvertUtils {

	/**
	 * 1.导入xml文件（5份） 获取 行为名称 和 状态  第一 到 第五套 
	 * 2.解析文件 
	 *   1：获取题型  （单选，多选，题目数量）
	 *   2：获取题目主干（内容，选项，解析，答案）
	 * */
	
	public static Paper paperXmlToHtml(String filePath){
		Paper paper = JaxbUtil.converyToJavaBean(filePath,Paper.class);
		return paper;
	}
	
	public static Paper paperXmlToHtmlByURL(String filePath){
		Paper paper = JaxbUtil.converyToJavaBeanByURL(filePath,Paper.class);
		return paper;
	}
	
	/*public static Manifest courseXmlToHtmlByURL(String filePath){
		Manifest manifest = JaxbUtil.converyToJavaBeanByURL(filePath,Manifest.class);
		return manifest;
	}*/

	public static Course examRuleXmlToHtml(String filePath){
		Course examRule = JaxbUtil.converyToJavaBeanByURL(filePath,Course.class);
		return examRule;
	}
	/**
	 * 练习答题卡
	 * @param filePath
	 * @return
	 */
	/*public static ExerciseCard exerciseCardXmlToHtml(String filePath){
		ExerciseCard exerciseCard = JaxbUtil.converyToJavaBeanByURL(filePath,ExerciseCard.class);
		return exerciseCard;
	}*/
}
