FROM node:9.6.1
ENV NPM_CONFIG_LOGLEVEL warn
RUN apt-get update && apt-get install -y curl
RUN curl -sL https://deb.nodesource.com/setup_8.x | bash -
RUN apt-get update && apt-get install -y nodejs
RUN npm --version
RUN pwd 

RUN mkdir /app;
WORKDIR /app
COPY . /app

RUN ls

RUN npm install
RUN npm run-script build

#RUN ls
#COPY build/. /
#RUN npm install -g serve@5.2.4

#CMD serve -s -p8081
CMD npm start
EXPOSE 8081
#CMD [ "npm", "start" ]

