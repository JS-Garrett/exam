package org.hnjk.jaxb.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * 试卷题型下的题目
 * @author zxh
 *
 */
public class CurQuestion implements Serializable{
	/**
	 * 题目ID
	 */
	String questionId;
	/**
	 * 序号
	 */
	String index;
	/**
	 * 题目在当前试卷中的分数
	 */
	String score;
	
	/**
	 * 已做
	 */
	String done;
	
	/**
	 * 题目标记
	 */
	String marked;
	
	public String getQuestionId() {
		return questionId;
	}
	@XmlAttribute(required = true)
	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}
	public String getIndex() {
		return index;
	}
	@XmlAttribute(required = true)
	public void setIndex(String index) {
		this.index = index;
	}
	public String getScore() {
		return score;
	}
	@XmlAttribute(required = true)
	public void setScore(String score) {
		this.score = score;
	}
	public String getDone() {
		return done;
	}
	public void setDone(String done) {
		this.done = done;
	}
	public String getMarked() {
		return marked;
	}
	public void setMarked(String marked) {
		this.marked = marked;
	}
	
	
	
}
