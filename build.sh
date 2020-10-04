#!/bin/bash
docker image rm manju0707/sample-springboot-microservice-docker-cloud-config-server:0.0.1-SNAPSHOT -f
cd cloud-config-server
mvn clean package

docker image rm manju0707/sample-springboot-microservice-docker-eureka-naming-server:0.0.1-SNAPSHOT -f
cd ../eureka-naming-server
mvn clean package

docker image rm manju0707/sample-springboot-microservice-docker-oauth2-authentication-server:0.0.1-SNAPSHOT -f
cd ../oauth2-authentication-server
mvn clean package

docker image rm manju0707/sample-springboot-microservice-docker-user-service:0.0.1-SNAPSHOT -f
cd ../user-service
mvn clean package

docker image rm manju0707/sample-springboot-microservice-docker-group-service:0.0.1-SNAPSHOT -f
cd ../group-service
mvn clean package

docker image rm manju0707/sample-springboot-microservice-docker-zuul-api-gateway-server:0.0.1-SNAPSHOT -f
cd ../zuul-api-gateway-server
mvn clean package

cd ..