package com.sample.springboot.microservices.zuulapigatewayserver.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

/**
 * @author Manjunath Asundi
 */
@Component
@Primary
@EnableAutoConfiguration
public class DocumentationController implements SwaggerResourcesProvider {
 
    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new ArrayList<SwaggerResource>();
        resources.add(swaggerResource("user-service", "/microservice/secure/api/v1/user-service/v2/api-docs", "1.0"));
//        resources.add(swaggerResource("poll-service", "/microservice/secure/api/v1/poll-service/v2/api-docs", "1.0"));
        resources.add(swaggerResource("group-service", "/microservice/secure/api/v1/group-service/v2/api-docs", "1.0"));
        return resources;
    }
 
    private SwaggerResource swaggerResource(String name, String location, String version) {
        SwaggerResource swaggerResource = new SwaggerResource();
        swaggerResource.setName(name);
        swaggerResource.setLocation(location);
        swaggerResource.setSwaggerVersion(version);
        return swaggerResource;
    }
}