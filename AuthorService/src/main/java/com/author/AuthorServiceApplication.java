package com.author;

import org.springframework.boot.SpringApplication;
//package org.springframework.cloud.netflix.eureka.server;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
//import org.springframework.web.servlet.config.annotation.EnableEurekaServer;

@SpringBootApplication
public class AuthorServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorServiceApplication.class, args);
	}
	
	
	
	
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	
	

}
