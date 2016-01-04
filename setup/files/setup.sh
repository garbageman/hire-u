#! /bin/bash
javac PostGresSetup.java -cp "./postgresql-9.0-801.jdbc3.jar"
java -classpath .:./postgresql-9.0-801.jdbc3.jar PostGresSetup
