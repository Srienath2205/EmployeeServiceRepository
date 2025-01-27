package com.rts.tap.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mrf_table")
public class MRF {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mrfId;

	@Column
	private String mrfDepartmentName;

	@ManyToOne
	@JoinColumn(name = "requirementId")

//	@JsonBackReference
	private Requirement requirement;

	@OneToOne
	private SubRequirements subRequirements;

	@Column
	private String mrfRequiredTechnology;

	@Column
	private String probableDesignation;

	@Column
	private int requiredResourceCount;

	@Column
	private String requiredSkills;

	@Column
	private Date createdAt;

	@Column
	private Date updatedAt;

	@OneToOne
	private MRFCriteria mrfCriteria;

	@OneToOne
	private MRFStatus mrfStatus;

	@OneToOne
	private MRFAgreement mrfAgreement;

	@OneToOne
	private MrfJd mrfJd;

	@ManyToOne
	@JoinColumn(name = "businessUnitHeadId")
	private Employee businessUnitHead;

	@ManyToOne
	@JoinColumn(name = "clientPartnerId")
	private Employee clientPartner;

	public MRF() {
		super();
	}

	public Long getMrfId() {
		return mrfId;
	}

	public void setMrfId(Long mrfId) {
		this.mrfId = mrfId;
	}

	public String getMrfDepartmentName() {
		return mrfDepartmentName;
	}

	public void setMrfDepartmentName(String mrfDepartmentName) {
		this.mrfDepartmentName = mrfDepartmentName;
	}

	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	public String getMrfRequiredTechnology() {
		return mrfRequiredTechnology;
	}

	public void setMrfRequiredTechnology(String mrfRequiredTechnology) {
		this.mrfRequiredTechnology = mrfRequiredTechnology;
	}

	public String getProbableDesignation() {
		return probableDesignation;
	}

	public void setProbableDesignation(String probableDesignation) {
		this.probableDesignation = probableDesignation;
	}

	public int getRequiredResourceCount() {
		return requiredResourceCount;
	}

	public void setRequiredResourceCount(int requiredResourceCount) {
		this.requiredResourceCount = requiredResourceCount;
	}

	public String getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(String requiredSkills) {
		this.requiredSkills = requiredSkills;
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

	public MRFCriteria getMrfCriteria() {
		return mrfCriteria;
	}

	public void setMrfCriteria(MRFCriteria mrfCriteria) {
		this.mrfCriteria = mrfCriteria;
	}

	public MRFStatus getMrfStatus() {
		return mrfStatus;
	}

	public void setMrfStatus(MRFStatus mrfStatus) {
		this.mrfStatus = mrfStatus;
	}

	public MRFAgreement getMrfAgreement() {
		return mrfAgreement;
	}

	public void setMrfAgreement(MRFAgreement mrfAgreement) {
		this.mrfAgreement = mrfAgreement;
	}

	public MrfJd getMrfJd() {
		return mrfJd;
	}

	public void setMrfJd(MrfJd mrfJd) {
		this.mrfJd = mrfJd;
	}

	public Employee getBusinessUnitHead() {
		return businessUnitHead;
	}

	public void setBusinessUnitHead(Employee businessUnitHead) {
		this.businessUnitHead = businessUnitHead;
	}

	public Employee getClientPartner() {
		return clientPartner;
	}

	public void setClientPartner(Employee clientPartner) {
		this.clientPartner = clientPartner;
	}

	public SubRequirements getSubRequirements() {
		return subRequirements;
	}

	public void setSubRequirements(SubRequirements subRequirements) {
		this.subRequirements = subRequirements;
	}



}
