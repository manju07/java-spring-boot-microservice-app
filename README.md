
`rgb(9, 105, 218)` 
##  Microservice Application

This application built on spring boot, spring cloud, Cloud-Config, Eureka Naming server, Zuual API gateway, OAuth-2, Swagger and MySql DB.

`Note:`
- We are using a github repo for managing service config properties files. please clone below repo before running this application locally - [github repo link](https://github.com/manju07/java-spring-boot-microservice-app-config)

- To run MySql locally with docker, please refer this document, its part of this repo `java-spring-boot-microservice-app/dbSetup.md`


## Microservices

### cloud-config-server 
This will provide the service config property during runtime basis on enviroment /configured at service level. 

As you are cloned the repo, you need to specify the repo path in file `cloud-config-server/src/main/resources/application-dev.properties.`

> spring.cloud.config.server.git.uri=file:/path_to_git_repo
#
#

### eureka-naming Server
We register all our microservices to track the health status and provide other service details for communication.
#
#

### oauth2-authentication-server
This will perform the authentication and authorization based on roles assigned to the users.
#
#
### user-service
This will be managing the users across all corporates on the basis of roles.
#
#
### group-service
This will be managing the badges, teams for all corporates.
#
#
### zuul-api-gateway Server
This is public exposed service, all requested routed to different services one based on regex.
#
#

## How to setup locally?
* Dependencies for local setup - Visual Code/Intellij/Eclipse, Maven, JDK8, MySql Database, Docker, Thunderclient/Postman.

* We are using a github repo for managing service config properties files. please clone below repo before running this application locally. 
    - https://github.com/manju07/java-spring-boot-microservice-app-config

* DB Setup - To run MySql locally with docker, please refer this document which is part of this repo `java-spring-boot-microservice-app/dbSetup.md`

* 2 ways to run this application.
    - Docker thru 
        - Get into main directory folder, run the command "mvn clean package". this will build all modules and docker images. then execute `run.sh`. 

    - Spring boot thru
        - Run each service in the below order.
        	- cloud-config-server
		    - eureka-naming-server
		    - oauth2-authentication-server
		    - group-service
		    - user-service
		    - zuul-api-gateway-server
* You can test by checking this swagger - http://localhost:8765/swagger-ui.html


### Important Resources  

- Postman Collections - 
`java-spring-boot-microservice-app/postman-collection_sample-app_postman.json`

- Thunderclient Collections - 
`java-spring-boot-microservice-app/thunder-collection_sample-app.json`

- Swagger Documentation - http://localhost:8765/swagger-ui.html


Author - Manjunath Asundi \
EmailId:manjunathasundi07@gmail.com 