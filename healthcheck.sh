#!/bin/bash
set -eo pipefail

host="$(hostname --ip-address || echo '127.0.0.1')"

if health="$(curl -fsSL "http://$ELASTIC_USERNAME:$ELASTIC_PASSWORD@$host:${ELK_PORT}/_cat/health?h=status")"; then

	health="$(echo "$health" | sed -r 's/^[[:space:]]+|[[:space:]]+$//g')"
	if [ "$health" = 'green' ] || [ "$health" = "yellow" ]; then
		exit 0
	fi
	echo >&2 "health status алдаа: $health"
fi

exit 1