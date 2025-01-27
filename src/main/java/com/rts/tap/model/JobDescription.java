package com.rts.tap.model;
 
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
 
@Entity
@Table(name = "jobDescription_table")
public class JobDescription {
 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jobDescriptionId;
 
	@Column
	private String jobTitle;
 
	@Column
	private String jobParameter;
 
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] rolesAndResponsibilities;
 
	public JobDescription() {
		super();
	}
 
	public Long getJobDescriptionId() {
		return jobDescriptionId;
	}
 
	public void setJobDescriptionId(Long jobDescriptionId) {
		this.jobDescriptionId = jobDescriptionId;
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