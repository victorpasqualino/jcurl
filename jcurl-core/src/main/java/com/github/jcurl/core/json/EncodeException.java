package com.github.jcurl.core.json;

public class EncodeException extends RuntimeException {

	private static final long serialVersionUID = 7674752500486926887L;

	public EncodeException(String message) {
		super(message);
	}

	public EncodeException(String message, Throwable cause) {
		super(message, cause);
	}

	public EncodeException() {
	}

}
