#! /bin/bash
echo "Removing classes directory..."
rm -r ./classes
echo "Creating classes directory..."
mkdir classes
echo "Compiling code..."
javac ./java/PostGresSetup.java -cp "./java/postgresql-9.0-801.jdbc3.jar" -d "./classes"
echo "Running Postgres Initialization"
java -classpath ./classes:./java/postgresql-9.0-801.jdbc3.jar PostGresSetup
