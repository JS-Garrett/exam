package org.hnjk.jaxb.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
/**
 * 课件模块的结构
 * @author zxh
 *
 */
public class Organization {
	/**
	 * ID
	 */
	String identifier;
	/**
	 * 课件模块的结构类型，默认为hierarchical  树形结构
	 */
	String structure="hierarchical";
	/**
	 * 标题
	 */
	String title;
	/**
	 * 课件模块的子项
	 */
	List<Item> item;
	/**显示须知*/
	//private java.lang.String showNotice;
	/**显示进度*/
	//private java.lang.String showSchedule;
	/**显示评价*/
	//private java.lang.String showEvaluate;
	/**显示提问*/
	//private java.lang.String showAsk;
	/**显示分享*/
	//private java.lang.String showShare;
	
	/**显示导航栏*/
	private java.lang.String showNav;
	/**显示概况*/
	private java.lang.String showSummarize;
	/**显示课件*/
	private java.lang.String showCourseware;
	/**显示作业*/
	private java.lang.String showWork;
	/**显示社区*/
	private java.lang.String showCommunity;
	/**显示进度*/
	private java.lang.String showSchedule;
	/**显示通知*/
	private java.lang.String showMessage;
	
	public Organization(){
		
	}
	public String getIdentifier() {
		return identifier;
	}
	@XmlAttribute(required = true)
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getStructure() {
		return structure;
	}
	@XmlAttribute(required = true)
	public void setStructure(String structure) {
		this.structure = structure;
	}
	
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	
	
	/*public java.lang.String getShowNotice() {
		return showNotice;
	}
	public java.lang.String getShowSchedule() {
		return showSchedule;
	}
	public java.lang.String getShowEvaluate() {
		return showEvaluate;
	}
	public java.lang.String getShowAsk() {
		return showAsk;
	}
	public java.lang.String getShowShare() {
		return showShare;
	}
	@XmlAttribute(required = true)
	public void setShowNotice(java.lang.String showNotice) {
		this.showNotice = showNotice;
	}
	@XmlAttribute(required = true)
	public void setShowSchedule(java.lang.String showSchedule) {
		this.showSchedule = showSchedule;
	}
	@XmlAttribute(required = true)
	public void setShowEvaluate(java.lang.String showEvaluate) {
		this.showEvaluate = showEvaluate;
	}
	@XmlAttribute(required = true)
	public void setShowAsk(java.lang.String showAsk) {
		this.showAsk = showAsk;
	}
	@XmlAttribute(required = true)
	public void setShowShare(java.lang.String showShare) {
		this.showShare = showShare;
	}*/
	public java.lang.String getShowNav() {
		return showNav;
	}
	public java.lang.String getShowSummarize() {
		return showSummarize;
	}
	public java.lang.String getShowCourseware() {
		return showCourseware;
	}
	public java.lang.String getShowWork() {
		return showWork;
	}
	public java.lang.String getShowCommunity() {
		return showCommunity;
	}
	public java.lang.String getShowSchedule() {
		return showSchedule;
	}
	public java.lang.String getShowMessage() {
		return showMessage;
	}
	@XmlAttribute(required = true)
	public void setShowNav(java.lang.String showNav) {
		this.showNav = showNav;
	}
	@XmlAttribute(required = true)
	public void setShowSummarize(java.lang.String showSummarize) {
		this.showSummarize = showSummarize;
	}
	@XmlAttribute(required = true)
	public void setShowCourseware(java.lang.String showCourseware) {
		this.showCourseware = showCourseware;
	}
	@XmlAttribute(required = true)
	public void setShowWork(java.lang.String showWork) {
		this.showWork = showWork;
	}
	@XmlAttribute(required = true)
	public void setShowCommunity(java.lang.String showCommunity) {
		this.showCommunity = showCommunity;
	}
	@XmlAttribute(required = true)
	public void setShowSchedule(java.lang.String showSchedule) {
		this.showSchedule = showSchedule;
	}
	@XmlAttribute(required = true)
	public void setShowMessage(java.lang.String showMessage) {
		this.showMessage = showMessage;
	}
}
