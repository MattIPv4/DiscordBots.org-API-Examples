#!/bin/bash

# EDIT THESE
USERID="DISCORDBOTID"
TOKEN="DBLAPIKEY"
GUILDCOUNT=10

curl "https://discordbots.org/api/bots/${USERID}/stats" \
    -i -v \
    -X POST \
    -H "Content-Type: application/json" \
    -H "Authorization: ${TOKEN}" \
    -d '{ "server_count": ${GUILDCOUNT} }'
    
# -i and -v are optional
