#!/bin/bash

ROOT_PATH=$(dirname "$0")

#echo "$date() swarm mode Тохируулах"
#docker swarm init
#
#echo "$date() swarm token join"
#docker swarm join-token manager
#docker swarm join --token SWMTKN-1-0ye1e6tfqgby2aoa0gc329ob7gqkkjr4kn9e3tag7fsn1z0snt-9mcbr3mfn0xbt6cmzdqiw3mgr 192.168.65.3:2377
#
#echo "$date() swarm join"
#docker swarm join
#
#echo "$date() swarm stack deploy"
#docker stack deploy

echo "$(date) Эластик процесс асаах "
docker-compose -f "docker-compose-elk.yml" up --build