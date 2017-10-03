package com.rudra.aks.consul.exception;

import org.springframework.http.HttpStatus;

public class ConsulException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HttpStatus	code;

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public ConsulException() {
		super();
	}

	public ConsulException(HttpStatus code) {
		super();
		this.code = code;
	}
	
	
}
