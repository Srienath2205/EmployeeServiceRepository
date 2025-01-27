package com.rts.tap.model;


import jakarta.persistence.CascadeType;

import jakarta.persistence.Column;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity

@Table

public class CandidateStatus {

	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long candidateStatusId;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })

	private Candidate candidate;

	@Column(nullable = true)

	private String status;

	@Column(nullable = true)

	private String reason;
 
	private int level;

	private Long mrfId;

	private String designation;

	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.PERSIST })

	private Employee recruiter;

	public CandidateStatus() {

		super();

	}

	public Long getCandidateStatusId() {

		return candidateStatusId;

	}

	public void setCandidateStatusId(Long candidateStatusId) {

		this.candidateStatusId = candidateStatusId;

	}

	public Candidate getCandidate() {

		return candidate;

	}

	public void setCandidate(Candidate candidate) {

		this.candidate = candidate;

	}

	public String getStatus() {

		return status;

	}

	public void setStatus(String status) {

		this.status = status;

	}

	public String getReason() {

		return reason;

	}

	public void setReason(String reason) {

		this.reason = reason;

	}

	public Employee getRecruiter() {

		return recruiter;

	}

	public void setRecruiter(Employee recruiter) {

		this.recruiter = recruiter;

	}
 
	public int getLevel() {

		return level;

	}
 
	public void setLevel(int level) {

		this.level = level;

	}
 
	public Long getMrfId() {

		return mrfId;

	}
 
	public void setMrfId(Long mrfId) {

		this.mrfId = mrfId;

	}
 
	public String getDesignation() {

		return designation;

	}
 
	public void setDesignation(String designation) {

		this.designation = designation;

	}
 
}
 