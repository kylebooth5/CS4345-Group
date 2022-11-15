#!/bin/bash

docker start CS4345

cd backend
./run.sh
cd ..
cd client
./run.sh
cd ..

