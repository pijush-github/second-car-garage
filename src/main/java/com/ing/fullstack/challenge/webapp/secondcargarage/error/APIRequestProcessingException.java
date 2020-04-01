package com.ing.fullstack.challenge.webapp.secondcargarage.error;

public class APIRequestProcessingException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public APIRequestProcessingException() {}

	public APIRequestProcessingException(String message) {
		super(message);
	}

	public APIRequestProcessingException(Throwable cause) {
		super(cause);
	}

	public APIRequestProcessingException(String message, Throwable cause) {
		super(message, cause);
	}

	public APIRequestProcessingException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
