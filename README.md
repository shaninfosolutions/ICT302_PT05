Web
Install Note Js
===================
https://nodejs.org/en/download

Import the Angular Web Project
=================================
#to install the npm package and its dependency
>npm install 

Build the Package
===================
>ng build  #the package shall be in the ./dist/ folder 

Set up the Http Apache Web
===============================
Install and Configure Apache:
If you haven't already installed Apache on your Windows machine, you can download it from the Apache Lounge website (https://www.apachelounge.com/download/). Follow the installation instructions provided there.

Once Apache is installed, navigate to the Apache installation directory (usually C:\Apache24\conf) and open the httpd.conf file in a text editor.

Find the DocumentRoot directive and change it to point to the dist directory of your Angular project:

DocumentRoot "C:/path/to/your/angular/project/dist"  ##update the correct folder path

Check the ServerRoot Directive:
Open your httpd.conf file and locate the ServerRoot directive. It should look like this:
ServerRoot "C:/Apache24"  ## updat the correct folder path

Additionally, ensure that the Directory directive for the DocumentRoot allows access to the directory:
<Directory "C:/path/to/your/angular/project/dist"> ## update the correct folder path
    Options Indexes FollowSymLinks
    AllowOverride All
    Require all granted
</Directory>

Start Apache:
======================
Start Apache from the command prompt by running:
> httpd.exe -k start

--------------------------------------------------
Application
Env Setup
=====================================================
Install the Java 17, Set the Java PATH in Windows Environment
Install Apache Maven 3.8.8 

IDE
======================================================
Eclipse, Intellij, Spring tools and Visual Studio Code

Build and Install
=====================================================
> mvn clean install

Start up the Service
=====================================================
> cd /target
> java - jar pt05.drenchmate-0.0.1-SNAPSHOT.jar


