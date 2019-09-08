package org.hnjk.jaxb.model;

import javax.xml.bind.annotation.XmlAttribute;

public class File implements java.io.Serializable{
	String href = "";

	public String getHref() {
		return href;
	}
	@XmlAttribute(required = true)
	public void setHref(String href) {
		this.href = href;
	}
	
	
}
