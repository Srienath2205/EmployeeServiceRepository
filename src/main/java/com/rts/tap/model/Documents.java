

package com.rts.tap.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;

@Entity
@Table(name = "documents_proof")
public class Documents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "documents_id")
    private Long documentsId;

    @Enumerated(EnumType.STRING)
    @Column(name = "document_type")
    private ProofType documentType;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

   
   
    // Individual Document Fields
    @Column(name = "documentFile")
    private String documentFile;


    public Long getDocumentsId() {
		return documentsId;
	}

	public void setDocumentsId(Long documentsId) {
		this.documentsId = documentsId;
	}

	public ProofType getDocumentType() {
		return documentType;
	}

	public void setDocumentType(ProofType documentType) {
		this.documentType = documentType;
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


	public String getDocumentFile() {
		return documentFile;
	}

	public void setDocumentFile(String documentFile) {
		this.documentFile = documentFile;
	}

	public Documents(Long documentsId, ProofType documentType, LocalDateTime createdDate, LocalDateTime updatedDate,
			String documentFile) {
		super();
		this.documentsId = documentsId;
		this.documentType = documentType;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	
		this.documentFile = documentFile;
	}

	public enum ProofType {
        PASSPORT, AADHAR, PANCARD, EXPERIENCELETTER,DEGREECERTIFICATE, PAYSLIP1, PAYSLIP2, PAYSLIP3 ,VOTERID,SSLC ,HSC ,UG ,PG ,DIPLOMA, PAYSLIP,RELIEVINGLETTER
    }

    @PrePersist
    protected void onCreate() {
        createdDate = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = LocalDateTime.now(); // Update timestamp on modification
    }

    // Default Constructor
    public Documents() {}

    

}