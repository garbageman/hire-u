# Creating endpoints
# Flesh this out when finished with model
## TODO: Reorganize endpoint packaging

An endpoint should be associated with a particular part of our application.
Create a Dao for the endpoint, this handles the sql transactions and mappers.
Create a service for the endpoint, this will use the dao to carry out queries.
Create a controller for the endpoint, this handles the incoming variables and uses them to call service methods.
