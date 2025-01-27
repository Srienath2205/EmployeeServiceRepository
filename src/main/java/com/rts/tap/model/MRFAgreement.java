package com.rts.tap.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "mrfAgreement_table")

public class MRFAgreement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mrfAgreementId;

	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] serviceLevelAgreement;

	@Column
	private String billingCycle;

	@Column
	private String proposedBudget;

	@Column
	private String negotiatedPricePoint;
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] mrfTemplate;

	public MRFAgreement() {
		super();
	}

	public Long getMrfAgreementId() {
		return mrfAgreementId;
	}

	public void setMrfAgreementId(Long mrfAgreementId) {
		this.mrfAgreementId = mrfAgreementId;
	}

	public byte[] getServiceLevelAgreement() {
		return serviceLevelAgreement;
	}

	public void setServiceLevelAgreement(byte[] serviceLevelAgreement) {
		this.serviceLevelAgreement = serviceLevelAgreement;
	}

	public String getBillingCycle() {
		return billingCycle;
	}

	public void setBillingCycle(String billingCycle) {
		this.billingCycle = billingCycle;
	}

	public String getProposedBudget() {
		return proposedBudget;
	}

	public void setProposedBudget(String proposedBudget) {
		this.proposedBudget = proposedBudget;
	}

	public String getNegotiatedPricePoint() {
		return negotiatedPricePoint;
	}

	public void setNegotiatedPricePoint(String negotiatedPricePoint) {
		this.negotiatedPricePoint = negotiatedPricePoint;
	}
	public byte[] getMrfTemplate() {
		return mrfTemplate;
	}

	public void setMrfTemplate(byte[] mrfTemplate) {
		this.mrfTemplate = mrfTemplate;
	}

	@Override
	public String toString() {
		return "MRFAgreement [mrfAgreementId=" + mrfAgreementId + ", serviceLevelAgreement="
				+ Arrays.toString(serviceLevelAgreement) + ", billingCycle=" + billingCycle + ", proposedBudget="
				+ proposedBudget + ", negotiatedPricePoint=" + negotiatedPricePoint + ", mrfTemplate="
				+ Arrays.toString(mrfTemplate) + "]";
	}

}
