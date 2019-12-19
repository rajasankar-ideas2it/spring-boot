package com.powerplay.exception;

public class ErrorResponse {

	private int status;

	private String message;

	public ErrorResponse(int status, String message) {
		super();
		this.setStatus(status);
		this.setMessage(message);
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String toString() {
		return "ErrorResponse [status " + status + ", message=" + message + "]";
	}
}
