FROM java:8-jdk-alpine
FROM maven:3

RUN mkdir /service;
WORKDIR /service
COPY . /service

RUN mvn clean install -DskipTests=true
RUN ls
#COPY ./target/devops-backend-0.0.1-SNAPSHOT.jar /service

WORKDIR /service

RUN ls

#RUN sh -c 'touch devops-backend-0.0.1-SNAPSHOT.jar'

#ENTRYPOINT ["java","-jar","devops-backend-0.0.1-SNAPSHOT.jar"]
CMD java -jar ./target/devops-backend-0.0.1-SNAPSHOT.jar
EXPOSE 8082:8082