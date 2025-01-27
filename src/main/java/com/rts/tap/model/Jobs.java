package com.rts.tap.model;
 
import jakarta.persistence.Column;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.Table;
 
@Entity

@Table(name = "JobTitles")

public class Jobs {
 
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long jobId;
 
	@Column

	private String jobTitle;
 
	public Jobs() {

		super();

	}
 
	public Long getJobId() {

		return jobId;

	}
 
	public void setJobId(Long jobId) {

		this.jobId = jobId;

	}
 
	public String getJobTitle() {

		return jobTitle;

	}
 
	public void setJobTitle(String jobTitle) {

		this.jobTitle = jobTitle;

	}
 
}

 