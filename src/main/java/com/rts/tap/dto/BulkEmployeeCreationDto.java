package com.rts.tap.dto;

public class BulkEmployeeCreationDto {
	
	private String employeeName;
	private String employeeEmail;
    private String role;
    private String workLocation;
    private String managerName;
    private String managerEmail;
    private String errorMessage;
    
    
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getWorkLocation() {
		return workLocation;
	}
	public void setWorkLocation(String workLocation) {
		this.workLocation = workLocation;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerEmail() {
		return managerEmail;
	}
	public void setManagerEmail(String managerEmail) {
		this.managerEmail = managerEmail;
	}
	
	public BulkEmployeeCreationDto(String employeeName, String employeeEmail, String role, String workLocation,
			String managerName, String managerEmail, String errorMessage) {
		super();
		this.employeeName = employeeName;
		this.employeeEmail = employeeEmail;
		this.role = role;
		this.workLocation = workLocation;
		this.managerName = managerName;
		this.managerEmail = managerEmail;
		this.errorMessage = errorMessage;
	}
	public BulkEmployeeCreationDto() {
		super();
	}
    
}
