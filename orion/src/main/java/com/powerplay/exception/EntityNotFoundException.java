package com.powerplay.exception;

/**
 * <p>
 * Custom validation exception.
 * </p>
 * 
 * @author Rajasankar.s
 *
 */
public class EntityNotFoundException extends Exception {

	private static final long serialVersionUID = 4022423121886315860L;

	private final ErrorResponse errResponse;

	public EntityNotFoundException(ErrorResponse errResponse) {
		this.errResponse = errResponse;
	}

	public ErrorResponse getErrResponse() {
		return errResponse;
	}

}
