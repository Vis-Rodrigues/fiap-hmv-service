#!/bin/bash
cd /home/ec2-user/fiap-hmv-service
docker build --tag=visdocker10/hmv-service:latest --rm=true .
docker push visdocker10/hmv-service
docker stop hmv-service
docker rm hmv-service
docker run --name hmv-service -p 8080:8080 visdocker10/hmv-service:latest
