package com.ing.fullstack.challenge.webapp.secondcargarage.error;

public class ResourceNotFoundException extends APIRequestProcessingException {

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
