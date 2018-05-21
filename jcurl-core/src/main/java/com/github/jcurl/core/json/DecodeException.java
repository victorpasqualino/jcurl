package com.github.jcurl.core.json;

public class DecodeException extends RuntimeException {

	private static final long serialVersionUID = 5216083589639559906L;

	public DecodeException() {
	}

	public DecodeException(String message) {
		super(message);
	}

	public DecodeException(String message, Throwable cause) {
		super(message, cause);
	}

}
