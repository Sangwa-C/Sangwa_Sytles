# Sangwa_Sytles

## *By Sangwa Sabine Chelsea*

## Description

This is an app that the users to display notices, identify department and add user in the department all those are added into the database to the database, 


# Install

## Pre-requisites

  1. Ensure you have Java installed 
     (A simple way to install Java is using sdkman.)
     
     sdk install java
  
  2.Gradle
    Gradle is used as the build tool and can be installed with sdkman:
  
    sdk install gradle
  
  3.Postgres.
  (Enter y when prompted “Do you want to continue? [Y/n]” and wait for the installation to complete. 0r <a href="https://www.postgresql.org/docs/9.3/contrib.html">try this link</a>)
  
    sudo apt-get install postgresql postgresql-contrib libpq-dev
  
  
## Installation guide   
**{follow the below instructions for set up.}**
    
   1. You will need Internet connection.

   2. You need to get into the Rest_api Repository.
    
     Link:-> https://github.com/Sangwa-C/Rest_api.git
        
   3. From there you can access the Rest_api project.
    
   4. Clone the project.
    
   5. get into project folder (cd into project).

   6. If you have all the Pre-requisites you can run the application.
    
     gradle run


## Manual Database Creation
To create the necessary databases, launch postgres, then psql, and run the following commands:

* CREATE DATABASE rest_api;
  \c rest_api;
  
* CREATE TABLE userer(id SERIAL PRIMARY KEY,name VARCHAR,title VARCHAR,duty VARCHAR,dname VARCHAR);
  
* CREATE TABLE news(id SERIAL PRIMARY KEY, header VARCHAR, content VARCHAR,author VARCHAR);
  
* CREATE TABLE department(id SERIAL PRIMARY KEY,dname VARCHAR,ddescription VARCHAR,nemployees VARCHAR);
 

## BDD

**The program should allow the user to add Department**

    Input Example: "Department's name: Human Resources"
                   "Department's Cause: Recruitment"
                   "Number of Employees: 45"
                   
**The program should return when the user adds the department the database** 

    Output Example: "Department's name: Human Resources"
                    "Department's Cause: Recruitment"
                    "Number of Employees: 45"
 
**The program should allow the user to publish news**
 
         Input Example: News Header: Meeting
                        Information: board meeting in Sangwa Hall at 9:00h
                        Said by: Chelsea
 
**The program should allow the user to publish news**

          Output Example: News Header: Meeting
                        Information: board meeting in Sangwa Hall at 9:00h
                        Said by: Chelsea

**The program should allow the user to register**    
           
           Input Example:User Name: Sangwa
                         User Title: manager
                         User's Duty: managing
                         User's Department: Operations management
                          
    
## Known Bugs

<p>
<g-emoji class="q-emoji"  alias="bug" >
    <img class="emoji" alt="bug" height="20" width="20"  src="https://github.githubassets.com/images/icons/emoji/unicode/1f41e.png">
 </g-emoji>This webpage is not suitable for all screen sizes and it might load slowly if your internet is low.
</p>


<p>
<g-emoji class="q-emoji"  alias="bug" >
    <img class="emoji" alt="bug" height="20" width="20"  src="https://github.githubassets.com/images/icons/emoji/unicode/1f41e.png"  >
 </g-emoji>   Can submit empty or invalid characters in adding department.
</p> 

 <p>    
<g-emoji class="q-emoji"  alias="bug" >
    <img class="emoji" alt="bug" height="20" width="20"  src="https://github.githubassets.com/images/icons/emoji/unicode/1f41e.png">
 </g-emoji> Can submit empty or invalid characters in an adding a notice.
</p>


<p>
<g-emoji class="q-emoji"  alias="bug" >
    <img class="emoji" alt="bug" height="20" width="20"  src="https://github.githubassets.com/images/icons/emoji/unicode/1f41e.png">
 </g-emoji> User can submit empty or invalid characters when registering a user.
</p>


<p>
<g-emoji class="q-emoji"  alias="bug" >
    <img class="emoji" alt="bug" height="20" width="20"  src="https://github.githubassets.com/images/icons/emoji/unicode/1f41e.png">
 </g-emoji> User can not delete entry.
</p>

<p>
<g-emoji class="q-emoji"  alias="bug" >
    <img class="emoji" alt="bug" height="20" width="20"  src="https://github.githubassets.com/images/icons/emoji/unicode/1f41e.png">
 </g-emoji> User can not update entry.
</p>


<p>
<g-emoji class="q-emoji"  alias="bug" >
    <img class="emoji" alt="bug" height="20" width="20"  src="https://github.githubassets.com/images/icons/emoji/unicode/1f41e.png">
 </g-emoji> Recording dates aren't recorded.
</p>


## Technologies Used

* JAVA
* Gradle
* Spark
* HTML
* CSS & Bootstrap
* PostgreSQL
* Junit
* Heroku
 
## Support and contact details
If you any issues or have questions, ideas or concerns contact us on chelseasabinesangwa@gmail.com.

### License
MIT Copyright (c) 2019 Sangwa Sabine Chelsea. # Wildlife-Tracker
