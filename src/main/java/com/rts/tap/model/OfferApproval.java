package com.rts.tap.model;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class OfferApproval {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long offerApprovalId;
 
	@ManyToOne
	private Offer offer;
 
	@ManyToOne
	private ApproverLevel approverLevel;
 
	private String status;
 
	private String Reason;
 
	public OfferApproval() {
		super();
	}
 
	public Long getOfferApprovalId() {
		return offerApprovalId;
	}
 
	public void setOfferApprovalId(Long offerApprovalId) {
		this.offerApprovalId = offerApprovalId;
	}
 
	public Offer getOffer() {
		return offer;
	}
 
	public void setOffer(Offer offer) {
		this.offer = offer;
	}
 
	public ApproverLevel getApproverLevel() {
		return approverLevel;
	}
 
	public void setApproverLevel(ApproverLevel approverLevel) {
		this.approverLevel = approverLevel;
	}
 
	public String getStatus() {
		return status;
	}
 
	public void setStatus(String status) {
		this.status = status;
	}
 
	public String getReason() {
		return Reason;
	}
 
	public void setReason(String reason) {
		Reason = reason;
	}
 
}