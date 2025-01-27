package com.rts.tap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mrfRecruitingManager_table")
public class MRFRecruitingManager  {

//	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mrfRecruitingManagerId;

	@ManyToOne
	@JoinColumn(name = "mrfId")
	private MRF mrf;

	@ManyToOne
	@JoinColumn(name = "recruitingManagerId")
	private Employee recruitingManager;

	@Column
	private String recruitingManagerAssignedStatus;

	public MRFRecruitingManager() {
		super();
	}

	public Long getMrfRecruitingManagerId() {
		return mrfRecruitingManagerId;
	}

	public void setMrfRecruitingManagerId(Long mrfRecruitingManagerId) {
		this.mrfRecruitingManagerId = mrfRecruitingManagerId;
	}

	public MRF getMrf() {
		return mrf;
	}

	public void setMrf(MRF mrf) {
		this.mrf = mrf;
	}

	public Employee getRecruitingManager() {
		return recruitingManager;
	}

	public void setRecruitingManager(Employee recruitingManager) {
		this.recruitingManager = recruitingManager;
	}

	public String getRecruitingManagerAssignedStatus() {
		return recruitingManagerAssignedStatus;
	}

	public void setRecruitingManagerAssignedStatus(String recruitingManagerAssignedStatus) {
		this.recruitingManagerAssignedStatus = recruitingManagerAssignedStatus;
	}

}
