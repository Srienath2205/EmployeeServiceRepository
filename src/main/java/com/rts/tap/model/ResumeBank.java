package com.rts.tap.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ResumeBank {

	@Id
	private String id;
	private String fileId;
	private String fileName;

	public ResumeBank() {
		super();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public ResumeBank(String id, String fileId, String fileName) {
		super();
		this.id = id;
		this.fileId = fileId;
		this.fileName = fileName;
	}
}