# Capitole 
Implementation based on "TestSqlDao (3).java"

## What have I done?
- Rename some methods to make it clearer what they do. 
- Set up a framework to delegate the database connection and SQL execution.
- Modify SQL statements to adapt them to what they must do.
- Implement some test to verify functionality.
- Create REST API to interact with the application (CRUD)
- Generate documention of the REST API. 

## What have I used?
Springboot, MyBatis, Swagger, Junit, Java11, H2 database

## Execution
Download code and execute
```
mvn clean install
mvn spring-boot:run 
```
### REST API Documentation
http://localhost:8090/swagger-ui/index.htm

## Others
UTC as timezone.

The H2 database is created for each run of this exercise (in the real world that wouldn't happen)

The use of "advice" has not been implemented. I have never worked with them, I am reading about them and I hope I can implement them correctly in the future.
