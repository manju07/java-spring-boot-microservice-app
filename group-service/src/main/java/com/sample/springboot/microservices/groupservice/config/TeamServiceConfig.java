package com.sample.springboot.microservices.groupservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * TeamService config beans
 * @author Manjunath Asundi
 */
@Component
public class TeamServiceConfig {
    
    @Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}