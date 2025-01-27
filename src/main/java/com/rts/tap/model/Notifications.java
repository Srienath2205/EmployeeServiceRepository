package com.rts.tap.model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "Notifications")
public class Notifications {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long notificationId;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, optional = true)
	private Candidate candidate;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, optional = true)
	private Employee employee;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, optional = true)
	private Client client;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE }, optional = true)
	private Vendor vendor;

	@Column(nullable = true)
	private String message;

	@Column(nullable = true)
	private LocalDate date;

	@Column(nullable = true)
	private Boolean isSeen;

	@Column(nullable = true)
	private Long fromId;

	@Column(nullable = true)
	private String source;

	public Notifications() {
		super();
	}

	public Long getNotificationId() {
		return notificationId;
	}

	public void setNotificationId(Long notificationId) {
		this.notificationId = notificationId;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Vendor getVendor() {
		return vendor;
	}

	public void setVendor(Vendor vendor) {
		this.vendor = vendor;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Boolean getIsSeen() {
		return isSeen;
	}

	public void setIsSeen(Boolean isSeen) {
		this.isSeen = isSeen;
	}

	public Long getFromId() {
		return fromId;
	}

	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	@PrePersist
	protected void onCreate() {
		this.date = LocalDate.now();
	}

}
