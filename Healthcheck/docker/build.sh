#!/bin/bash

docker rm -f monitor
docker rm -f haproxy
docker rm -f apache1
docker rm -f apache2

# build and run 2 apache containers
docker build -t ordina/apache ./apache
docker run -d -it -p 172.17.42.1:10080:80 -p 84:80 --name apache1 ordina/apache
docker run -d -it -p 172.17.42.1:20080:80 -p 85:80 --name apache2 ordina/apache

# build and run haproxy container
docker build -t ordina/haproxy ./haproxy
docker run -d -it -p 80:80 -p 81:81 --name haproxy ordina/haproxy

# build and run wildfly container
docker build -t ordina/monitor ./monitor
docker run -d -it -p 1287:8787 -p 1290:9990 -p 172.17.42.1:38080:8080 -p 1288:8080 --name monitor --link haproxy:haproxy ordina/monitor