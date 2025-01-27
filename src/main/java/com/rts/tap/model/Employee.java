package com.rts.tap.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id")
	private Long employeeId;

	@Column(name = "employee_email", unique = true, nullable = false)
	private String employeeEmail;

	@Column(name = "employee_name", nullable = false)
	private String employeeName;

	@Column(name = "work_location")
	private String workLocation;

	@Enumerated(EnumType.STRING)
	@Column(name = "employee_status")
	private EmploymentStatus employeeStatus;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "role_id")
	private Role role;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "businessunit_id")
	private BusinessUnit businessUnit;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "created_date", updatable = false)
	private LocalDateTime createdDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	@Column(name = "manager_id")
	private Long managerId; // Instead of directly referencing the manager as an Employee, store the
							// manager's employeeId

	@Column(name = "candidate_id")
	private Long candidateId;

	public Employee(Long employeeId, String employeeEmail, String employeeName, String workLocation,
			EmploymentStatus employeeStatus, Role role, BusinessUnit businessUnit, LocalDateTime createdDate,
			LocalDateTime updatedDate, Long managerId, Long candidateId, PersonalInfo personalInfo,
			List<Experience> experience, List<FamilyDetails> familyDetails, List<Qualification> qualification,
			List<Documents> documents) {
		super();
		this.employeeId = employeeId;
		this.employeeEmail = employeeEmail;
		this.employeeName = employeeName;
		this.workLocation = workLocation;
		this.employeeStatus = employeeStatus;
		this.role = role;
		this.businessUnit = businessUnit;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.managerId = managerId;
		this.candidateId = candidateId;
		this.personalInfo = personalInfo;
		this.experience = experience;
		this.familyDetails = familyDetails;
		this.qualification = qualification;
		this.documents = documents;
	}

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Ensure the proper cascade type
    @JoinColumn(name = "personal_info_id", referencedColumnName = "personal_info_id") 
	private PersonalInfo personalInfo;

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Experience> experience;

	@OneToMany
	private List<FamilyDetails> familyDetails;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Qualification> qualification;

	@OneToMany
	private List<Documents> documents;

	@PrePersist
	protected void onCreate() {
		createdDate = LocalDateTime.now();
	}

	@PreUpdate
	protected void onUpdate() {
		updatedDate = LocalDateTime.now();
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getWorkLocation() {
		return workLocation;
	}

	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}

	public EmploymentStatus getEmployeeStatus() {
		return employeeStatus;
	}

	public void setEmployeeStatus(EmploymentStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public BusinessUnit getBusinessUnit() {
		return businessUnit;
	}

	public void setBusinessUnit(BusinessUnit businessUnit) {
		this.businessUnit = businessUnit;
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

	public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public List<Experience> getExperience() {
		return experience;
	}

	public void setExperience(List<Experience> experience) {
		this.experience = experience;
	}

	public List<FamilyDetails> getFamilyDetails() {
		return familyDetails;
	}

	public void setFamilyDetails(List<FamilyDetails> familyDetails) {
		this.familyDetails = familyDetails;
	}

	public List<Qualification> getQualification() {
		return qualification;
	}

	public void setQualification(List<Qualification> qualification) {
		this.qualification = qualification;
	}

	public List<Documents> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Documents> documents) {
		this.documents = documents;
	}

	public PersonalInfo getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(PersonalInfo personalInfo) {
		this.personalInfo = personalInfo;
	}

	public Employee() {
		super();

	}

	public enum EmploymentStatus {
		ACTIVE, INACTIVE
	}
}
