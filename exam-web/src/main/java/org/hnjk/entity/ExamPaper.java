package org.hnjk.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="exam_paper")
public class ExamPaper {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid",strategy = "uuid")
	private String id;
	
	@Column(name="courseware_code")
	private String coursewareCode;
	
	@Column(name="paper_url")
	private String paperUrl;
	
	@Column(name="create_date")
	private Date createDate;
	
	@OneToOne(cascade = { CascadeType.ALL })
	@JoinColumn(name = "student_id")
	private ExamStudent examStudent;
	
	@OneToMany(mappedBy="examPaper", cascade = CascadeType.ALL)
	private Set<ExamPaperAnswer> examPaperAnswer;
	
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
	public String getPaperUrl() {
		return paperUrl;
	}
	public void setPaperUrl(String paperUrl) {
		this.paperUrl = paperUrl;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public ExamStudent getExamStudent() {
		return examStudent;
	}
	public void setExamStudent(ExamStudent examStudent) {
		this.examStudent = examStudent;
	}
	public Set<ExamPaperAnswer> getExamPaperAnswer() {
		return examPaperAnswer;
	}
	public void setExamPaperAnswer(Set<ExamPaperAnswer> examPaperAnswer) {
		this.examPaperAnswer = examPaperAnswer;
	}
}
