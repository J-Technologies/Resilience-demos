#! /usr/bin/env bash

cd ..
mvn clean package
cd -
cp ../target/hystrixdemo.war .
docker build -t ordina/hystrix .