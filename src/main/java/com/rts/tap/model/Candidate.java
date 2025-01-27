package com.rts.tap.model;
 
import java.time.LocalDateTime;
 
import java.util.List;
 
import jakarta.persistence.CascadeType;
 
import jakarta.persistence.CollectionTable;
 
import jakarta.persistence.Column;
 
import jakarta.persistence.ElementCollection;
 
import jakarta.persistence.Entity;
 
import jakarta.persistence.FetchType;
 
import jakarta.persistence.GeneratedValue;
 
import jakarta.persistence.GenerationType;
 
import jakarta.persistence.Id;
 
import jakarta.persistence.JoinColumn;
 
import jakarta.persistence.JoinTable;
 
import jakarta.persistence.Lob;
 
import jakarta.persistence.ManyToMany;
 
import jakarta.persistence.OneToOne;
 
import jakarta.persistence.PrePersist;
 
import jakarta.persistence.Table;
 
@Entity
 
@Table
 
public class Candidate {

	@Id
 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
 
	private Long candidateId;
 
	@Column(nullable = true)
 
	private String firstName;
 
	@Column(nullable = true)
 
	private String lastName;
 
	@Column(nullable = true)
 
	private String gender;
 
	@Column(nullable = true)
 
	private String mobileNumber;
 
	@Column(nullable = true)
 
	private String email;
 
	@Column(nullable = true)

	private String totalExperience;
 
	@Column(nullable = true)

	private String relevantExperience;
 
	@Column(nullable = true)
 
	private String currentCompany;
 
	@Column(nullable = true)
 
	private String currentLocation;
 
	@Column(nullable = true)
 
	private String currentCTC;
 
	@Column(nullable = true)
 
	private String expectedCTC;
 
	@Column(nullable = true)
 
	private String employementMode;
 
	@Column(nullable = true)
 
	private String previousRole;
 
	@Column(nullable = true)
 
	private String noticePeriod;
 
	@Column(nullable = true)
 
	private String relocate;
 
	@Column(nullable = true)
 
	private String Education;
 
	@Column(nullable = true)
 
	private String resume;
 
	@Column(nullable = true)
 
	private String source;
 
	@Column(nullable = true)
 
	private long sourceId;
 
	@Column(nullable = true)
 
	private String skill;
 
	@Column(nullable = true)
 
	private String location;
 
	@Column(nullable = true)
 
	private String panNumber;
 
	@Column(nullable = true)
 
	private String status;
 
	@Column(nullable = true)
 
	private String password;
 
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)

	private CandidateDocument documents;
 
	@Column(nullable = true)

	private LocalDateTime assignedAt;
 
	@ElementCollection
 
	@CollectionTable(name = "candidate_certifications", joinColumns = @JoinColumn(name = "candidate_id"))
 
	@Column(name = "certification")
 
	private List<String> certifications;
 
	@Column(nullable = true)
 
	private String visaDetails;
 
	@Column(nullable = true)
 
	private Boolean isPasswordChanged;
 
	@Lob
 
	@Column(length = 1000000000, nullable = true)
 
	private byte[] candidateProfileImage;
 
	@ManyToMany(cascade = CascadeType.ALL)

	@JoinTable(name = "mrfJd_candidate", joinColumns = @JoinColumn(name = "candidateId"), inverseJoinColumns = @JoinColumn(name = "mrfJdId"))

	private List<MrfJd> MrfJd;
 
	@OneToOne
 
	private ThirdPartyCredentitals credentials;
 
	@PrePersist
 
	protected void onCreate() {
 
		assignedAt = LocalDateTime.now();
 
	}
 
	@Column(nullable = true)

	private Long candidate360Id;
 
	@Column(nullable = true)

	private Boolean isMatchingMrf = false;
 
	public Candidate() {
 
		super();
 
	}
 
	public Long getCandidate360Id() {

		return candidate360Id;

	}
 
	public void setCandidate360Id(Long candidate360Id) {

		this.candidate360Id = candidate360Id;

	}
 
	public Long getCandidateId() {
 
		return candidateId;
 
	}
 
	public void setCandidateId(Long candidateId) {
 
		this.candidateId = candidateId;
 
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
 
	public String getGender() {
 
		return gender;
 
	}
 
	public void setGender(String gender) {
 
		this.gender = gender;
 
	}
 
	public String getMobileNumber() {
 
		return mobileNumber;
 
	}
 
	public void setMobileNumber(String mobileNumber) {
 
		this.mobileNumber = mobileNumber;
 
	}
 
	public String getEmail() {
 
		return email;
 
	}
 
	public void setEmail(String email) {
 
		this.email = email;
 
	}
 
	public String getTotalExperience() {

		return totalExperience;
 
	}
 
	public void setTotalExperience(String totalExperience) {

		this.totalExperience = totalExperience;
 
	}
 
	public String getRelevantExperience() {

		return relevantExperience;
 
	}
 
	public void setRelevantExperience(String relevantExperience) {

		this.relevantExperience = relevantExperience;
 
	}
 
	public String getCurrentCompany() {
 
		return currentCompany;
 
	}
 
	public void setCurrentCompany(String currentCompany) {
 
		this.currentCompany = currentCompany;
 
	}
 
	public String getCurrentLocation() {
 
		return currentLocation;
 
	}
 
	public void setCurrentLocation(String currentLocation) {
 
		this.currentLocation = currentLocation;
 
	}
 
	public String getCurrentCTC() {
 
		return currentCTC;
 
	}
 
	public void setCurrentCTC(String currentCTC) {
 
		this.currentCTC = currentCTC;
 
	}
 
	public String getExpectedCTC() {
 
		return expectedCTC;
 
	}
 
	public void setExpectedCTC(String expectedCTC) {
 
		this.expectedCTC = expectedCTC;
 
	}
 
	public String getEmployementMode() {
 
		return employementMode;
 
	}
 
	public void setEmployementMode(String employementMode) {
 
		this.employementMode = employementMode;
 
	}
 
	public String getPreviousRole() {
 
		return previousRole;
 
	}
 
	public void setPreviousRole(String previousRole) {
 
		this.previousRole = previousRole;
 
	}
 
	public String getNoticePeriod() {
 
		return noticePeriod;
 
	}
 
	public void setNoticePeriod(String noticePeriod) {
 
		this.noticePeriod = noticePeriod;
 
	}
 
	public String getRelocate() {
 
		return relocate;
 
	}
 
	public void setRelocate(String relocate) {
 
		this.relocate = relocate;
 
	}
 
	public String getEducation() {
 
		return Education;
 
	}
 
	public void setEducation(String education) {
 
		Education = education;
 
	}
 
	public String getResume() {
 
		return resume;
 
	}
 
	public void setResume(String resume) {
 
		this.resume = resume;
 
	}
 
	public String getSource() {
 
		return source;
 
	}
 
	public void setSource(String source) {
 
		this.source = source;
 
	}
 
	public long getSourceId() {
 
		return sourceId;
 
	}
 
	public void setSourceId(long sourceId) {
 
		this.sourceId = sourceId;
 
	}
 
	public String getSkill() {
 
		return skill;
 
	}
 
	public void setSkill(String skill) {
 
		this.skill = skill;
 
	}
 
	public String getLocation() {
 
		return location;
 
	}
 
	public void setLocation(String location) {
 
		this.location = location;
 
	}
 
	public String getPanNumber() {
 
		return panNumber;
 
	}
 
	public void setPanNumber(String panNumber) {
 
		this.panNumber = panNumber;
 
	}
 
	public String getStatus() {
 
		return status;
 
	}
 
	public void setStatus(String status) {
 
		this.status = status;
 
	}
 
	public String getPassword() {
 
		return password;
 
	}
 
	public void setPassword(String password) {
 
		this.password = password;
 
	}
 
	public CandidateDocument getDocuments() {

		return documents;

	}
 
	public void setDocuments(CandidateDocument documents) {

		this.documents = documents;

	}
 
	public LocalDateTime getAssignedAt() {
 
		return assignedAt;
 
	}
 
	public void setAssignedAt(LocalDateTime assignedAt) {
 
		this.assignedAt = assignedAt;
 
	}
 
	public List<String> getCertifications() {
 
		return certifications;
 
	}
 
	public void setCertifications(List<String> certifications) {
 
		this.certifications = certifications;
 
	}
 
	public String getVisaDetails() {
 
		return visaDetails;
 
	}
 
	public void setVisaDetails(String visaDetails) {
 
		this.visaDetails = visaDetails;
 
	}
 
	public byte[] getCandidateProfileImage() {
 
		return candidateProfileImage;
 
	}
 
	public void setCandidateProfileImage(byte[] candidateProfileImage) {
 
		this.candidateProfileImage = candidateProfileImage;
 
	}
 
	public List<MrfJd> getMrfJd() {
 
		return MrfJd;
 
	}
 
	public void setMrfJd(List<MrfJd> mrfJd) {
 
		MrfJd = mrfJd;
 
	}
 
	public ThirdPartyCredentitals getCredentials() {
 
		return credentials;
 
	}
 
	public void setCredentials(ThirdPartyCredentitals credentials) {
 
		this.credentials = credentials;
 
	}
 
	public Boolean getIsPasswordChanged() {
 
		return isPasswordChanged;
 
	}
 
	public void setIsPasswordChanged(Boolean isPasswordChanged) {
 
		this.isPasswordChanged = isPasswordChanged;
 
	}
 
	public Boolean getIsMatchingMrf() {

		return isMatchingMrf;

	}
 
	public void setIsMatchingMrf(Boolean isMatchingMrf) {

		this.isMatchingMrf = isMatchingMrf;

	}
 
}

 