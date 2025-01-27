package com.rts.tap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "budget")
public class Budget {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long budgetId;
	@Column
	private double analyzedMinimumCTC;
	@Column
	private double analyzedMaximumCTC;

	@Column
	private double budgetForResource;

	@ManyToOne
	@JoinColumn(name = "requirementId")
	private Requirement requirement;

	@OneToOne
	@JoinColumn(name = "subRequirementId")
	private SubRequirements subRequirementId;

	@Column
	private String yearsOfExperience;
	
	@Column 
	private boolean isNegotiable;

	public Budget() {
		super();
	}

	public Budget(Long budgetId, double analyzedMinimumCTC, double analyzedMaximumCTC, double budgetForResource,
			Requirement requirement, SubRequirements subRequirementId, String yearsOfExperience, boolean isNegotiable) {
		super();
		this.budgetId = budgetId;
		this.analyzedMinimumCTC = analyzedMinimumCTC;
		this.analyzedMaximumCTC = analyzedMaximumCTC;
		this.budgetForResource = budgetForResource;
		this.requirement = requirement;
		this.subRequirementId = subRequirementId;
		this.yearsOfExperience = yearsOfExperience;
		this.isNegotiable = isNegotiable;
	}

	public Long getBudgetId() {
		return budgetId;
	}

	public void setBudgetId(Long budgetId) {
		this.budgetId = budgetId;
	}

	public double getAnalyzedMinimumCTC() {
		return analyzedMinimumCTC;
	}

	public void setAnalyzedMinimumCTC(double analyzedMinimumCTC) {
		this.analyzedMinimumCTC = analyzedMinimumCTC;
	}

	public double getAnalyzedMaximumCTC() {
		return analyzedMaximumCTC;
	}

	public void setAnalyzedMaximumCTC(double analyzedMaximumCTC) {
		this.analyzedMaximumCTC = analyzedMaximumCTC;
	}

	public double getBudgetForResource() {
		return budgetForResource;
	}

	public void setBudgetForResource(double budgetForResource) {
		this.budgetForResource = budgetForResource;
	}

	public Requirement getRequirement() {
		return requirement;
	}

	public void setRequirement(Requirement requirement) {
		this.requirement = requirement;
	}

	public SubRequirements getSubRequirementId() {
		return subRequirementId;
	}

	public void setSubRequirementId(SubRequirements subRequirementId) {
		this.subRequirementId = subRequirementId;
	}

	public String getYearsOfExperience() {
		return yearsOfExperience;
	}

	public void setYearsOfExperience(String yearsOfExperience) {
		this.yearsOfExperience = yearsOfExperience;
	}

	public boolean isNegotiable() {
		return isNegotiable;
	}

	public void setNegotiable(boolean isNegotiable) {
		this.isNegotiable = isNegotiable;
	}

	

}