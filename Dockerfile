FROM node:9.6.1
ENV NPM_CONFIG_LOGLEVEL warn
FROM maven:3
RUN apt-get update && apt-get install -y curl
RUN curl -sL https://deb.nodesource.com/setup_8.x | bash -
RUN apt-get update && apt-get install -y nodejs
RUN npm --version
RUN pwd
RUN ls

RUN mkdir /app;
WORKDIR /app

RUN ls

RUN cd Frontend/my-app
RUN ls
RUN npm install
COPY build/. /
RUN npm install -g serve@5.2.4

CMD serve -s -p8081
EXPOSE 8081
