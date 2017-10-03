package com.rudra.aks.consul;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class HealthStatus {

	public static String msg;
	public static HttpStatus	code;
	
	@PostConstruct
	public void init() {
		msg = "test-consul up";
		code = HttpStatus.OK;
	}
	
	public HealthStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HealthStatus(String msg, HttpStatus code) {
		super();
		HealthStatus.msg = msg;
		HealthStatus.code = code;
	}
	
	public String getMsg() {
		return msg;
	}
	
	public HttpStatus getCode() {
		return code;
	}
		
	
}
