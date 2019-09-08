package org.hnjk.jaxb.model;

import javax.xml.bind.annotation.XmlAttribute;
/**
 * 课件描述
 * @author zxh
 *
 */
public class Metadata implements java.io.Serializable{
	/**
	 * 支持的标准，默认为SCORM标准
	 */
	String schema="ADL SCORM";
	/**
	 * 标准的版本号：默认为1.2版本
	 */
	String schemaversion = "1.2";
	
	
	public Metadata() {
		super();
	}
	
	public String getSchema() {
		return schema;
	}
	@XmlAttribute(required = true)
	public void setSchema(String schema) {
		this.schema = schema;
	}
	public String getSchemaversion() {
		return schemaversion;
	}
	@XmlAttribute(required = true)
	public void setSchemaversion(String schemaversion) {
		this.schemaversion = schemaversion;
	}
	
	
}
