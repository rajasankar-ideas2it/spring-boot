package com.powerplay.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final String ERROR = "Oops!";

	@ExceptionHandler(value = { EntityNotFoundException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse entityNotFound(EntityNotFoundException ex) {
		logger.error(ERROR, ex);
		return ex.getErrResponse();
	}
}
