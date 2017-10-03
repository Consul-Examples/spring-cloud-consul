package com.rudra.aks.consul.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rudra.aks.consul.HealthStatus;
import com.rudra.aks.consul.exception.ConsulException;

@RestController
@RequestMapping("/consul")
public class ConsulRestController {

	private static Logger logger = LoggerFactory.getLogger(ConsulRestController.class);

	
	@GetMapping(path = "/get/{msg}")
	public ResponseEntity<?>	get(@PathVariable("msg") String msg) throws ConsulException {
		logger.info("Start : " + getClass().getName() + " : get()");
		if( "critical".equals(msg))
			throw new ConsulException(HttpStatus.TOO_MANY_REQUESTS);
		long[] ar = new long[Integer.MAX_VALUE];
		return new ResponseEntity<>("success" + msg, HttpStatus.OK);
	}
	
	@GetMapping(path = "/up")
	public ResponseEntity<?>  makeHealthUp() {
		HealthStatus.code = HttpStatus.OK;
		return new ResponseEntity<>("success! health is up." , HttpStatus.OK);
	}
}
