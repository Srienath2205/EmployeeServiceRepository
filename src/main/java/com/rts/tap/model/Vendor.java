package com.rts.tap.model;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "vendors")
public class Vendor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long vendorId;

	@Column(unique = true)
	private String organizationName;

	@Column
	private String address;

	@Column
	private String contactNumber;

	@Column
	private String websiteUrl;

	@Column
	private String taxIdentifyNumber;

	@Column
	private String isPasswordChanged;

	@OneToOne
	private ThirdPartyCredentitals thirdPartyCredentitals;

	@Column
	private String contactName;

	@Lob
	@Column(length = 1000000000)
	private byte[] vendorOrganizationLogo;

	public Vendor() {
		super();
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getWebsiteUrl() {
		return websiteUrl;
	}

	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	public String getTaxIdentifyNumber() {
		return taxIdentifyNumber;
	}

	public void setTaxIdentifyNumber(String taxIdentifyNumber) {
		this.taxIdentifyNumber = taxIdentifyNumber;
	}

	public String getIsPasswordChanged() {
		return isPasswordChanged;
	}

	public void setIsPasswordChanged(String isPasswordChanged) {
		this.isPasswordChanged = isPasswordChanged;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public Long getVendorId() {
		return vendorId;
	}

	public void setVendorId(Long vendorId) {
		this.vendorId = vendorId;
	}

	public ThirdPartyCredentitals getThirdPartyCredentitals() {
		return thirdPartyCredentitals;
	}

	public void setThirdPartyCredentitals(ThirdPartyCredentitals thirdPartyCredentitals) {
		this.thirdPartyCredentitals = thirdPartyCredentitals;
	}

	public byte[] getVendorOrganizationLogo() {
		return vendorOrganizationLogo;
	}

	public void setVendorOrganizationLogo(byte[] vendorOrganizationLogo) {
		this.vendorOrganizationLogo = vendorOrganizationLogo;
	}

	@Override
	public String toString() {
		return "Vendor [vendorId=" + vendorId + ", organizationName=" + organizationName + ", address=" + address
				+ ", contactNumber=" + contactNumber + ", websiteUrl=" + websiteUrl + ", taxIdentifyNumber="
				+ taxIdentifyNumber + ", isPasswordChanged=" + isPasswordChanged + ", thirdPartyCredentitals="
				+ thirdPartyCredentitals + ", contactName=" + contactName + ", vendorOrganizationLogo="
				+ Arrays.toString(vendorOrganizationLogo) + "]";
	}

}
