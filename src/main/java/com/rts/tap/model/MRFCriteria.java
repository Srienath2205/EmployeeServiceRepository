package com.rts.tap.model;

import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mrfCriteria_table")
public class MRFCriteria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mrfCriteriaId;
	@Column
	private String employmentMode;
	@Column
	private String educationalQualification;
	@Column
	private String yearsOfExperience;
	@Column
	private double minimumCTC;
	@Column
	private double maximumCTC;
	@Column
	private Date contractStartDate;
	@Column
	private Date closureDate;
	@Column
	private String jobLocation;

	@Column(nullable = true)
	private Boolean IsVisaRequired;

	@Column(nullable = true)
	private Boolean IsCertificationNeeded;
	@Column
	private String visaType;
	@Column
	private String certificate;

	@Column
	private boolean mrfLossOrProfit;

	public MRFCriteria() {
		super();
	}

	public Long getMrfCriteriaId() {
		return mrfCriteriaId;
	}

	public void setMrfCriteriaId(Long mrfCriteriaId) {
		this.mrfCriteriaId = mrfCriteriaId;
	}

	public String getEmploymentMode() {
		return employmentMode;
	}

	public void setEmploymentMode(String employmentMode) {
		this.employmentMode = employmentMode;
	}

	public String getEducationalQualification() {
		return educationalQualification;
	}

	public void setEducationalQualification(String educationalQualification) {
		this.educationalQualification = educationalQualification;
	}

	public String getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public double getMinimumCTC() {
		return minimumCTC;
	}

	public void setMinimumCTC(double minimumCTC) {
		this.minimumCTC = minimumCTC;
	}

	public double getMaximumCTC() {
		return maximumCTC;
	}

	public void setMaximumCTC(double maximumCTC) {
		this.maximumCTC = maximumCTC;
	}

	public Date getContractStartDate() {
		return contractStartDate;
	}

	public void setContractStartDate(Date contractStartDate) {
		this.contractStartDate = contractStartDate;
	}

	public Date getClosureDate() {
		return closureDate;
	}

	public void setClosureDate(Date closureDate) {
		this.closureDate = closureDate;
	}

	public String getJobLocation() {
		return jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}

	public Boolean getIsVisaRequired() {
		return IsVisaRequired;
	}

	public void setIsVisaRequired(Boolean isVisaRequired) {
		IsVisaRequired = isVisaRequired;
	}

	public Boolean getIsCertificationNeeded() {
		return IsCertificationNeeded;
	}

	public void setIsCertificationNeeded(Boolean isCertificationNeeded) {
		IsCertificationNeeded = isCertificationNeeded;
	}

	public String getVisaType() {
		return visaType;
	}

	public void setVisaType(String visaType) {
		this.visaType = visaType;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public boolean isMrfLossOrProfit() {
		return mrfLossOrProfit;
	}

	public void setMrfLossOrProfit(boolean mrfLossOrProfit) {
		this.mrfLossOrProfit = mrfLossOrProfit;
	}

}