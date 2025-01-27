package com.rts.tap.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendor_performance")
public class VendorPerformance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vendorPerformanceId;

	@OneToOne
	@JoinColumn(name = "vendor_id")
	private Vendor vendor;

	@Column(name = "overall_performance")
	private double overallPerformance;

	private String grade;
	
	private LocalDateTime updatedDate;

	public VendorPerformance() {
		super();
		this.updatedDate = LocalDateTime.now();
	}

	public Long getVendorPerformanceId() {
		return vendorPerformanceId;
	}

	public void setVendorPerformanceId(Long vendorPerformanceId) {
		this.vendorPerformanceId = vendorPerformanceId;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public double getOverallPerformance() {
		return overallPerformance;
	}

	public void setOverallPerformance(double overallPerformance) {
		this.overallPerformance = overallPerformance;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}
}