
FROM maven:3 as builder

RUN mkdir /service;
WORKDIR /service
COPY . /service

RUN mvn clean install -DskipTests=true
RUN ls
#COPY ./target/devops-backend-0.0.1-SNAPSHOT.jar /service

WORKDIR /service

RUN pwd

RUN ls

FROM java:8-jdk-alpine

COPY --from=builder /service/target/devops-backend-0.0.1-SNAPSHOT.jar .

#RUN sh -c 'touch devops-backend-0.0.1-SNAPSHOT.jar'

#ENTRYPOINT ["java","-jar","devops-backend-0.0.1-SNAPSHOT.jar"]
CMD java -jar devops-backend-0.0.1-SNAPSHOT.jar
