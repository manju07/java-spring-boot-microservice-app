#!/bin/bash
docker image push manju0707/sample-springboot-microservice-docker-cloud-config-server:0.0.1-SNAPSHOT 
docker image push manju0707/sample-springboot-microservice-docker-eureka-naming-server:0.0.1-SNAPSHOT 
docker image push manju0707/sample-springboot-microservice-docker-oauth2-authentication-server:0.0.1-SNAPSHOT 
docker image push manju0707/sample-springboot-microservice-docker-user-service:0.0.1-SNAPSHOT
docker image push manju0707/sample-springboot-microservice-docker-group-service:0.0.1-SNAPSHOT 
docker image push manju0707/sample-springboot-microservice-docker-zuul-api-gateway-server:0.0.1-SNAPSHOT