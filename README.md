# Example of Graphql - Spring Webflux - Oracle Reactive
Example of Graphql, Spring Webflux, Oracle React Connector

## Requirements

For building and running the application you need:

- [JDK 11](brew install openjdk@11)
- Oracle R2BC Driver
- Spring Webflux

## Running the application locally

There are several ways to run a Spring Boot application on your local machine.
One way is to execute the `main` method in the `com.example.springwebflux.graphql.SpringWebfluxOracleReact` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
# Configure Database in  ur Local Oracle
Step 1: Have a Oracle Schema with Table Name Appliation.
        The Table Contains Columns ( Id as INT(PK), Code as Varchar, Description as Varchar, Name as Varchar)

Step 2: Insert your own Values in the Tables Application.

# Configure Graph QL Queries.
Step 1: application.graphqls is store in resources/graphql folder.
Step 2: We are going to query 3 api's. 
        a. getApplicationById(appId: ID): Application
        b. getApplicationByName(name: String): Application
        c. getAllApplication: [Application]
        

mvn spring-boot:run

 

Clone this project from GIT

# Execution:
Step 1: Open Terminal - mvn clean install

Step 2: Open Terminal - mvn spring-boot:run -Dspring-boot.run.profiles=local

Step 3: Accessing the application with below url. http://localhost:8080/graphql

_Input :  getApplicaitonById:
   query{
    getApplicationById(appId: 1019){
    appId
    name
}
}_

Input : getAllApplication:
query{
    getAllApplication{
    appId
    name
}
}
