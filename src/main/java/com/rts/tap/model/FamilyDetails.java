package com.rts.tap.model;

import java.time.LocalDateTime;
import jakarta.persistence.*;

@Entity
@Table(name = "familydetails")
public class FamilyDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "familydetails_id")
	private Long familyDetailsID;

	@Column(name = "familymember_name", nullable = false, length = 100)
	private String familyMemberName;

	@Column(name = "relationship", nullable = false, length = 50)
	private String relationship;

	@Column(name = "date_of_birth")
	private LocalDateTime dateOfBirth;

	@Column(name = "occupation", length = 100)
	private String occupation;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;


	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public FamilyDetails(Long familyDetailsID, String familyMemberName, String relationship, LocalDateTime dateOfBirth,
			String occupation, Gender gender, String familyMemberContactNumber) {
		super();
		this.familyDetailsID = familyDetailsID;
		this.familyMemberName = familyMemberName;
		this.relationship = relationship;
		this.dateOfBirth = dateOfBirth;
		this.occupation = occupation;
		this.gender = gender;
		this.familyMemberContactNumber = familyMemberContactNumber;
	}

	@Column(name = "familyMember_contactnumber", length = 15)
	private String familyMemberContactNumber;

	public FamilyDetails() {
		super();
	}

	public enum Gender {
		MALE, FEMALE, OTHER
	}

	public Long getFamilyDetailsID() {
		return familyDetailsID;
	}

	public void setFamilyDetailsID(Long familyDetailsID) {
		this.familyDetailsID = familyDetailsID;
	}

	public String getFamilyMemberName() {
		return familyMemberName;
	}

	public void setFamilyMemberName(String familyMemberName) {
		this.familyMemberName = familyMemberName;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public LocalDateTime getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDateTime dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getOccupation() {
		return occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getFamilyMemberContactNumber() {
		return familyMemberContactNumber;
	}

	public void setFamilyMemberContactNumber(String familyMemberContactNumber) {
		this.familyMemberContactNumber = familyMemberContactNumber;
	}

}
