package org.hnjk.jaxb.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * 试卷XML映射Model
 * @author zxh
 *
 */
@XmlRootElement
public class Paper implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id="";
	Questiontypes questiontypes;
	Questions questions;
	
	public String getId() {
		return id;
	}
	
	@XmlAttribute(required = true)
	public void setId(String id) {
		this.id = id;
	}
	public Questiontypes getQuestiontypes() {
		return questiontypes;
	}
	public void setQuestiontypes(Questiontypes questiontypes) {
		this.questiontypes = questiontypes;
	}
	public Questions getQuestions() {
		return questions;
	}
	public void setQuestions(Questions questions) {
		this.questions = questions;
	}
	
	
}
