package com.rts.tap.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
//import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class MRFCandidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mrfCandidateId;

	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "candidatemrf", joinColumns = @JoinColumn(name = "mrfCandidateId"), inverseJoinColumns = @JoinColumn(name = "candidateId"))
	private List<Candidate> candidate;

	@ManyToOne
	private MRFRecruiters mrfRecruiter;

	private String Status;

	public MRFCandidate() {
		super();
	}

	public Long getMrfCandidateId() {
		return mrfCandidateId;
	}

	public void setMrfCandidateId(Long mrfCandidateId) {
		this.mrfCandidateId = mrfCandidateId;
	}

	public List<Candidate> getCandidate() {
		return candidate;
	}

	public void setCandidate(List<Candidate> candidate) {
		this.candidate = candidate;
	}

	public MRFRecruiters getMrfRecruiter() {
		return mrfRecruiter;
	}

	public void setMrfRecruiter(MRFRecruiters mrfRecruiter) {
		this.mrfRecruiter = mrfRecruiter;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

}
