package com.rts.tap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Score {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long scoreId;

	@ManyToOne
	private Assessment assessment;

	@ManyToOne
	private Candidate candidate;

	private Double Score;

	private String Remarks;

	private String Status;

	private String passkey;

	@Column(nullable = true)
	private String assessmentRescheduleReason;

	public Score() {
		super();
	}

	public String getAssessmentRescheduleReason() {
		return assessmentRescheduleReason;
	}

	public void setAssessmentRescheduleReason(String assessmentRescheduleReason) {
		this.assessmentRescheduleReason = assessmentRescheduleReason;
	}

	public Long getScoreId() {
		return scoreId;
	}

	public void setScoreId(Long scoreId) {
		this.scoreId = scoreId;
	}

	public Assessment getAssessment() {
		return assessment;
	}

	public void setAssessment(Assessment assessment) {
		this.assessment = assessment;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Double getScore() {
		return Score;
	}

	public void setScore(Double score) {
		Score = score;
	}

	public String getRemarks() {
		return Remarks;
	}

	public void setRemarks(String remarks) {
		Remarks = remarks;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getPasskey() {
		return passkey;
	}

	public void setPasskey(String passkey) {
		this.passkey = passkey;
	}

}
