FROM node:carbon
FROM maven:3
RUN node -v

RUN mkdir /app;
WORKDIR /app

COPY . /app
RUN cd Frontend
RUN npm install
