# README #
## Author - Manjunath Asundi 
### Sample Microservice architecture application using spring boot and spring cloud  

### services available 
* cloud-config-server -  This is centralized based config server. this will provide config files for all services for different environments. cloud-config-server will fetch config files from the github repository. link for github repository - https://github.com/manju07/java-spring-boot-microservice-app-config
* eureka-naming Server - Here we register all the services of the application. 
* zuul-api-gateway Server - It will stand in front of the application. this will handle all the requests and distribute them to the other services via routes.
* oauth2-authentication-server - This will authentication and authorize the requests then forward the requests to the original route.  
* user-sevice - All the user based APIs are written in this service.
* Group-Service - All Group api's are there. 

### set up in the local system
* Summary of set up
* Dependencies - Visual Code, Maven, JDK8, MySql Database, Docker, Postman 
* Database configuration -  While installing database set username and password to root in the local system.

### How to run ? 
* In the main directory folder, run command "mvn clean package". this will build all docker images for all the services and then run a file called run.sh which exists in the main folder. 
* This will start all services. now go to URL http://localhost:8765/swagger-ui.html, you will find swagger documentation.