package com.rts.tap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table

public class BasicJobTable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long basicJobTableId;

	private String jobDescription;

	private String jobTitle;

	private Double jobPackage;

	private Double experience;

	private String Role;

	public BasicJobTable() {
		super();
	}

	public Long getBasicJobTableId() {
		return basicJobTableId;
	}

	public void setBasicJobTableId(Long basicJobTableId) {
		this.basicJobTableId = basicJobTableId;
	}

	public String getJobDescription() {
		return jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Double getJobPackage() {
		return jobPackage;
	}

	public void setJobPackage(Double jobPackage) {
		this.jobPackage = jobPackage;
	}

	public Double getExperience() {
		return experience;
	}

	public void setExperience(Double experience) {
		this.experience = experience;
	}

	public String getRole() {
		return Role;
	}

	public void setRole(String role) {
		Role = role;
	}

}
