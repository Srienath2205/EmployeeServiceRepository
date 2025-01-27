package com.rts.tap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mrfStatus_table")
public class MRFStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mrfStatusId;

	@Column
	private String mrfApprovalStatus;

	@Column
	private String mrfStage;

	@Column
	private String mrfType;

	@Column
	private String descriptionForChanges;
	
	@Column
	private String reasonForLost;

	@Column
	private int requirementFilled;

	public MRFStatus() {
		super();
	}

	public MRFStatus(Long mrfStatusId, String mrfApprovalStatus, String mrfStage, String mrfType,
			String descriptionForChanges, String reasonForLost, int requirementFilled) {
		super();
		this.mrfStatusId = mrfStatusId;
		this.mrfApprovalStatus = mrfApprovalStatus;
		this.mrfStage = mrfStage;
		this.mrfType = mrfType;
		this.descriptionForChanges = descriptionForChanges;
		this.reasonForLost = reasonForLost;
		this.requirementFilled = requirementFilled;
	}

	public Long getMrfStatusId() {
		return mrfStatusId;
	}

	public void setMrfStatusId(Long mrfStatusId) {
		this.mrfStatusId = mrfStatusId;
	}	

	public String getMrfApprovalStatus() {
		return mrfApprovalStatus;
	}

	public void setMrfApprovalStatus(String mrfApprovalStatus) {
		this.mrfApprovalStatus = mrfApprovalStatus;
	}

	public String getMrfStage() {
		return mrfStage;
	}

	public void setMrfStage(String mrfStage) {
		this.mrfStage = mrfStage;
	}

	public String getMrfType() {
		return mrfType;
	}

	public void setMrfType(String mrfType) {
		this.mrfType = mrfType;
	}

	public String getDescriptionForChanges() {
		return descriptionForChanges;
	}

	public void setDescriptionForChanges(String descriptionForChanges) {
		this.descriptionForChanges = descriptionForChanges;
	}

	public String getReasonForLost() {
		return reasonForLost;
	}

	public void setReasonForLost(String reasonForLost) {
		this.reasonForLost = reasonForLost;
	}

	public int getRequirementFilled() {
		return requirementFilled;
	}

	public void setRequirementFilled(int requirementFilled) {
		this.requirementFilled = requirementFilled;
	}

	@Override
	public String toString() {
		return "MRFStatus [mrfStatusId=" + mrfStatusId + ", mrfApprovalStatus=" + mrfApprovalStatus + ", mrfStage="
				+ mrfStage + ", mrfType=" + mrfType + ", descriptionForChanges=" + descriptionForChanges
				+ ", reasonForLost=" + reasonForLost + ", requirementFilled=" + requirementFilled + "]";
	}
	
}
