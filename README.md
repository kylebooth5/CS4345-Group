# SMU TA System

*Project By Kyle Booth, Kate Bouis, JP Heck, and Eric Houtman*

### Introduction
This repo is for a software development project created using the Play framework. The project is for a TA Application system, which is a website that both TAs and professors at a university can register for. Professor accounts have permissions to create TA job openings and hire TAs that fit their requirements. TA accounts see these postings and apply to jobs that fit their schedule and experience. 

### Purpose
This project has two purposes. The first is to learn how to properly go through the software engineering process, from documentation from implementation. This project is for CS 4345 at SMU, which is Software Engineering Principles, and is therefore designed to teach proper software engineering methods.

The second purpose is to bring TAs and professors at SMU together to efficacize and decentralize the hiring process. This application has the potential for real world deployment on the university scale, and the implementation of this application into the SMU system would be useful to staff and TAs alike.

### Running the Program
We used the Play framework to create this project, so make sure to have that installed. We are mainly working on IntelliJ but other software could work as well. Create a Docker container for this project to run in and then download SBT for your computer. Inside of IntelliJ, you can then install the downloaded SBT as a plugin. Install Scala as another plugin within IntelliJ, and then go ahead and open the project.

In the backend folder, open build.sbt and wait for the indexing processes to finish running and syncing. Apply Play to the project and then customize your run/debug configurations. Then connect to your MySQL database, using the same user and password you set earlier, the same port that your MySQL is running on (typically port 3306), and any name for the database that you want. Then, create a new schema for the backend and click execute. To run the backend, click the triangle 'run' button in IntelliJ.

Then, open the frontend folder and allow it to sync. Set up all of your run/debug configurations and run it by pushing the same triangle button. When you click this, it should pull up the website in your browser.
