package org.hnjk.jaxb.model;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
/**
 * 题目
 * @author zxh
 *
 */
public class Question implements Serializable{
	/**
	 * 题目ID
	 */
	String id;
	/**
	 * 父题目ID
	 */
	String parentid;
	/**
	 * 题目类型
	 */
	String type;
	/**
	 * 提干
	 */
	String content;
	
	/**
	 * 已做
	 */
	String done;
	
	/**
	 * 判断题选择0或1
	 */
	String choice;
	
	/**
	 * 题目标记
	 */
	String marked;
	
	/**
	 * 题目选项
	 */
	List<Option> option;
	/**
	 * 题目参考答案
	 */
	Answer answer;
	/**
	 * 题目解析
	 */
	Explain explain;
	List<Coursenodes> coursenodes;
	
	
	public String getId() {
		return id;
	}
	@XmlAttribute(required = true)
	public void setId(String id) {
		this.id = id;
	}
	public String getParentid() {
		return parentid;
	}
	@XmlAttribute(required = true)
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}

	public String getType() {
		return type;
	}
	@XmlAttribute(required = true)
	public void setType(String type) {
		this.type = type;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<Option> getOption() {
		return option;
	}
	public void setOption(List<Option> option) {
		this.option = option;
	}
	public Answer getAnswer() {
		return answer;
	}
	public void setAnswer(Answer answer) {
		this.answer = answer;
	}
	public Explain getExplain() {
		return explain;
	}
	public void setExplain(Explain explain) {
		this.explain = explain;
	}
	public List<Coursenodes> getCoursenodes() {
		return coursenodes;
	}
	public void setCoursenodes(List<Coursenodes> coursenodes) {
		this.coursenodes = coursenodes;
	}
	public String getDone() {
		return done;
	}
	public void setDone(String done) {
		this.done = done;
	}
	public String getChoice() {
		return choice;
	}
	public void setChoice(String choice) {
		this.choice = choice;
	}
	public String getMarked() {
		return marked;
	}
	public void setMarked(String marked) {
		this.marked = marked;
	}
	

}
