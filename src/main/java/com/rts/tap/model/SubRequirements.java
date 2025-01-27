package com.rts.tap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SubRequirements {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long subRequirementId;

	@Column(nullable = false)
	private String role;
	
	@Column(nullable = false)
	private Long resourceCount;

	public SubRequirements() {
		super();
	}

	public Long getSubRequirementId() {
		return subRequirementId;
	}

	public void setSubRequirementId(Long subRequirementId) {
		this.subRequirementId = subRequirementId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Long getResourceCount() {
		return resourceCount;
	}

	public void setResourceCount(Long resourceCount) {
		this.resourceCount = resourceCount;
	}

}
