package com.rts.tap.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

@Entity
@Table(name = "Login_Credentials")
public class LoginCredentials {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_email", nullable = false)
    private String userEmail;

	@Column(name = "password_hash", nullable = false)
	private String passwordHash;
	
	@Column(name = "ispassword_change")
	private String isPasswordChange = "NO";
    
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @Column(name = "failed_attempts", nullable = false, columnDefinition = "int default 0")
    private int failedAttempts = 0; // Track the number of failed login attempts

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "lockout_time")
    private LocalDateTime lockoutTime; // Track when the lockout ends

    @Column(name = "lockout_count", nullable = false, columnDefinition = "int default 0")
    private int lockoutCount = 0; // Track the number of times the account has been locked

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_id", unique = true)
    private Employee employee;

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now();
    }

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getPasswordHash() {
		return passwordHash;
	}

	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}

	public String getIsPasswordChange() {
		return isPasswordChange;
	}

	public void setIsPasswordChange(String isPasswordChange) {
		this.isPasswordChange = isPasswordChange;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDateTime getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(LocalDateTime updatedDate) {
		this.updatedDate = updatedDate;
	}

	public int getFailedAttempts() {
		return failedAttempts;
	}

	public void setFailedAttempts(int failedAttempts) {
		this.failedAttempts = failedAttempts;
	}

	public LocalDateTime getLockoutTime() {
		return lockoutTime;
	}

	public void setLockoutTime(LocalDateTime lockoutTime) {
		this.lockoutTime = lockoutTime;
	}

	public int getLockoutCount() {
		return lockoutCount;
	}

	public void setLockoutCount(int lockoutCount) {
		this.lockoutCount = lockoutCount;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public LoginCredentials(Long userId, String userEmail, String passwordHash, String isPasswordChange,
			LocalDateTime createdDate, LocalDateTime updatedDate, int failedAttempts, LocalDateTime lockoutTime,
			int lockoutCount, Employee employee) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.passwordHash = passwordHash;
		this.isPasswordChange = isPasswordChange;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
		this.failedAttempts = failedAttempts;
		this.lockoutTime = lockoutTime;
		this.lockoutCount = lockoutCount;
		this.employee = employee;
	}

	public LoginCredentials() {
		super();
	}

}
