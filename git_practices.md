# Git practices

There are a lot more things that can be done with git, but I will explain
how to use git for the scope of this project. These practices will be useful
in other situations, but this will not be an intensive covering of how to use
git to its maximum capabilities.

## A brief overview of how to use git
In order to avoid conflicts with work, it is best to create a new branch
for whatever you are creating and keep it separate from the master branch
until you are confident that it works and can merge it back in. This is
especially good practice if we decide to scrap ideas. We won't have to go
through the pain of removing dead code from our master branch because it
will never be there in the first place.

## How can we use git effectively?
Git gives us a great way to manage different versions of the project we are working on. You can do this by branching.
If you create a new branch, git will replicate the branch you are working on so you can make changes to it and then merge the changes back into the original branch.

In practice it looks like this:
You have the master branch up-to-date and you want to create a new page and services.
You will create a new branch, name it appropriately, and start using that branch
to implement your pages, etc.
During the time that you are working on this branch, it is important that you keep the master branch up to date and merge the master branch into the branch that you're working on so that there aren't merge conflicts when you merge the new branch back into master.
When you are confident that your work is done, you will merge your branch with the new code back into the master branch and then push the changes to the master branch in git.
Generally with commit messages, you will tag what task you were working on and add a snippet about what has changed.

Example situation:
You have been asked to add a page to the website. This page is for displaying information about departments in the site.
You are working on the front end of this part of the application and your friend is working on the back end services.

First create a new branch by using this command:
git branch [branch name]
so in this case it will be:
git branch department

You can verify what branch you are on by typing this command:
git branch

You will get a response that looks like this:
department
\* master
This is a list of branches you have locally, and the asterisk is next to the branch you have currently checked out.

You do not want to do work on the master branch, so in order to switch to the department branch you use this command:
git checkout [branch name]
in this case it will be:
git checkout department

You will see a confirmation message like:
Switched to branch 'department'

Now that you have checked out the new branch, you can feel free to make changes and implement your task without worrying about how it will affect the master branch.

It is important to keep your branch and the master branch up to date. You should occasionally pull into the master branch by saying:
git pull master origin

It should be safe to pull from origin into master since you should never have merge conflicts.
This is because you will always be working on a separate branch and there will be no changes to your master branch until you decide you want to push your changes.

If it turns out that the master branch has been updated, you must merge it into the branch you are working on. This means you must switch branches to the one that you are working on and use this command:

git merge [branch name]
in this case it will be:
git merge master

Using git merge [branch name] on a branch will merge the named branch into the branch that you currently have checked out.

Merge conflicts can occur when you merge master into your branch.
Ideally they would not occur because people should not be working on the same pieces of code simultaneously.
If it does occur it is up to you to handle fixing the merge conflicts and verifying that the application still performs properly after changing the files.
We should have automated tests set up that will test the functionality of the site.
If those fail, then that means that something broke during the merge and you have to fix it.

Now if you have finished working on your branch, master is up to date and has been successfully merged into your branch, you are passing all of the tests and it appears that everything is functioning properly, it is time for you to merge your code into the master branch, commit it and then push it to the origin.

First you will check out the master branch by using:
git checkout master
Then you will merge your branch into the master by using:
git merge [branch name]
Then you will add your changes to the git index, so it will know that things have changed. The really lazy way to do this is simply:
git add .
This adds the current directory to the git index and it will notice the changes that happened to the current directory.
Now you will commit the new code by using:
git commit -m "[Your message here]"
Surround a brief description of the commit with quotes to add a message to your commit.
Finally, you will push the new version of master to origin.
git push origin master

And you're done! You have implemented your own piece of the project and successfully pushed it to our repo.

This should be enough to get you started.
There is a lot more that git can do, but for the purposes of this project, this should be more than enough.
