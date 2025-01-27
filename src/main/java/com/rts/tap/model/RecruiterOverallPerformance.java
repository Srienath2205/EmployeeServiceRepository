package com.rts.tap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "recruiter_overall_performance")
public class RecruiterOverallPerformance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long recruiterOverallPerformanceId;

	@OneToOne
	@JoinColumn(name = "recruiter_id")
	private Employee recruiter;

	@Column(name = "overall_performance")
	private double overallPerformance;

	private String grade;

	public RecruiterOverallPerformance() {
		super();
	}

	public Long getRecruiterOverallPerformanceId() {
		return recruiterOverallPerformanceId;
	}

	public void setRecruiterOverallPerformanceId(Long recruiterOverallPerformanceId) {
		this.recruiterOverallPerformanceId = recruiterOverallPerformanceId;
	}

	public Employee getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Employee recruiter) {
		this.recruiter = recruiter;
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
}