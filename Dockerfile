FROM maven:3.8.4-jdk-11-slim
MAINTAINER andresapao
WORKDIR /transactions
COPY . .
RUN mvn clean install
CMD mvn spring-boot:run
