# OttoDock

##How to start the OttoDock application


1. Run `mvn clean install` to build your application
1. Start application with `java -jar target/coreWebApp-1.0-SNAPSHOT.jar server config.yml`
1. To check that your application is running enter url `http://localhost:8080`

##Health Check

To see your applications health enter url `http://localhost:8081/healthcheck`


##Static Resources 

being served from / are found in src/main/resources/assets
index.html is default page

##REST api's

mapped to /api


##OttoDock DB setup

Postgresql 

CREATE ROLE ottodock WITH LOGIN PASSWORD ‘ottodock';
ALTER ROLE ottodock CREATEDB; 

— Dont think need this — CREATE DATABASE dockdb WITH OWNER ottodock;
GRANT ALL PRIVILEGES ON database dockdb to ottodock;

from psql

SET search_path TO ottodock,public;


###See if Postgresql is Running

ps auxwww | grep postgres

**User and Password**

set for application in config.yml

and in pom.xml (for flyway migrations)

###Initialize / wipe clean the DB
mvn flyway:clean

###Update DB to latest schema
mvn flyway:migrate

###DB Migrations files location
src/main/resources/db/migration


