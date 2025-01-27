package com.rts.tap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Candidate360QuestionBank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long candidate360QuestionBankId;
	
	@Column
	private String question;
	
	@Column
	private String type;
	
	public Candidate360QuestionBank() {
		super();
	}

	public Long getCandidate360QuestionBankId() {
		return candidate360QuestionBankId;
	}

	public void setCandidate360QuestionBankId(Long candidate360QuestionBankId) {
		this.candidate360QuestionBankId = candidate360QuestionBankId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
