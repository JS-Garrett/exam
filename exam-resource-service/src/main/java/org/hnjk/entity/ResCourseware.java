package org.hnjk.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="res_courseware")
public class ResCourseware {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid",strategy = "uuid")
	private String id;
	
	@Column(name="courseware_code")
	private String coursewareCode;
	
	@Column(name="courseware_name")
	private String coursewareName;
	
	@Column(name="courseware_type")
	private String coursewareType;
	
	@Column(name="belong_org_id")
	private String belongOrgId;
	
	@Column(name="belong_project")
	private String belongProject;
	
	@Column(name="belong_subject_id")
	private String belongSubjectId;
	
	@Column(name="belong_subject_name")
	private String belongSubjectName;
	
	@Column(name="courseware_abstract")
	private String coursewareAbstract;
	
	@Column(name="learning_target")
	private String learningTarget;
	
	@Column(name="applicable_objects")
	private String applicableObjects;
	
	@Column(name="total_periods")
	private float totalPeriods;
	
	@Column(name="single_period_hours")
	private String singlePeriodHours;
	
	@Column(name="big_theme_img_path")
	private String bigThemeImgPath;
	
	@Column(name="middle_theme_img_path")
	private String middle_theme_img_path;
	
	@Column(name="small_theme_img_path")
	private String smallThemeImgPath;
	
	@Column(name="background_color")
	private String backgroundColor;
	
	@Column(name="courseware_status")
	private String coursewareStatus;
	
	@Column(name="show_nav")
	private String showNav;
	
	@Column(name="show_summarize")
	private String showSummarize;
	
	@Column(name="show_courseware")
	private String showCourseware;
	
	@Column(name="show_work")
	private String showWork;
	
	@Column(name="show_community")
	private String showCommunity;
	
	@Column(name="show_schedules")
	private String showSchedules;
	
	@Column(name="show_message")
	private String showMessage;
	
	@Column(name="show_notice")
	private String showNotice;
	
	@Column(name="show_ask")
	private String showAsk;
	
	@Column(name="show_share")
	private String showShare;
	
	@Column(name="show_evaluate")
	private String showEvaluate;
	
	@Column(name="show_schedule")
	private String showSchedule;
	
	@Column(name="publish_time")
	private Date publishTime;
	
	@Column(name="keywords")
	private String keywords;
	
	@Column(name="create_date")
	private Date createDate;
	
	@Column(name="create_username")
	private String createUsername;
	
	@Column(name="create_userid")
	private String createUserid;
	
	@Column(name="modify_date")
	private Date modifyDate;
	
	@Column(name="modify_username")
	private String modifyUsername;
	
	@Column(name="modify_userid")
	private String modifyUserid;
	
	@Column(name="del_flag")
	private String delFlag;
	
	@Column(name="system_org_id")
	private String systemOrgId;
	
	@Column(name="belong_system_id")
	private String belongSystemId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCoursewareCode() {
		return coursewareCode;
	}

	public void setCoursewareCode(String coursewareCode) {
		this.coursewareCode = coursewareCode;
	}

	public String getCoursewareName() {
		return coursewareName;
	}

	public void setCoursewareName(String coursewareName) {
		this.coursewareName = coursewareName;
	}

	public String getCoursewareType() {
		return coursewareType;
	}

	public void setCoursewareType(String coursewareType) {
		this.coursewareType = coursewareType;
	}

	public String getBelongOrgId() {
		return belongOrgId;
	}

	public void setBelongOrgId(String belongOrgId) {
		this.belongOrgId = belongOrgId;
	}

	public String getBelongProject() {
		return belongProject;
	}

	public void setBelongProject(String belongProject) {
		this.belongProject = belongProject;
	}

	public String getBelongSubjectId() {
		return belongSubjectId;
	}

	public void setBelongSubjectId(String belongSubjectId) {
		this.belongSubjectId = belongSubjectId;
	}

	public String getBelongSubjectName() {
		return belongSubjectName;
	}

	public void setBelongSubjectName(String belongSubjectName) {
		this.belongSubjectName = belongSubjectName;
	}

	public String getCoursewareAbstract() {
		return coursewareAbstract;
	}

	public void setCoursewareAbstract(String coursewareAbstract) {
		this.coursewareAbstract = coursewareAbstract;
	}

	public String getLearningTarget() {
		return learningTarget;
	}

	public void setLearningTarget(String learningTarget) {
		this.learningTarget = learningTarget;
	}

	public String getApplicableObjects() {
		return applicableObjects;
	}

	public void setApplicableObjects(String applicableObjects) {
		this.applicableObjects = applicableObjects;
	}

	public float getTotalPeriods() {
		return totalPeriods;
	}

	public void setTotalPeriods(float totalPeriods) {
		this.totalPeriods = totalPeriods;
	}

	public String getSinglePeriodHours() {
		return singlePeriodHours;
	}

	public void setSinglePeriodHours(String singlePeriodHours) {
		this.singlePeriodHours = singlePeriodHours;
	}

	public String getBigThemeImgPath() {
		return bigThemeImgPath;
	}

	public void setBigThemeImgPath(String bigThemeImgPath) {
		this.bigThemeImgPath = bigThemeImgPath;
	}

	public String getMiddle_theme_img_path() {
		return middle_theme_img_path;
	}

	public void setMiddle_theme_img_path(String middle_theme_img_path) {
		this.middle_theme_img_path = middle_theme_img_path;
	}

	public String getSmallThemeImgPath() {
		return smallThemeImgPath;
	}

	public void setSmallThemeImgPath(String smallThemeImgPath) {
		this.smallThemeImgPath = smallThemeImgPath;
	}

	public String getBackgroundColor() {
		return backgroundColor;
	}

	public void setBackgroundColor(String backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	public String getCoursewareStatus() {
		return coursewareStatus;
	}

	public void setCoursewareStatus(String coursewareStatus) {
		this.coursewareStatus = coursewareStatus;
	}

	public String getShowNav() {
		return showNav;
	}

	public void setShowNav(String showNav) {
		this.showNav = showNav;
	}

	public String getShowSummarize() {
		return showSummarize;
	}

	public void setShowSummarize(String showSummarize) {
		this.showSummarize = showSummarize;
	}

	public String getShowCourseware() {
		return showCourseware;
	}

	public void setShowCourseware(String showCourseware) {
		this.showCourseware = showCourseware;
	}

	public String getShowWork() {
		return showWork;
	}

	public void setShowWork(String showWork) {
		this.showWork = showWork;
	}

	public String getShowCommunity() {
		return showCommunity;
	}

	public void setShowCommunity(String showCommunity) {
		this.showCommunity = showCommunity;
	}

	public String getShowSchedules() {
		return showSchedules;
	}

	public void setShowSchedules(String showSchedules) {
		this.showSchedules = showSchedules;
	}

	public String getShowMessage() {
		return showMessage;
	}

	public void setShowMessage(String showMessage) {
		this.showMessage = showMessage;
	}

	public String getShowNotice() {
		return showNotice;
	}

	public void setShowNotice(String showNotice) {
		this.showNotice = showNotice;
	}

	public String getShowAsk() {
		return showAsk;
	}

	public void setShowAsk(String showAsk) {
		this.showAsk = showAsk;
	}

	public String getShowShare() {
		return showShare;
	}

	public void setShowShare(String showShare) {
		this.showShare = showShare;
	}

	public String getShowEvaluate() {
		return showEvaluate;
	}

	public void setShowEvaluate(String showEvaluate) {
		this.showEvaluate = showEvaluate;
	}

	public String getShowSchedule() {
		return showSchedule;
	}

	public void setShowSchedule(String showSchedule) {
		this.showSchedule = showSchedule;
	}

	public Date getPublishTime() {
		return publishTime;
	}

	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}

	public String getKeywords() {
		return keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUsername() {
		return createUsername;
	}

	public void setCreateUsername(String createUsername) {
		this.createUsername = createUsername;
	}

	public String getCreateUserid() {
		return createUserid;
	}

	public void setCreateUserid(String createUserid) {
		this.createUserid = createUserid;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getModifyUsername() {
		return modifyUsername;
	}

	public void setModifyUsername(String modifyUsername) {
		this.modifyUsername = modifyUsername;
	}

	public String getModifyUserid() {
		return modifyUserid;
	}

	public void setModifyUserid(String modifyUserid) {
		this.modifyUserid = modifyUserid;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getSystemOrgId() {
		return systemOrgId;
	}

	public void setSystemOrgId(String systemOrgId) {
		this.systemOrgId = systemOrgId;
	}

	public String getBelongSystemId() {
		return belongSystemId;
	}

	public void setBelongSystemId(String belongSystemId) {
		this.belongSystemId = belongSystemId;
	}
}
