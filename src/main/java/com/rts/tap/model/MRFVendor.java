package com.rts.tap.model;

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
@Table(name = "mrfVendor_table")
public class MRFVendor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mrfVendorId;

	@ManyToOne
	@JoinColumn(name = "mrfId")
	private MRF mrf;

	@ManyToOne
	@JoinColumn(name = "recruitingManagerId")
	private Employee recruitingManager;

	@ManyToOne
	@JoinColumn(name = "vendorId")
	private Vendor vendor;

	@Column
	private String vendorAssignedStatus;
	
	@Column
	private int assignedCount;
	
	@Column
	private int achievedCount;

	// Column added by Team-D
	private Date assignedDate;

	public MRFVendor() {
		super();
		this.assignedDate = new Date();
	}

	public Long getMrfVendorId() {
		return mrfVendorId;
	}

	public void setMrfVendorId(Long mrfVendorId) {
		this.mrfVendorId = mrfVendorId;
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

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public String getVendorAssignedStatus() {
		return vendorAssignedStatus;
	}

	public void setVendorAssignedStatus(String vendorAssignedStatus) {
		this.vendorAssignedStatus = vendorAssignedStatus;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
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
