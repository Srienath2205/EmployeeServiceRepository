package com.rts.tap.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class ApproverLevel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long approverId;

	@ManyToOne
	@JoinColumn(name = "mrfId")
	private MRF mrf;

	@ManyToOne
	@JoinColumn(name = "employeeId")
	private Employee employee;

	@Column
	private int level;

	public Long getApproverId() {
		return approverId;
	}

	public void setApproverId(Long approverId) {
		this.approverId = approverId;
	}

	public MRF getMrf() {
		return mrf;
	}

	public void setMrf(MRF mrf) {
		this.mrf = mrf;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "ApproverLevel [approverId=" + approverId + ", mrf=" + mrf + ", employee=" + employee + ", level="
				+ level + "]";
	}
}
