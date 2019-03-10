#!/bin/bash
#shutting down AccountTransaction
curl -X POST http://13.229.126.238:8585/shutdown

#shutting down user-service
curl -X POST http://13.229.126.238:9999/shutdown

#latest jars are here
cd /var/lib/jenkins/jar

#starting service user-service
java -jar user-service-0.0.1-SNAPSHOT.jar
#starting service AccountTransaction
java -jar AccountTransaction-service-0.0.1-SNAPSHOT.jar

