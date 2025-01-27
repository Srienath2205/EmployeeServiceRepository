package com.rts.tap.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "requirements")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "requirementId")
public class Requirement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long requirementId;

	@Column(nullable = false)
	private int totalRequiredResourceCount;

	@Column(nullable = false)
	private String timeline;

	@Column(nullable = false)
	private double budget;

	@Column(nullable = false, updatable = false)
	private LocalDateTime createdAt;

	@PrePersist
	protected void onCreate() {
		createdAt = LocalDateTime.now();
	}

	@ManyToOne
	private Client client;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "requirementId", referencedColumnName = "requirementId")
	private List<SubRequirements> subrequirement;

	public Requirement() {
		super();
	}

	public Long getRequirementId() {
		return requirementId;
	}

	public void setRequirementId(Long requirementId) {
		this.requirementId = requirementId;
	}

	public int getTotalRequiredResourceCount() {
		return totalRequiredResourceCount;
	}

	public void setTotalRequiredResourceCount(int totalRequiredResourceCount) {
		this.totalRequiredResourceCount = totalRequiredResourceCount;
	}

	public String getTimeline() {
		return timeline;
	}

	public void setTimeline(String timeline) {
		this.timeline = timeline;
	}

	public double getBudget() {
		return budget;
	}

	public void setBudget(double budget) {
		this.budget = budget;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<SubRequirements> getSubrequirement() {
		return subrequirement;
	}

	public void setSubrequirement(List<SubRequirements> subrequirement) {
		this.subrequirement = subrequirement;
	}

}
