FROM openjdk:11-jre-slim-buster
MAINTAINER andresapao
COPY target/transactions-0.0.1-SNAPSHOT.jar transactions-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/transactions-0.0.1-SNAPSHOT.jar"]