package com.rts.tap.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "qualifications")
public class Qualification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "qualification_id")
	private Long qualificationId;

	@Column(name = "typeOfEducation")
	private String typeOfEducation;

	@Column(name = "institution")
	private String institutionName;
		
	@Column(name = "specialization")
	private String specialization;
	
	@Column(name = "from_year")
    private LocalDateTime fromYear;
	
	@Column(name = "year_of_completion")
    private LocalDateTime yearOfCompletion;
	
	public Qualification() {
		super();
	}

	public Long getQualificationId() {
		return qualificationId;
	}

	public void setQualificationId(Long qualificationId) {
		this.qualificationId = qualificationId;
	}

	public String getTypeOfEducation() {
		return typeOfEducation;
	}

	public void setTypeOfEducation(String typeOfEducation) {
		this.typeOfEducation = typeOfEducation;
	}

	public String getInstitutionName() {
		return institutionName;
	}

	public void setInstitutionName(String institutionName) {
		this.institutionName = institutionName;
	}

	

	public LocalDateTime getYearOfCompletion() {
		return yearOfCompletion;
	}

	public void setYearOfCompletion(LocalDateTime yearOfCompletion) {
		this.yearOfCompletion = yearOfCompletion;
	}

	

	public LocalDateTime getFromYear() {
		return fromYear;
	}

	public void setFromYear(LocalDateTime fromYear) {
		this.fromYear = fromYear;
	}

	public Qualification(Long qualificationId, String typeOfEducation, String institutionName, String specialization,
			LocalDateTime fromYear, LocalDateTime yearOfCompletion, String grade, LocalDateTime createdDate,
			LocalDateTime updatedDate, byte[] certificates) {
		super();
		this.qualificationId = qualificationId;
		this.typeOfEducation = typeOfEducation;
		this.institutionName = institutionName;
		this.specialization = specialization;
		this.fromYear = fromYear;
		this.yearOfCompletion = yearOfCompletion;
		this.grade = grade;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.certificates = certificates;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public byte[] getCertificates() {
		return certificates;
	}

	public void setCertificates(byte[] certificates) {
		this.certificates = certificates;
	}


	@Column(name = "grade")
	private String grade;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "created_date", updatable = false)
	private LocalDateTime createdDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	@Lob
	@Column(length = 1000000)
	private byte[] certificates;

	public enum TypeOfEducation {
		SSLC, HSC, DIPLOMA, PG, UG
	}

	@PrePersist
	protected void onCreate() {
		createdDate = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedDate = LocalDateTime.now(); // Only update updatedDate on update
	}
}
