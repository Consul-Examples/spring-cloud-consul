package com.rudra.aks.consul;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class Application {

    @RequestMapping("/")
    public String home() {
        return "Hello! App is working.";
    }

        
    @RequestMapping("/status")
    public ResponseEntity<?>	checkHealth() {
    	//return new ResponseEntity<>(HttpStatus.TOO_MANY_REQUESTS);
    	//return new ResponseEntity<>(new HealthStatus("test-warn", HttpStatus.TOO_MANY_REQUESTS).getCode());
    	return new ResponseEntity<>(HealthStatus.code);
    }
    
    public static void main(String[] args) {
        System.getProperties().put("server.port", 8910);
    	new SpringApplicationBuilder(Application.class).web(true).run(args);
    }

}