package com.example.demo;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class PayConfig {
    
	
	@Bean
    @LoadBalanced
	public RestTemplate getRestTemplate()
	{
		RestTemplate restTemplate=new RestTemplate();
		return restTemplate;
	}
}
