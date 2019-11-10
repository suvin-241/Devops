FROM node:carbon
FROM maven:3
RUN apt-get install nodejs
RUN node -v

RUN mkdir /app;
WORKDIR /app

COPY . /app
RUN cd Frontend
RUN npm install
