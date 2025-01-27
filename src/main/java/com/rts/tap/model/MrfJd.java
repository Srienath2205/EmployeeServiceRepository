package com.rts.tap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "MRF_JD")
public class MrfJd {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long mrfJdId;

	@Column
	private String jobTitle;

	@Column
	private String jobParameter;

	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] rolesAndResponsibilities;

	public MrfJd() {
		super();
	}

	public Long getMrfJdId() {
		return mrfJdId;
	}

	public void setMrfJdId(Long mrfJdId) {
		this.mrfJdId = mrfJdId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getJobParameter() {
		return jobParameter;
	}

	public void setJobParameter(String jobParameter) {
		this.jobParameter = jobParameter;
	}

	public byte[] getRolesAndResponsibilities() {
		return rolesAndResponsibilities;
	}

	public void setRolesAndResponsibilities(byte[] rolesAndResponsibilities) {
		this.rolesAndResponsibilities = rolesAndResponsibilities;
	}
}
