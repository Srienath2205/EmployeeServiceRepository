package com.rts.tap.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "referrals")

public class ReferralCandiate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "referral_id")
	private Long referralId;

	@ManyToOne
	@JoinColumn(name = "referring_employee_id", nullable = false)
	private Employee referringEmployee;

	@Column(name = "referred_candiate_name", nullable = false)
	private String referredCandiateName;

	@Column(name = "referred_candiate_email", nullable = false)
	private String referredCandiateEmail;

	@Column(name = "referred_position", nullable = false)
	private String referredPosition;

	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "referral_date", nullable = false)
	private LocalDateTime referralDate;

	@Enumerated(EnumType.STRING)
	@Column(name = "status", nullable = false)
	private ReferralStatus status;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@Column(name = "updated_date")
	private LocalDateTime updatedDate;

	@Lob
	@Column(nullable = false, length = 1000000)
	private byte[] candiateResume;

	public enum ReferralStatus {
		PENDING, INTERVIEWED, HIRED, NOT_HIRED
	}
}
