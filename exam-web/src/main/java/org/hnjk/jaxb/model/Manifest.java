package org.hnjk.jaxb.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * 
 * @author zxh
 * 资源包Srcom标准XML映射Model
 */
@XmlRootElement
public class Manifest implements java.io.Serializable{
	/**
	 * 课件ID
	 */
	String identifier="";
	/**
	 * 发布时间
	 */
	String publishTime;
	/**
	 * 课件版本号，没有版本控制的课件默认为1.0
	 */
	String version="1.0"; 
	/**
	 * 课件包描述
	 */
	Metadata metadata;
	/**
	 * 课件结构，一般一个课件包含课件首页、课件架构两个结构
	 */
	Organizations organizations ;
	/**
	 * 课件资源
	 */
	Resources resources;
	
	public Manifest() {
		super();
	}
	public String getIdentifier() {
		return identifier;
	}
	@XmlAttribute(required = true)
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getVersion() {
		return version;
	}
	@XmlAttribute(required = true)
	public void setVersion(String version) {
		this.version = version;
	}
	public Metadata getMetadata() {
		return metadata;
	}
	public void setMetadata(Metadata metadata) {
		this.metadata = metadata;
	}

	public Organizations getOrganizations() {
		return organizations;
	}

	public void setOrganizations(Organizations organizations) {
		this.organizations = organizations;
	}
	public Resources getResources() {
		return resources;
	}
	public void setResources(Resources resources) {
		this.resources = resources;
	}	
	
	public String getPublishTime() {
		return publishTime;
	}
	@XmlAttribute(required = true)
	public void setPublishTime(String publishTime) {
		this.publishTime = publishTime;
	}	
}
