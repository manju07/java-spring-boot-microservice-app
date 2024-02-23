
## Document
https://www.appsdeveloperblog.com/how-to-start-mysql-in-docker-container/

## Commands

docker pull mysql/mysql-server:8.0.28

docker run -d -p 3306:3306 --name mysql-docker-container -e MYSQL_ROOT_PASSWORD=sergey -e MYSQL_DATABASE=spring_app_dev -e MYSQL_USER=root -e MYSQL_PASSWORD=root mysql/mysql-server:latest


username: root
password: root