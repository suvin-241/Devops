FROM java:8-jdk-alpine
FROM maven:3

RUN mvn clean install
RUN ls
COPY ./target/devops-backend-0.0.1-SNAPSHOT.jar /usr/app/

WORKDIR /usr/app

RUN sh -c 'touch devops-backend-0.0.1-SNAPSHOT.jar'

ENTRYPOINT ["java","-jar","devops-backend-0.0.1-SNAPSHOT.jar"]