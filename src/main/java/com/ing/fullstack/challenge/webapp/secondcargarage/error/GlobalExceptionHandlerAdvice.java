package com.ing.fullstack.challenge.webapp.secondcargarage.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandlerAdvice extends ResponseEntityExceptionHandler {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandlerAdvice.class);
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception inEx) {
		return error(HttpStatus.INTERNAL_SERVER_ERROR, inEx);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException inEx) {
		return error(HttpStatus.INTERNAL_SERVER_ERROR, inEx);
	}
	
	@ExceptionHandler(ResourceStorageException.class)
	public ResponseEntity<String> handleResourceStorageException(ResourceStorageException inEx) {
		return error(HttpStatus.INTERNAL_SERVER_ERROR, inEx);
	}
	
	@ExceptionHandler({APIRequestProcessingException.class})
	public ResponseEntity<String> handleAPIRequestProcessingException(APIRequestProcessingException inStProcEx) {
		return error(HttpStatus.INTERNAL_SERVER_ERROR, inStProcEx);
	}
	
	@ExceptionHandler({RuntimeException.class})
    public ResponseEntity<String> handleRunTimeException(final RuntimeException inRunEx) {
        return error(HttpStatus.INTERNAL_SERVER_ERROR, inRunEx);
    }
	
	private ResponseEntity<String> error(final HttpStatus status, final Exception inEx) {
		LOGGER.error("Exception : ", inEx);
        return ResponseEntity.status(status).body(inEx.getMessage());
    }

}
