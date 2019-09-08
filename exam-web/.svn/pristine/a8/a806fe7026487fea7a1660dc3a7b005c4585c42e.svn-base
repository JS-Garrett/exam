package org.hnjk.jaxb.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;


public class Questiontype implements Serializable{
	/**
	 * 题目类型名称
	 */
	String questionTypeName ;
	/**
	 * 题目序号
	 */
	String index ;
	/**
	 * 题目总分
	 */
	String totalscore ;
	List<CurQuestion> curQuestion;
	
	public String getQuestionTypeName() {
		return questionTypeName;
	}
	@XmlAttribute(required = true)
	public void setQuestionTypeName(String questionTypeName) {
		this.questionTypeName = questionTypeName;
	}
	public String getIndex() {
		return index;
	}
	@XmlAttribute(required = true)
	public void setIndex(String index) {
		this.index = index;
	}
	public String getTotalscore() {
		return totalscore;
	}
	@XmlAttribute(required = true)
	public void setTotalscore(String totalscore) {
		this.totalscore = totalscore;
	}
	public List<CurQuestion> getCurQuestion() {
		return curQuestion;
	}
	public void setCurQuestion(List<CurQuestion> curQuestion) {
		this.curQuestion = curQuestion;
	}
	
	
}
