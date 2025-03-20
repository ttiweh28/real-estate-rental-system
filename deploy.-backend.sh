#!/bin/bash

# Read version from VERSION file
VERSION=$(cat VERSION)
LOG_DIR="./logs"

echo "==== Creating Logs Directory ===="
mkdir -p $LOG_DIR

echo "==== Starting Docker Containers ===="
docker-compose down
docker-compose up -d

echo "==== Deployment Completed ===="
echo "View logs using: docker-compose logs -f"
