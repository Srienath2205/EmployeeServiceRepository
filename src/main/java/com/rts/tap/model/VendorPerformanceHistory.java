package com.rts.tap.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendor_performance_history")
public class VendorPerformanceHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long VendorPerformanceHistoryId;

	@ManyToOne
	@JoinColumn(name = "vendor_id")
	private Vendor vendor;
	
	@ManyToOne
	@JoinColumn(name = "mrf_id")
	private MRF mrf;

	@Column(name = "time_to_fill")
	private double timeToFill;

	@Column(name = "assigned_date")
	private LocalDateTime assignedDate;

	@Column(name = "closed_date")
	private LocalDateTime closedDate;

	@Column
	private LocalDateTime updatedDate;

	@Column(name = "offer_acceptance_rate")
	private double offerAcceptanceRate;

	@Column(name = "collective_score")
	private double collectiveScore;

	private String grade;

	public VendorPerformanceHistory() {
		super();
		this.assignedDate = LocalDateTime.now();
		this.updatedDate = LocalDateTime.now();
		this.timeToFill = 0;
		this.collectiveScore = 0;
		this.offerAcceptanceRate = 0;
	}

	public Long getVendorPerformanceHistoryId() {
		return VendorPerformanceHistoryId;
	}

	public void setVendorPerformanceHistoryId(Long vendorPerformanceHistoryId) {
		VendorPerformanceHistoryId = vendorPerformanceHistoryId;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public double getTimeToFill() {
		return timeToFill;
	}

	public void setTimeToFill(double timeToFill) {
		this.timeToFill = timeToFill;
	}

	public LocalDateTime getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(LocalDateTime assignedDate) {
		this.assignedDate = assignedDate;
	}

	public LocalDateTime getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(LocalDateTime closedDate) {
		this.closedDate = closedDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public double getOfferAcceptanceRate() {
		return offerAcceptanceRate;
	}

	public void setOfferAcceptanceRate(double offerAcceptanceRate) {
		this.offerAcceptanceRate = offerAcceptanceRate;
	}

	public double getCollectiveScore() {
		return collectiveScore;
	}

	public void setCollectiveScore(double collectiveScore) {
		this.collectiveScore = collectiveScore;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public MRF getMrf() {
		return mrf;
	}

	public void setMrf(MRF mrf) {
		this.mrf = mrf;
	}	
}