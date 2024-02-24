## MySql on Docker

### Commands

docker pull mysql/mysql-server:latest

docker run -d -p 3306:3306 --name mysql-docker-container -e MYSQL_ROOT_PASSWORD=sergey -e MYSQL_DATABASE=spring_app_dev -e MYSQL_USER=root -e MYSQL_PASSWORD=root mysql/mysql-server:latest

### DB Details
username: root
password: root
port: 3306
host: localhost

### Resources
https://www.appsdeveloperblog.com/how-to-start-mysql-in-docker-container/