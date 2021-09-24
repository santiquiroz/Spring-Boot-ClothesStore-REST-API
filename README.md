# Spring-Boot-ClothesStore-REST-API
A basic Java Rest Api using TDD.

## Try it
- An implementation of this API can be access via the following base URL:
[api.suruworks.com](https://api.suruworks.com/)
- The API endpoints documentation is on the ENDPOINTSDOC.txt file.

## Prerequisites
* JDK 11
* MariaDB 
* [Maven 3.8.1](https://downloads.apache.org/maven/maven-3/3.8.1/binaries/)
## Installation

### Setting the DataBase
1) Create a MariaDB dataBase.
2) run the structure sql file located on /DataBase/SQL/ .
3) run the database triggers sql file.
4) run the inicial data sql file to set the required bussiness rules. 

### Setting the reverse proxy
This project was deployed in a windows server using IIS Reverse proxy to redirect all the HTTPS internet traffic to our HTTP localhost running application, there is a guide to configure that reverse proxy on the Manuals folder.. but you are free to use the network's architecture that you prefer.

### Setting the Spring-Boot project
To properly run the spring boot project you need to set the application.properties file location on /restapi/src/main/resources/ with the following parameters:
* server.port: the localhost port that the application will use.
* spring.datasource.url: your mariadb database url connection.
* spring.datasource.username: The MariaDB database user.
* spring.datasource.password: The MariaDb database user's password.
* spring.datasource.driver-class-name: The MariaDB driver used by the application.

## Optional dummy data
If you want to populate the database to test some features follow this steps:
1) run the testPopulation sql file on your database.
2) copy the images folder located on /Database into /restapi/src/main/resources/static