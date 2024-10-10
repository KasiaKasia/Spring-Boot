# Spring-Boot

## The Spring project initialization is available at the link:

https://start.spring.io


##Run the application
1. In order to run the application, you must have the Java Development Kit (JDK) installed. Here is the link to the official Oracle website where you can download the JDK:
https://www.oracle.com/java/technologies/downloads/#java21?er=221886

You also need to add the `%JAVA_HOME` environment variable. The value of the variable is the path to the directory where Java is installed, for example, the default is:
 `C:\Program Files\Java\jdk-21`.

To ensure the change has been applied, open a new command prompt window and type:

`echo %JAVA_HOME%`


2. Load dependencies from `pom.xml` file
3. To run the project in the console, use the command:
`./mvnw spring-boot:run`

4. Next, open a web browser and navigate to the following address: http://localhost:8083
5. The database preview is available at the link: http://localhost:8083/h2-console
6. List of all people is available at the link: http://localhost:8083/persons

