package com.sample.springboot.microservices.oauth2authenticationserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

/**
 * @author Manjunath Asundi
 */
@SpringBootApplication
@EntityScan(basePackages = {"com.sample.springboot.microservices.common.code.entity"})
public class Oauth2AuthenticationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(Oauth2AuthenticationServerApplication.class, args);
	}
}