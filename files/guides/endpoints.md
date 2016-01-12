# Creating endpoints

The endpoint for campus services has been documented pretty well so if there is any confusion you can reference that.

## Spring overview

In this app we are using Spring to create our REST services that interface with the database. Spring does a good job at organizing services through annotations.

## Endpoint creation

An endpoint should be associated with a particular part of our application.
Create a Dao for the endpoint, this handles the sql transactions and mappers.
Create a service for the endpoint, this will use the dao to carry out queries.
Create a controller for the endpoint, this handles the incoming variables and uses them to call service methods.
