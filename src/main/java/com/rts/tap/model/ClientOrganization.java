package com.rts.tap.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "clientOrganization_tbl")
public class ClientOrganization {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long clientOrganizationId;

	@Column
	private String organizationName;

	@Lob
	@Column(columnDefinition = "LONGBLOB",length=1000000000)
	private byte[] organizationLogo;

	@Column
	private String organizationIndustry;

	@Column
	private String organizationAddress;

	@Column
	private String organizationContactNumber;

	@Column
	private String organizationEmail;

	public ClientOrganization() {
		super();
	}

	public Long getClientOrganizationId() {
		return clientOrganizationId;
	}

	public void setClientOrganizationId(Long clientOrganizationId) {
		this.clientOrganizationId = clientOrganizationId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public byte[] getOrganizationLogo() {
		return organizationLogo;
	}

	public void setOrganizationLogo(byte[] organizationLogo) {
		this.organizationLogo = organizationLogo;
	}

	public String getOrganizationIndustry() {
		return organizationIndustry;
	}

	public void setOrganizationIndustry(String organizationIndustry) {
		this.organizationIndustry = organizationIndustry;
	}

	public String getOrganizationAddress() {
		return organizationAddress;
	}

	public void setOrganizationAddress(String organizationAddress) {
		this.organizationAddress = organizationAddress;
	}

	public String getOrganizationContactNumber() {
		return organizationContactNumber;
	}

	public void setOrganizationContactNumber(String organizationContactNumber) {
		this.organizationContactNumber = organizationContactNumber;
	}

	public String getOrganizationEmail() {
		return organizationEmail;
	}

	public void setOrganizationEmail(String organizationEmail) {
		this.organizationEmail = organizationEmail;
	}

	@Override
	public String toString() {
		return "ClientOrganization [clientOrganizationId=" + clientOrganizationId + ", organizationName="
				+ organizationName + ", organizationLogo=" + Arrays.toString(organizationLogo)
				+ ", organizationIndustry=" + organizationIndustry + ", organizationAddress=" + organizationAddress
				+ ", organizationContactNumber=" + organizationContactNumber + ", organizationEmail="
				+ organizationEmail + "]";
	}
	

}
