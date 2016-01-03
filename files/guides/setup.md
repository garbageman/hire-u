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

TODO: Fill this out when we get the back end set up
