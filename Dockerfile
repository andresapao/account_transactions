FROM maven:3.8.4-jdk-11-slim
MAINTAINER andresapao

WORKDIR /transactions
COPY . .

RUN apt-get -q update && apt-get -qy install netcat wget
RUN wget https://raw.githubusercontent.com/eficode/wait-for/v2.2.3/wait-for 

RUN chmod +x wait-for
RUN chmod +x start.sh