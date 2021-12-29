#!/bin/bash

ROOT_PATH=$(dirname "$0")

echo "$(date) build"
sudo docker-compose build

echo "$(date) Лог трак асаж байна. "
sudo docker-compose up


#docker system prune
