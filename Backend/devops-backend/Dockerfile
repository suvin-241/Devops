FROM java:8-jdk-alpine
FROM maven:3

RUN mkdir /service;
WORKDIR /service
COPY . /service

RUN mvn clean install -DskipTests=true
#COPY ./target/devops-backend-0.0.1-SNAPSHOT.jar /usr/service/

WORKDIR /usr/service

RUN sh -c 'touch devops-backend-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","devops-backend-0.0.1-SNAPSHOT.jar"]