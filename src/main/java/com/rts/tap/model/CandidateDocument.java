package com.rts.tap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "CandidateDocuments")
public class CandidateDocument {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long CandidateDocumentId;

	@Column
	private String payslip;

	@Column
	private String payslipStatus;

	@Column
	private String experienceLetter;

	@Column
	private String experienceLetterStatus;

	@Column
	private String degreeCertificate;
	@Column
	private String degreeCertificateStatus;
	@Column
	private String aadhar;
	@Column
	private String aadharStatus;
	@Column
	private String panCard;
	@Column
	private String panCardStatus;
	@Column
	private String passport;
	@Column
	private String passportStatus;
	@Column
	private String relievingLetter;
	@Column
	private String relievingLetterStatus;

	public CandidateDocument() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getCandidateDocumentId() {
		return CandidateDocumentId;
	}

	public void setCandidateDocumentId(Long candidateDocumentId) {
		CandidateDocumentId = candidateDocumentId;
	}

	public String getPayslip() {
		return payslip;
	}

	public void setPayslip(String payslip) {
		this.payslip = payslip;
	}

	public String getPayslipStatus() {
		return payslipStatus;
	}

	public void setPayslipStatus(String payslipStatus) {
		this.payslipStatus = payslipStatus;
	}

	public String getExperienceLetter() {
		return experienceLetter;
	}

	public void setExperienceLetter(String experienceLetter) {
		this.experienceLetter = experienceLetter;
	}

	public String getExperienceLetterStatus() {
		return experienceLetterStatus;
	}

	public void setExperienceLetterStatus(String experienceLetterStatus) {
		this.experienceLetterStatus = experienceLetterStatus;
	}

	public String getDegreeCertificate() {
		return degreeCertificate;
	}

	public void setDegreeCertificate(String degreeCertificate) {
		this.degreeCertificate = degreeCertificate;
	}

	public String getDegreeCertificateStatus() {
		return degreeCertificateStatus;
	}

	public void setDegreeCertificateStatus(String degreeCertificateStatus) {
		this.degreeCertificateStatus = degreeCertificateStatus;
	}

	public String getAadhar() {
		return aadhar;
	}

	public void setAadhar(String aadhar) {
		this.aadhar = aadhar;
	}

	public String getAadharStatus() {
		return aadharStatus;
	}

	public void setAadharStatus(String aadharStatus) {
		this.aadharStatus = aadharStatus;
	}

	public String getPanCard() {
		return panCard;
	}

	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}

	public String getPanCardStatus() {
		return panCardStatus;
	}

	public void setPanCardStatus(String panCardStatus) {
		this.panCardStatus = panCardStatus;
	}

	public String getPassport() {
		return passport;
	}

	public void setPassport(String passport) {
		this.passport = passport;
	}

	public String getPassportStatus() {
		return passportStatus;
	}

	public void setPassportStatus(String passportStatus) {
		this.passportStatus = passportStatus;
	}

	public String getRelievingLetter() {
		return relievingLetter;
	}

	public void setRelievingLetter(String relievingLetter) {
		this.relievingLetter = relievingLetter;
	}

	public String getRelievingLetterStatus() {
		return relievingLetterStatus;
	}

	public void setRelievingLetterStatus(String relievingLetterStatus) {
		this.relievingLetterStatus = relievingLetterStatus;
	}

}
