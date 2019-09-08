package org.hnjk.entity;

import java.math.BigDecimal;

public class ResCoursewareObject {
	private String coursewareCode;
	private String coursewareName;
	private String coursewareType;
	private BigDecimal totalPeriods;
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
	public BigDecimal getTotalPeriods() {
		return totalPeriods;
	}
	public void setTotalPeriods(BigDecimal totalPeriods) {
		this.totalPeriods = totalPeriods;
	}
}
