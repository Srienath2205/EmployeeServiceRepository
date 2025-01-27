package com.rts.tap.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "business_units")
public class BusinessUnit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "businessunit_id")
	private Long businessunitId;

	@Column(name = "business_unit_name")
	private String businessUnitName;

	@Column(name = "description")
	private String description;

	@Column(name = "business_unit_location")
	private String businessUnitLocation;

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
        updatedDate = LocalDateTime.now(); // Only update updatedDate on update
    }

	public Long getBusinessunitId() {
		return businessunitId;
	}

	public void setBusinessunitId(Long businessunitId) {
		this.businessunitId = businessunitId;
	}

	public String getBusinessUnitName() {
		return businessUnitName;
	}

	public void setBusinessUnitName(String businessUnitName) {
		this.businessUnitName = businessUnitName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBusinessUnitLocation() {
		return businessUnitLocation;
	}

	public void setBusinessUnitLocation(String businessUnitLocation) {
		this.businessUnitLocation = businessUnitLocation;
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

	public Organization getOrganization() {
		return organization;
	}

	public void setOrganization(Organization organization) {
		this.organization = organization;
	}

	public BusinessUnit(Long businessunitId, String businessUnitName, String description, String businessUnitLocation,
			LocalDateTime createdDate, LocalDateTime updatedDate, Organization organization) {
		super();
		this.businessunitId = businessunitId;
		this.businessUnitName = businessUnitName;
		this.description = description;
		this.businessUnitLocation = businessUnitLocation;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.organization = organization;
	}

	public BusinessUnit() {
		super();
	}
	
	

}
