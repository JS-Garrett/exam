package org.hnjk.jaxb.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
/**
 * 
 * @author zxh
 *	课件结构
 */
public class Organizations implements java.io.Serializable{
	/**
	 * 默认的显示模块，默认为sy
	 */
	String defult="sy";
	/**
	 * 课件结构，一般一个课件包含课件首页、课件架构两个结构
	 */
	List<Organization> organization;
	
	public Organizations(){
		
	}
	
	public String getDefult() {
		return defult;
	}
	
	@XmlAttribute(required = true)
	public void setDefult(String defult) {
		this.defult = defult;
	}

	public List<Organization> getOrganization() {
		return organization;
	}

	public void setOrganization(List<Organization> organization) {
		this.organization = organization;
	}
	
}
