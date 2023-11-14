package com.sample.springboot.microservices.groupservice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
/**
 * @author Manjunath Asundi
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableResourceServer
@EntityScan(basePackages = {"com.sample.springboot.microservices.common.code.entity"})
public class GroupServiceApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GroupServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// write something here
		System.out.println("running group-service");
	}
}