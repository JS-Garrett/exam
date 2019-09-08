package org.hnjk.jaxb.model;


import java.util.List;

import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**   
 * @Title: Model
 * @Description: 题型规则表
 * @author zhangwenhai
 * @date 2015-12-29 16:18:01
 * @version V1.0   
 *
 */
@Table(name = "res_question_type_rule", schema = "")
@DynamicUpdate(true)
@DynamicInsert(true)
@SuppressWarnings("serial")
public class ResQuestionTypeRuleModel implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**成卷规则主键*/
	private java.lang.String paperRuleId;
	/**试卷题型*/
	private java.lang.String paperQuestionType;
	/**题型排序*/
	private java.lang.Integer sortCode;
	/**总分值*/
	private Double totalScore;
	/**默认每题分值*/
	private Double singleQuestionScore;
	/**题目主键集合*/
	private List<QuestionModel> question;
	
	public java.lang.String getId(){
		return this.id;
	}
	
	@XmlAttribute(required = true)
	public void setId(java.lang.String id){
		this.id = id;
	}
	
	public java.lang.String getPaperRuleId(){
		return this.paperRuleId;
	}
	
	@XmlAttribute(required = true)
	public void setPaperRuleId(java.lang.String paperRuleId){
		this.paperRuleId = paperRuleId;
	}
	
	public java.lang.String getPaperQuestionType(){
		return this.paperQuestionType;
	}
	
	@XmlAttribute(required = true)
	public void setPaperQuestionType(java.lang.String paperQuestionType){
		this.paperQuestionType = paperQuestionType;
	}
	public java.lang.Integer getSortCode(){
		return this.sortCode;
	}
	
	@XmlAttribute(required = true)
	public void setSortCode(java.lang.Integer sortCode){
		this.sortCode = sortCode;
	}
	
	public Double getTotalScore(){
		return this.totalScore;
	}
	
	@XmlAttribute(required = true)
	public void setTotalScore(Double totalScore){
		this.totalScore = totalScore;
	}
	
	public Double getSingleQuestionScore(){
		return this.singleQuestionScore;
	}
	
	@XmlAttribute(required = true)
	public void setSingleQuestionScore(Double singleQuestionScore){
		this.singleQuestionScore = singleQuestionScore;
	}

	public List<QuestionModel> getQuestion() {
		return question;
	}

	public void setQuestion(List<QuestionModel> question) {
		this.question = question;
	}

}
