package com.rts.tap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Candidate360 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long candidate360Id;
	
	@Lob
	@Column(length = 1000000000, nullable = true)
	private byte[] candidateInfo;
	
	@OneToOne
	private Candidate candidate;

	public Candidate360() {
		super();
	}

	public Long getCandidate360Id() {
		return candidate360Id;
	}

	public void setCandidate360Id(Long candidate360Id) {
		this.candidate360Id = candidate360Id;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public byte[] getCandidateInfo() {
		return candidateInfo;
	}

	public void setCandidateInfo(byte[] candidateInfo) {
		this.candidateInfo = candidateInfo;
	}
	
}
