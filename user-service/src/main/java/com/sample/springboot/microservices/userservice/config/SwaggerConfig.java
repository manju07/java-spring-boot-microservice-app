package com.sample.springboot.microservices.userservice.config;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.xmlpull.v1.XmlPullParserException;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
/**
 * @author Manjunath Asundi
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() throws IOException, XmlPullParserException {

        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.sample.springboot.microservices.userservice.controller"))
                .paths(PathSelectors.any()).build()
                .apiInfo(new ApiInfo("USER-SERVICE REST API's",
                        "This pages USER-SERVICE RESTful web service endpoints", "1.0", "https://www.linkedin.com/in/manju07/",
                        new Contact("Manjunath Asundi", "https://www.linkedin.com/in/manju07/",
                                "manjunathasundi07@gmail.com"),
                        "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0", new ArrayList<>()));
    }
}