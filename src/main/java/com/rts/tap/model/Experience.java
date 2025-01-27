package com.rts.tap.model;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "experience")
public class Experience {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "experience_id")
	private Long experienceId;

	@Column(name = "companyName")
	private String companyName;

	@Column(name = "role")
	private String role;

	@Column(name = "from_Date")
	private String fromDate;

	@Column(name = "to_Date")
	private String toDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "created_date", updatable = false)
	private LocalDateTime createdDate;

	@PrePersist
	protected void onCreate() {
		createdDate = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedDate = LocalDateTime.now(); // Only update updatedDate on update
	}

	public Experience() {
		super();
	}

	public Experience(Long experienceId, String companyName, String role, String fromDate, String toDate,
			LocalDateTime createdDate, LocalDateTime updatedDate) {
		super();
		this.experienceId = experienceId;
		this.companyName = companyName;
		this.role = role;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}

	public Long getExperienceId() {
		return experienceId;
	}

	public void setExperienceId(Long experienceId) {
		this.experienceId = experienceId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

}
