package com.rudra.aks.consul;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class CustomHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		
		if( (HealthStatus.code).value() == 503 )
			return Health.down().withDetail("Error code", "Out of memory error").build();
		return Health.up().build();
	}

}
