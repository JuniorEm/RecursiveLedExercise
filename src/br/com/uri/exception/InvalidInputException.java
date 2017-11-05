package br.com.uri.exception;

public class InvalidInputException extends RuntimeException {

	public InvalidInputException(final String message) {
		super(message);
	}
	
	public InvalidInputException(final String message, final Throwable cause) {
		super(message, cause);
	}
	
	private static final long serialVersionUID = 4038363651723284854L;
}
