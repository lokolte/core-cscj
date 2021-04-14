#!/bin/bash

echo "Downloading dependencies..."

sudo mvn clean package spring-boot:repackage

echo "###########################################################################################################"
echo "############################################## DONE DOWNLOAD ##############################################"
echo "###########################################################################################################"

echo "Deleting docker image if there exist..."
sudo docker rmi -f core-cscj_cscj.core

echo "Cleaning system..."
sudo docker system prune -f

echo "Starting to build docker image..."
sudo docker-compose build

echo "Starting jar in docker image..."
sudo docker run -d --restart=always --network="host" -v /core/cscj:/core/cscj core-cscj_cscj.core