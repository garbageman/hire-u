# Cloning the git repository
In the directory that you want to keep these files, run this command:

### git clone https://github.com/garbageman/hire-u

This will create a file hire-u that will contain all of the files in the repository

# Running the site

If you have not yet set up the site by following the set up directions below, skip this part and read those directions first.

When you're running the site to check if things work, make sure you start up the backend services first, then run:

### grunt build

Make sure that the app builds successfully then run:

### grunt serve

This will run a copy of the site locally and open it in a browser window.

# Setting up the site

When you pull the project from the repo, none of the dependencies are installed on your machine.
This will be a quick guide to help you set up the site so you can begin development.

## Back end installation

The REST services of the site are built using java, maven and a spring framework.
The services are running on Java 8. So make sure that you have Java 8 installed.
Make sure you have maven installed on your computer, you can check your maven version by using this command:

### mvn -v

This should tell you what version of maven you have (hopefully 3) and it will tell you what version of java maven is using (Java 1.8)

Maven uses the pom.xml to find out what plugins and dependencies we are using for our project. In order to install these dependencies we must build the project.

If we run this command:

### mvn compile

Then maven will compile our code into a target folder that we can use to deploy package and deploy our services. This will additionally download any dependencies that we may need to ensure the code compiles successfully. Maven will handle all of this for us because we put the dependencies in the pom.xml file.

Once we have compiled our code, we can now run our spring REST services.
You can run the REST services by using the command:

### mvn spring-boot:run

This will create a war file and deploy it on a local tomcat server that you will be able to access. The default location of this server is:

localhost:8080


## Front end installation

You should have Node and NPM installed before you begin trying to run the site.
You also will need grunt installed so run:

### npm install -g grunt-cli

In the main directory of the site, run the command:

### npm install

This will install all of the dependencies that have been listed in the package.json file

After running npm install run this command:

### bower install

This will set up grunt and other components you will need for development.

Now it is time to veryify that everything is set up properly.
Run the command:

### grunt build

This will look at the application and find errors in it that you have to fix before you can run the site properly. A freshly pulled copy of the site should NEVER fail the grunt build

After running grunt build, run the following command:

### grunt serve

This will actually start the webapp and you will be able to see what the site looks like. It should automatically open the main page in your default web browser.

## Back end set up

The local database that is used is Postgres. Install Postgres on your machine before continuing. Setting up the database and populating it has been fully automated but it would be a good idea to look at the source code to see how it is done.

Start up postgres and enter the command line interface. This can usually be done with this command:

### psql -p 5432

Make sure that psql is in your path before trying that command.

Now that you are connected to the database it is time to set up the actual database on the local instance and user that the site will be using to connect.

Start by creating a hireu database with this command:

### create database hireu;

Then create a user hireu with the following command:

### create user hireu;

Give hireu a password (we will simply use "dev" for now) with this command:

### alter user hireu with password 'dev';

Then finally grant permissions to hireu on the hireu database with this command:

### grant all privileges on database hireu to hireu

Now that this is set up, navigate to setup. There is a bash script (setup.sh) that can be run on a unix system that will connect to the database and setup the tables.
To run the script just type:

### ./setup.sh

If the permission is denied, just run:

### chmod u+x setup.sh

This will compile and execute the java programs used to set up the tables in the database.
