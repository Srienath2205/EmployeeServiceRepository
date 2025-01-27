package com.rts.tap.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class WorkFlow {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long workflowId;

	private String workFlowType;

	private int count;

	@ManyToOne
	private Employee employee;

	@ManyToOne
	private MRF mrf;

	@ManyToOne
	private Employee recruiter;

	private String status;

	private String reason;

	public WorkFlow() {
		super();
	}

	public Long getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(Long workflowId) {
		this.workflowId = workflowId;
	}

	public String getWorkFlowType() {
		return workFlowType;
	}

	public void setWorkFlowType(String workFlowType) {
		this.workFlowType = workFlowType;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public MRF getMrf() {
		return mrf;
	}

	public void setMrf(MRF mrf) {
		this.mrf = mrf;
	}

	public Employee getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(Employee recruiter) {
		this.recruiter = recruiter;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
}
