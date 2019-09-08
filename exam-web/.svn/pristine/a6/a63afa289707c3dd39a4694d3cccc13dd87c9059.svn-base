package org.hnjk.entity;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "exam_student")
public class ExamStudent {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid",strategy = "uuid")
	private String id;
	
	@Column(name="student_code")
	private String studentCode;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="student_sex")
	private String studentSex;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="certificate_type")
	private String certificateType;
	
	@Column(name="certificate_number")
	private String certificateNumber;
	
	@Column(name="examination_card_number")
	private String examinationCardNumber;
	
	@Column(name="exam_time")
	private int examTime;
	
	@Column(name="start_time")
	private Date startTime;
	
	@Column(name="end_time")
	private Date endTime;
	
	@Column(name="courseware_id")
	private String coursewareId;
	
	@Column(name="courseware_name")
	private String coursewareName;
	
	@Column(name="system_code")
	private String systemCode;
	
	@Column(name="score")
	private String score;
	
	@Column(name="create_time")
	private Date createTime;
	
	@Column(name="modify_time")
	private Date modifyTime;
	
	@Column(name="del_flag")
	private char delFlag;
	
	@Column(name="image_path")
	private String imagePath;

	@OneToOne(cascade = CascadeType.ALL,mappedBy="examStudent")
	private ExamPaper examPaper;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStudentCode() {
		return studentCode;
	}

	public void setStudentCode(String studentCode) {
		this.studentCode = studentCode;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSex() {
		return studentSex;
	}

	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getCertificateType() {
		return certificateType;
	}

	public void setCertificateType(String certificateType) {
		this.certificateType = certificateType;
	}

	public String getCertificateNumber() {
		return certificateNumber;
	}

	public void setCertificateNumber(String certificateNumber) {
		this.certificateNumber = certificateNumber;
	}

	public String getExaminationCardNumber() {
		return examinationCardNumber;
	}

	public void setExaminationCardNumber(String examinationCardNumber) {
		this.examinationCardNumber = examinationCardNumber;
	}

	public int getExamTime() {
		return examTime;
	}

	public void setExamTime(int examTime) {
		this.examTime = examTime;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public String getCoursewareId() {
		return coursewareId;
	}

	public void setCoursewareId(String coursewareId) {
		this.coursewareId = coursewareId;
	}

	public String getCoursewareName() {
		return coursewareName;
	}

	public void setCoursewareName(String coursewareName) {
		this.coursewareName = coursewareName;
	}

	public String getSystemCode() {
		return systemCode;
	}

	public void setSystemCode(String systemCode) {
		this.systemCode = systemCode;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Date getModifyTime() {
		return modifyTime;
	}

	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}

	public char getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(char delFlag) {
		this.delFlag = delFlag;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public ExamPaper getExamPaper() {
		return examPaper;
	}

	public void setExamPaper(ExamPaper examPaper) {
		this.examPaper = examPaper;
	}

}
