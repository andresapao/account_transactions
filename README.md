# account_transactions

## WHAT IS

An application which allows to create account and transactions related to it.

## STACK

Java 11, SpringBoot, Maven, Mysql, docker, docker-compose

## BUILD AND PACKAGE

- Run "mvn clean package"
- Run docker-compose up 
  - MySql will be available at localhost:3307
  - Application will always create and drop database
- There will be two endpoints available at localhost:8999 ("accounts" and "transacations")

## TESTS

There are two types of tests in application.

- Integration tests: creates a container database and uses REST to manipulate data. Used for the sucessful scenarios
- Service tests: uses mock to test behavior. It is cheaper and used for scenarios of fail
