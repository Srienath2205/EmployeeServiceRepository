package com.rts.tap.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ThirdPartyRole")
public class ThirdPartyRole {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int thirdPartyRoleId;
	
	@Column
	private String role;

	public ThirdPartyRole() {
		super();
	}

	public int getThirdPartyRoleId() {
		return thirdPartyRoleId;
	}

	public void setThirdPartyRoleId(int thirdPartyRoleId) {
		this.thirdPartyRoleId = thirdPartyRoleId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}