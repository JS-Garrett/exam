package org.hnjk.jaxb.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Resource implements java.io.Serializable{
	/**
	 * 资源
	 */
	File file;
	String identifier;
	String type = "webcontent";
	String href;
	/**完成情况   0：未开始 1：进行中 2：已完成*/
	String finishStatus;
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	
	public String getIdentifier() {
		return identifier;
	}
	@XmlAttribute(required = true)
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getType() {
		return type;
	}
	@XmlAttribute(required = true)
	public void setType(String type) {
		this.type = type;
	}
	public String getHref() {
		return href;
	}
	@XmlAttribute(required = true)
	public void setHref(String href) {
		this.href = href;
	}
	public String getFinishStatus() {
		return finishStatus;
	}
	public void setFinishStatus(String finishStatus) {
		this.finishStatus = finishStatus;
	}
	
}
