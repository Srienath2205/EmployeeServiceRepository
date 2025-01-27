package com.rts.tap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
 
@Entity
@Table
public class JobPosting {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jobPostingId;
 
	@ManyToOne
	private MRF mrf;
	
	@ManyToOne
	private Employee recruiter;
 
	@Column(name = "JobPoster", nullable = true, length = 100000000)
	private byte[] jobPoster;
 
	private String jobUrl;
 
	public JobPosting() {
		super();
	}

	public Long getJobPostingId() {
		return jobPostingId;
	}

	public void setJobPostingId(Long jobPostingId) {
		this.jobPostingId = jobPostingId;
	}

	public MRF getMrf() {
		return mrf;
	}

	public void setMrf(MRF mrf) {
		this.mrf = mrf;
	}

	public Employee getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Employee recruiter) {
		this.recruiter = recruiter;
	}

	public byte[] getJobPoster() {
		return jobPoster;
	}

	public void setJobPoster(byte[] jobPoster) {
		this.jobPoster = jobPoster;
	}

	public String getJobUrl() {
		return jobUrl;
	}

	public void setJobUrl(String jobUrl) {
		this.jobUrl = jobUrl;
	}
	
}
