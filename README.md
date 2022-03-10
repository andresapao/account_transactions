# account_transactions

## WHAT IS

An application which allows to create account and transactions related to it.

## STACK

Java 11, SpringBoot, Maven, Mysql, docker

## BUILD AND PACKAGE

- Maven, Java and Mysql will be at docker containers
- Run "docker-compose up --build" at root directory to build containers once
  - MySql will be available at localhost:3307
  - Application will always create and drop database
- There will be two endpoints available at localhost:8999 ("accounts" and "transacations")
- To shutdown, press CTRL-C and type "docker-compose down"

## TESTS

There are two types of tests in application.

- Integration tests: creates a container database and uses REST to manipulate data. Used for the sucessful scenarios
- Service tests: uses mock to test behavior. It is cheaper and used for scenarios of fail
