#!/bin/bash

ROOT_PATH=$(dirname "$0")

echo "$(date) Эластик процесс асаах "
sudo docker-compose -f "docker-compose-elk.yml" up --build

#  --cpu-rt-runtime=950000 --ulimiy rtptio=99 --cap-add=sys_nice --memory="300m" --emory-swap="1g"