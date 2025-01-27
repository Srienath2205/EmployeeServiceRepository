package com.rts.tap.model;
 
import java.sql.Date;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
 
@Entity
@Table
public class Offer {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long offerId;
 
	@OneToOne
	private Candidate candidate;
 
	private Double offerPackage;
 
	private String candidateReason;
 
	private String candidateStatus;
 
	@ManyToOne
	private MRF mrf;
 
	@Lob
	@Column(length = 100000000)
	private byte[] offerLetter;
 
	private Boolean isBuHeadApproved;
 
	private Date createDate;
	private Date joiningDate;
 
	public Offer() {
		super();
	}
 
	public Long getOfferId() {
		return offerId;
	}
 
	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}
 
	public Candidate getCandidate() {
		return candidate;
	}
 
	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}
 
	public Double getOfferPackage() {
		return offerPackage;
	}
 
	public void setOfferPackage(Double offerPackage) {
		this.offerPackage = offerPackage;
	}
 
	public String getCandidateReason() {
		return candidateReason;
	}
 
	public void setCandidateReason(String candidateReason) {
		this.candidateReason = candidateReason;
	}
 
	public String getCandidateStatus() {
		return candidateStatus;
	}
 
	public void setCandidateStatus(String candidateStatus) {
		this.candidateStatus = candidateStatus;
	}
 
	public MRF getMrf() {
		return mrf;
	}
 
	public void setMrf(MRF mrf) {
		this.mrf = mrf;
	}
 
	public byte[] getOfferLetter() {
		return offerLetter;
	}
 
	public void setOfferLetter(byte[] offerLetter) {
		this.offerLetter = offerLetter;
	}
 
	public Boolean getIsBuHeadApproved() {
		return isBuHeadApproved;
	}
 
	public void setIsBuHeadApproved(Boolean isBuHeadApproved) {
		this.isBuHeadApproved = isBuHeadApproved;
	}
 
	public Date getCreateDate() {
		return createDate;
	}
 
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
 
	public Date getJoiningDate() {
		return joiningDate;
	}
 
	public void setJoiningDate(Date joiningDate) {
		this.joiningDate = joiningDate;
	}
 
}
