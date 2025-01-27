package com.rts.tap.dto;

import com.rts.tap.model.Employee.EmploymentStatus;

public class EmployeeDto {

    private Long employeeId;
    private EmploymentStatus employeeStatus;

    // Default constructor
    public EmployeeDto() {
    }

    // Constructor with parameters for ease of use
    public EmployeeDto(Long employeeId, EmploymentStatus employeeStatus) {
        this.employeeId = employeeId;
        this.employeeStatus = employeeStatus;
    }

    // Getters and setters

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public EmploymentStatus getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(EmploymentStatus employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    // Optional: Override toString(), equals(), and hashCode() as needed
    @Override
    public String toString() {
        return "EmployeeDto{" +
                "employeeId=" + employeeId +
                ", employeeStatus=" + employeeStatus +
                '}';
    }
}
