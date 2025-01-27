package com.rts.tap.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "personal_information")
public class PersonalInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "personal_info_id")
	private Long personalInfoId;

	@Column(name = "employee_first_name")
	private String firstName;
	
	@Column(name = "personalEmail")
	private String personalEmail;

	@Column(name = "employee_last_name")
	private String lastName;

	@Column(name = "employee_phone")
	private String phone;

	// Change dateOfBirth from LocalDate to LocalDateTime
	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss") // Format to match ISO 8601 format
	@Column(name = "date_of_birth")
	private LocalDateTime dateOfBirth;

	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;

	@Column(name = "employee_address")
	private String employeeAddress;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "country")
	private String country;

	@Column(name = "postal_code")
	private String pincode;

	@Column(name = "marital_status")
	private String maritalStatus;
	
	@Column(name = "district")
	private String district;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "created_date", updatable = false)
	private LocalDateTime createdDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	@Lob
	@Column(length = 1000000)
	private byte[] employeePhoto;

	public Long getPersonalInfoId() {
		return personalInfoId;
	}

	public void setPersonalInfoId(Long personalInfoId) {
		this.personalInfoId = personalInfoId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public String getEmployeeAddress() {
		return employeeAddress;
	}

	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public PersonalInfo(Long personalInfoId, String firstName, String personalEmail, String lastName, String phone,
			LocalDateTime dateOfBirth, Gender gender, String employeeAddress, String city, String state, String country,
			String pincode, String maritalStatus, String district, LocalDateTime createdDate, LocalDateTime updatedDate,
			byte[] employeePhoto) {
		super();
		this.personalInfoId = personalInfoId;
		this.firstName = firstName;
		this.personalEmail = personalEmail;
		this.lastName = lastName;
		this.phone = phone;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.employeeAddress = employeeAddress;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
		this.maritalStatus = maritalStatus;
		this.district = district;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.employeePhoto = employeePhoto;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}


	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
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

	public byte[] getEmployeePhoto() {
		return employeePhoto;
	}

	public void setEmployeePhoto(byte[] employeePhoto) {
		this.employeePhoto = employeePhoto;
	}


	public PersonalInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}



	public String getPersonalEmail() {
		return personalEmail;
	}

	public void setPersonalEmail(String personalEmail) {
		this.personalEmail = personalEmail;
	}

	public enum Gender {
		MALE, FEMALE, OTHER
	}
}