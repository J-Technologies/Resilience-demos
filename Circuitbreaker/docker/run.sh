#! /usr/bin/env bash

CONTAINER=ordina/hystrix
APP=hystrix
DASHBOARD=hystrix-dashboard

docker rm -f $APP 2> /dev/null
docker rm -f $DASHBOARD 2> /dev/null

docker run -d -p 20000:8080 -v $(pwd)/application.properties:/application.properties --name $APP $CONTAINER
docker run -d -p 20001:8080 --name $DASHBOARD --link $APP:app $DASHBOARD
