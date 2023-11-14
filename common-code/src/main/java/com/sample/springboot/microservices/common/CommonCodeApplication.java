package com.sample.springboot.microservices.common;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

/**
 * @author Manjunath Asundi
 */
@SpringBootApplication
public class CommonCodeApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CommonCodeApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// write something here
		System.out.println("running CommonCodeApplication");
	}
}