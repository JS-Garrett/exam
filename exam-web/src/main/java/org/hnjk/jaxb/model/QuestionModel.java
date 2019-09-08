package org.hnjk.jaxb.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class QuestionModel implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**题目主键*/
	private java.lang.String id;
	/**所属节点主键*/
	private java.lang.String questionIndex;
	/**题目题型*/
	private java.lang.String questionType;
	
	public java.lang.String getId() {
		return id;
	}
	public java.lang.String getQuestionIndex() {
		return questionIndex;
	}
	@XmlAttribute(required = true)
	public void setId(java.lang.String id) {
		this.id = id;
	}
	
	@XmlAttribute(required = true)
	public void setQuestionIndex(java.lang.String questionIndex) {
		this.questionIndex = questionIndex;
	}
	
	public java.lang.String getQuestionType() {
		return questionType;
	}
	@XmlAttribute(required = true)
	public void setQuestionType(java.lang.String questionType) {
		this.questionType = questionType;
	}

	
}
