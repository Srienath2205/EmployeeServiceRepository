package com.rts.tap.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

@Entity
@Table(name = "organizations")
public class Organization {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "organization_id")
    private Long organizationId;

    @Column(name = "organization_name", unique = true)
    private String organizationName;

    @Column(name = "organization_address")
    private String organizationAddress;

    @Column(name = "contact_person_name")
    private String contactPersonName;

    @Column(name = "contact_person_email")
    private String contactPersonEmail;

    @Column(name = "contact_person_phone")
    private String contactPersonPhone;

    @Column(name = "organization_websiteurl")
    private String organizationWebsiteUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "industry_type")
    private Industry industryType;

    @Enumerated(EnumType.STRING)
    @Column(name = "organization_size")
    private OrganizationSize size;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "organization_establisheddate")
    private LocalDateTime organizationEstablishedDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "organization_status")
    private Status organizationStatus;

    @Column(name = "created_date", updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime createdDate;

    @Column(name = "updated_date")
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime updatedDate;
    
    @Lob
    @Column(name = "organization_logo",length = 100000)
    private byte[] logo;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }

    public enum Industry {
        TECHNOLOGY, FINANCE, HEALTHCARE, EDUCATION, OTHER
    }

    public enum OrganizationSize {
        SMALL, MEDIUM, LARGE
    }

    public enum Status {
        ACTIVE, INACTIVE
    }

	public Long getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Long organizationId) {
		this.organizationId = organizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getOrganizationAddress() {
		return organizationAddress;
	}

	public void setOrganizationAddress(String organizationAddress) {
		this.organizationAddress = organizationAddress;
	}

	public String getContactPersonName() {
		return contactPersonName;
	}

	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	public String getContactPersonEmail() {
		return contactPersonEmail;
	}

	public void setContactPersonEmail(String contactPersonEmail) {
		this.contactPersonEmail = contactPersonEmail;
	}

	public String getContactPersonPhone() {
		return contactPersonPhone;
	}

	public void setContactPersonPhone(String contactPersonPhone) {
		this.contactPersonPhone = contactPersonPhone;
	}

	public String getOrganizationWebsiteUrl() {
		return organizationWebsiteUrl;
	}

	public void setOrganizationWebsiteUrl(String organizationWebsiteUrl) {
		this.organizationWebsiteUrl = organizationWebsiteUrl;
	}

	public Industry getIndustryType() {
		return industryType;
	}

	public void setIndustryType(Industry industryType) {
		this.industryType = industryType;
	}

	public OrganizationSize getSize() {
		return size;
	}

	public void setSize(OrganizationSize size) {
		this.size = size;
	}

	public LocalDateTime getOrganizationEstablishedDate() {
		return organizationEstablishedDate;
	}

	public void setOrganizationEstablishedDate(LocalDateTime organizationEstablishedDate) {
		this.organizationEstablishedDate = organizationEstablishedDate;
	}

	public Status getOrganizationStatus() {
		return organizationStatus;
	}

	public void setOrganizationStatus(Status organizationStatus) {
		this.organizationStatus = organizationStatus;
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

	public byte[] getLogo() {
		return logo;
	}

	public void setLogo(byte[] logo) {
		this.logo = logo;
	}

	public Organization(Long organizationId, String organizationName, String organizationAddress,
			String contactPersonName, String contactPersonEmail, String contactPersonPhone,
			String organizationWebsiteUrl, Industry industryType, OrganizationSize size,
			LocalDateTime organizationEstablishedDate, Status organizationStatus, LocalDateTime createdDate,
			LocalDateTime updatedDate, byte[] logo) {
		super();
		this.organizationId = organizationId;
		this.organizationName = organizationName;
		this.organizationAddress = organizationAddress;
		this.contactPersonName = contactPersonName;
		this.contactPersonEmail = contactPersonEmail;
		this.contactPersonPhone = contactPersonPhone;
		this.organizationWebsiteUrl = organizationWebsiteUrl;
		this.industryType = industryType;
		this.size = size;
		this.organizationEstablishedDate = organizationEstablishedDate;
		this.organizationStatus = organizationStatus;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.logo = logo;
	}

	public Organization() {
		super();
	}
    
}
