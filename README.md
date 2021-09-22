# Spring-Boot-ClothesStore-REST-API
A basic Java Rest Api using TDD.

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


## Optional dummy data
If you want to populate the database to test some features follow this steps:
1) run the testPopulation sql file on your database.
2) copy the images folder located on /Database into /restapi/src/main/resources/static