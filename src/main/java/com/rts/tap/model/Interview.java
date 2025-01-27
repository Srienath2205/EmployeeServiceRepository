package com.rts.tap.model;

import java.time.LocalDate;

import java.time.LocalTime;
import jakarta.persistence.Column;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.ManyToOne;

import jakarta.persistence.Table;

@Entity
@Table
public class Interview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long interviewId;

	private String interviewTitle;

	@ManyToOne
	private RecruitmentProcess recruitmentProcess;

	@ManyToOne
	private Candidate candidate;

	private LocalDate interviewDate;

	private LocalTime interviewFromTime;

	private LocalTime interviewToTime;

	private String meetingUrl;

	private String candidateStatus;

	private String Others;

	@Column(nullable = true)
	private String interviewerInterviewRescheduleReason;

	@Column(nullable = true)
	private String candidateInterviewRescheduleReason;

	public Interview() {
		super();
	}

	public Long getInterviewId() {
		return interviewId;
	}

	public void setInterviewId(Long interviewId) {
		this.interviewId = interviewId;
	}

	public String getInterviewTitle() {
		return interviewTitle;
	}

	public void setInterviewTitle(String interviewTitle) {
		this.interviewTitle = interviewTitle;
	}

	public RecruitmentProcess getRecruitmentProcess() {
		return recruitmentProcess;
	}

	public void setRecruitmentProcess(RecruitmentProcess recruitmentProcess) {
		this.recruitmentProcess = recruitmentProcess;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public LocalDate getInterviewDate() {
		return interviewDate;
	}

	public void setInterviewDate(LocalDate interviewDate) {
		this.interviewDate = interviewDate;
	}

	public LocalTime getInterviewFromTime() {
		return interviewFromTime;
	}

	public void setInterviewFromTime(LocalTime interviewFromTime) {
		this.interviewFromTime = interviewFromTime;
	}

	public LocalTime getInterviewToTime() {
		return interviewToTime;
	}

	public void setInterviewToTime(LocalTime interviewToTime) {
		this.interviewToTime = interviewToTime;
	}

	public String getMeetingUrl() {
		return meetingUrl;
	}

	public void setMeetingUrl(String meetingUrl) {
		this.meetingUrl = meetingUrl;
	}

	public String getCandidateStatus() {
		return candidateStatus;
	}

	public void setCandidateStatus(String candidateStatus) {
		this.candidateStatus = candidateStatus;
	}

	public String getOthers() {
		return Others;
	}

	public void setOthers(String others) {
		Others = others;
	}

	public String getInterviewerInterviewRescheduleReason() {
		return interviewerInterviewRescheduleReason;
	}

	public void setInterviewerInterviewRescheduleReason(String interviewerInterviewRescheduleReason) {
		this.interviewerInterviewRescheduleReason = interviewerInterviewRescheduleReason;
	}

	public String getCandidateInterviewRescheduleReason() {
		return candidateInterviewRescheduleReason;
	}

	public void setCandidateInterviewRescheduleReason(String candidateInterviewRescheduleReason) {
		this.candidateInterviewRescheduleReason = candidateInterviewRescheduleReason;
	}

}
