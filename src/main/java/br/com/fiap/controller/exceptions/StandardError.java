package br.com.fiap.controller.exceptions;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

public class StandardError {
	
	@JsonFormat(pattern = "dd/mm/yyyy HH:mm:ss")
	private LocalDateTime timestamp;
	private Integer status;
	private String message;
	private String path;
	
	
	public StandardError() {
		super();
	}


	public StandardError(LocalDateTime timestamp, Integer status, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.message = message;
		this.path = path;
	}


	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	@Override
	public String toString() {
		return "StandardError [timestamp=" + timestamp + ", status=" + status + ", message=" + message + ", path="
				+ path + "]";
	}
	

}
