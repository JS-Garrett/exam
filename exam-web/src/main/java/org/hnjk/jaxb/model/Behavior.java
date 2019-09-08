package org.hnjk.jaxb.model;

import javax.xml.bind.annotation.XmlAttribute;

public class Behavior {
	String identifier;
	String name;
	
	
	public String getIdentifier() {
		return identifier;
	}
	@XmlAttribute(required = true)
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getName() {
		return name;
	}
	@XmlAttribute(required = true)
	public void setName(String name) {
		this.name = name;
	}
	 
	

}
