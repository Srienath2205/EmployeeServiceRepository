package com.rts.tap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "OrganizationLocation")
public class OrganizationLocation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id")
	private Long locationId;

	@Column(name = "location_name")
	private String locationName;

	@Column(name = "location_address")
	private String locationAddress;
	
	@Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}


	public Long getLocationId() {
		return locationId;
	}

	public void setLocationId(Long locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public OrganizationLocation(Long locationId, String locationName, String locationAddress, double latitude,
			double longitude) {
		super();
		this.locationId = locationId;
		this.locationName = locationName;
		this.locationAddress = locationAddress;
		this.latitude = latitude;
		this.longitude = longitude;
	}


	public String getLocationAddress() {
		return locationAddress;
	}

	public void setLocationAddress(String locationAddress) {
		this.locationAddress = locationAddress;
	}


	public OrganizationLocation() {
		super();
		this.latitude = 37.7749; // Example: San Francisco's latitude
	    this.longitude = -122.4194; // Example: San Francisco's longitude
	}
	
}
