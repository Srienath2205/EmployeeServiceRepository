package com.rts.tap.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "departments")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id")
    private Long departmentId;

    @Column(name = "department_name")
    private String departmentName;
    
    @Column(name = "description")
	private String description;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;
	
	@ManyToOne
	@JoinColumn(name = "organization_id")
	private Organization organization;
    
    
    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
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

	public Department() {
		super();
	}

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Department(Long departmentId, String departmentName, String description, LocalDateTime createdDate,
			LocalDateTime updatedDate, Organization organization) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.description = description;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.organization = organization;
	}

	
     
}
