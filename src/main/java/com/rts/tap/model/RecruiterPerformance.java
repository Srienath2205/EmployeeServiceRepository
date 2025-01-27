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
@Table(name = "recruiter_performance")
public class RecruiterPerformance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recruiterPerformanceId;

	@ManyToOne
	@JoinColumn(name = "recruiter_id")
	private Employee recruiter;

	@Column(name = "time_to_fill")
	private double timeToFill;

	@ManyToOne
	@JoinColumn(name = "assigned_mrf")
	private MRF mrf;

	@Column(name = "assigned_date")
	private LocalDateTime assignedDate;

	@Column(name = "closed_date")
	private LocalDateTime closedDate;

	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	@Column(name = "cost_per_hire")
	private double costPerHire;

	@Column(name = "offer_acceptance")
	private double offerAcceptance;

	@Column(name = "offer_negotiation")
	private double offerNegotiation;

	@Column(name = "collective_score")
	private double collectiveScore;

	@Column
	private String grade;

	public RecruiterPerformance() {
		super();
		this.assignedDate = LocalDateTime.now();
		this.updatedDate = LocalDateTime.now();
		this.timeToFill = 0;
		this.collectiveScore = 0;
		this.offerAcceptance = 0;
	}

	public Long getRecruiterPerformanceId() {
		return recruiterPerformanceId;
	}

	public void setRecruiterPerformanceId(Long recruiterPerformanceId) {
		this.recruiterPerformanceId = recruiterPerformanceId;
	}

	public Employee getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Employee recruiter) {
		this.recruiter = recruiter;
	}

	public double getTimeToFill() {
		return timeToFill;
	}

	public void setTimeToFill(double timeToFill) {
		this.timeToFill = timeToFill;
	}

	public MRF getMrf() {
		return mrf;
	}

	public void setMrf(MRF mrf) {
		this.mrf = mrf;
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

	public double getCostPerHire() {
		return costPerHire;
	}

	public void setCostPerHire(double costPerHire) {
		this.costPerHire = costPerHire;
	}

	public double getOfferAcceptance() {
		return offerAcceptance;
	}

	public void setOfferAcceptance(double offerAcceptance) {
		this.offerAcceptance = offerAcceptance;
	}

	public double getOfferNegotiation() {
		return offerNegotiation;
	}

	public void setOfferNegotiation(double offerNegotiation) {
		this.offerNegotiation = offerNegotiation;
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
}
