package com.rts.tap.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class RecruitmentProcess {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recruitmentProcessId;

	@ManyToOne
	private MRF mrf;

	private int level;

	private String recruitmentProcessType;

	private String recruitmentProcessName;

	@OneToMany
	private List<Interviewer> interviewer;

	private String report;

	private String completedStatus;

	public RecruitmentProcess() {
		super();
	}

	public Long getRecruitmentProcessId() {
		return recruitmentProcessId;
	}

	public void setRecruitmentProcessId(Long recruitmentProcessId) {
		this.recruitmentProcessId = recruitmentProcessId;
	}

	public MRF getMrf() {
		return mrf;
	}

	public void setMrf(MRF mrf) {
		this.mrf = mrf;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getRecruitmentProcessType() {
		return recruitmentProcessType;
	}

	public void setRecruitmentProcessType(String recruitmentProcessType) {
		this.recruitmentProcessType = recruitmentProcessType;
	}

	public String getRecruitmentProcessName() {
		return recruitmentProcessName;
	}

	public void setRecruitmentProcessName(String recruitmentProcessName) {
		this.recruitmentProcessName = recruitmentProcessName;
	}

	public List<Interviewer> getInterviewer() {
		return interviewer;
	}

	public void setInterviewer(List<Interviewer> interviewer) {
		this.interviewer = interviewer;
	}

	public String getReport() {
		return report;
	}

	public void setReport(String report) {
		this.report = report;
	}

	public String getCompletedStatus() {
		return completedStatus;
	}

	public void setCompletedStatus(String completedStatus) {
		this.completedStatus = completedStatus;
	}
}
