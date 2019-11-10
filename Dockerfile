FROM node:9.6.1
ENV NPM_CONFIG_LOGLEVEL warn
FROM maven:3
RUN npm --version
RUN pwd
RUN ls

RUN cd Frontend
RUN npm install
COPY build/. /
RUN npm install -g serve@5.2.4

CMD serve -s -p8081
EXPOSE 8081
