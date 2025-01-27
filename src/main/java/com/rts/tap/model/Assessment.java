package com.rts.tap.model;

import java.sql.Date;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Assessment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long assessmentId;

	private String assessmentName;

	private String assessmentLink;

	private String assessmentType;

	@ManyToOne
	private RecruitmentProcess recruitmentProcess;

	private Date assessmentStartDate;

	private Date assessmentEndDate;

	private LocalTime assessmentStartTime;

	private LocalTime assessmentEndTime;

	public Assessment() {
		super();
	}

	public Long getAssessmentId() {
		return assessmentId;
	}

	public void setAssessmentId(Long assessmentId) {
		this.assessmentId = assessmentId;
	}

	public String getAssessmentName() {
		return assessmentName;
	}

	public void setAssessmentName(String assessmentName) {
		this.assessmentName = assessmentName;
	}

	public String getAssessmentLink() {
		return assessmentLink;
	}

	public void setAssessmentLink(String assessmentLink) {
		this.assessmentLink = assessmentLink;
	}

	public String getAssessmentType() {
		return assessmentType;
	}

	public void setAssessmentType(String assessmentType) {
		this.assessmentType = assessmentType;
	}

	public RecruitmentProcess getRecruitmentProcess() {
		return recruitmentProcess;
	}

	public void setRecruitmentProcess(RecruitmentProcess recruitmentProcess) {
		this.recruitmentProcess = recruitmentProcess;
	}

	public Date getAssessmentStartDate() {
		return assessmentStartDate;
	}

	public void setAssessmentStartDate(Date assessmentStartDate) {
		this.assessmentStartDate = assessmentStartDate;
	}

	public Date getAssessmentEndDate() {
		return assessmentEndDate;
	}

	public void setAssessmentEndDate(Date assessmentEndDate) {
		this.assessmentEndDate = assessmentEndDate;
	}

	public LocalTime getAssessmentStartTime() {
		return assessmentStartTime;
	}

	public void setAssessmentStartTime(LocalTime assessmentStartTime) {
		this.assessmentStartTime = assessmentStartTime;
	}

	public LocalTime getAssessmentEndTime() {
		return assessmentEndTime;
	}

	public void setAssessmentEndTime(LocalTime assessmentEndTime) {
		this.assessmentEndTime = assessmentEndTime;
	}
}
