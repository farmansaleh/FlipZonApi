package com.flipzon.dto;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotEmpty;

@MappedSuperclass
public class CurrentUserDtl {
	
	@NotEmpty
	@CreatedBy
	private String createdBy;
	
	@NotEmpty
	//@JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss")
	@CreatedDate
	private LocalDateTime createdDate;
	
	@NotEmpty
	private int status;
	


	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDateTime createdDate) {
		this.createdDate = createdDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
