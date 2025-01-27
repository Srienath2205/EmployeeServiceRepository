package com.rts.tap.dto;

public class LoginResponse {

	// Main Employee
	private Long id;
	private String status;
	private String role;
	private Long employeeId;
	private String isPasswordChange;
	private Boolean isChanged;
	private String email;
	
	// Third Party
	private Long clientId;
	private Long candidateId;
	private Long vendorId;
	
	// Token
	private String token; // Add token field
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	    	
	
	public LoginResponse(String status) {
		super();
		this.status = status;
	}

	public String getIsPasswordChange() {
		return isPasswordChange;
	}

	public void setIsPasswordChange(String isPasswordChange) {
		this.isPasswordChange = isPasswordChange;
	}
	

	public Boolean getIsChanged() {
		return isChanged;
	}

	public void setIsChanged(Boolean isChanged) {
		this.isChanged = isChanged;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}

	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long clientId) {
		this.clientId = clientId;
	}

	public Long getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}
	
	public LoginResponse(Long candidateId) {
		this.candidateId = candidateId;
	}

	
	@Override
	public String toString() {
		return "LoginResponse [id=" + id + ", status=" + status + ", role=" + role + ", employeeId=" + employeeId + "]";
	}

	public LoginResponse(Long id, String status, String role, Long employeeId, String isPasswordChange,
			Boolean isChanged, String email, Long clientId, Long candidateId, Long vendorId) {
		super();
		this.id = id;
		this.status = status;
		this.role = role;
		this.employeeId = employeeId;
		this.isPasswordChange = isPasswordChange;
		this.isChanged = isChanged;
		this.email = email;
		this.clientId = clientId;
		this.candidateId = candidateId;
		this.vendorId = vendorId;
	}



public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

public LoginResponse(String status, String role, Boolean isChanged, String email, Long clientId) {
	super();
	this.status = status;
	this.role = role;
	this.isChanged = isChanged;
	this.email = email;
	this.clientId = clientId;
}



	
	
	
	

	

	
	

	
	

	
}
