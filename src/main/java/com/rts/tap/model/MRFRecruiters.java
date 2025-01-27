package com.rts.tap.model;

//import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mrfRecruiters_table")
public class MRFRecruiters  {

//	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mrfRecruitersId;

	@ManyToOne
	@JoinColumn(name = "mrfRecruitingManagerId")
	private MRFRecruitingManager mrfRecruitingManager;

	@ManyToOne
	@JoinColumn(name = "recruiterId")
	private Employee recruiterId;

	@Column
	private String recruiterAssignedStatus;

	@Column
	private Date createdAt;

	@Column
	private Date updatedAt;

	@Column
	private Date closedDate;
	
	@Column
	private int assignedCount;
	
	@Column
	private int achievedCount; 

	public MRFRecruiters() {
		super();
	}

	public Long getMrfRecruitersId() {
		return mrfRecruitersId;
	}

	public void setMrfRecruitersId(Long mrfRecruitersId) {
		this.mrfRecruitersId = mrfRecruitersId;
	}

	public MRFRecruitingManager getMrfRecruitingManager() {
		return mrfRecruitingManager;
	}

	public void setMrfRecruitingManager(MRFRecruitingManager mrfRecruitingManager) {
		this.mrfRecruitingManager = mrfRecruitingManager;
	}

	public Employee getRecruiterId() {
		return recruiterId;
	}

	public void setRecruiterId(Employee recruiterId) {
		this.recruiterId = recruiterId;
	}

	public String getRecruiterAssignedStatus() {
		return recruiterAssignedStatus;
	}

	public void setRecruiterAssignedStatus(String recruiterAssignedStatus) {
		this.recruiterAssignedStatus = recruiterAssignedStatus;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	public int getAssignedCount() {
		return assignedCount;
	}

	public void setAssignedCount(int assignedCount) {
		this.assignedCount = assignedCount;
	}

	public int getAchievedCount() {
		return achievedCount;
	}

	public void setAchievedCount(int achievedCount) {
		this.achievedCount = achievedCount;
	}
}
