# App Guide


## Important Notes
* Please make sure that the Backend server endpoint is updated under `src/app/app.constants.ts`.
* Please make sure that the Backend application properties are updated under `src/main/resources/application.properties`.
Namely, the database url, username & password. Note that the current database configuration is a local MySQL connection. Please make sure to update the dialect if necessary.
* Note that a default SQLite connection configuration is commented in the `application.properties`. Please update if necessary.
* Please also note that CORS have been disabled, Backend server should accept requests from any Origin.


## Local Backend --> `cpn-api`
This is a Spring-boot application powered by Maven.
### Installing 
* Under the main directory, run `mvn clean install` or `mvnw clean install` for the maven wrapper.
### Running
* `mvn spring-boot:run` or `mvnw spring-boot:run` for the maven wrapper.

## Local Frontend --> `cpn-web/cpn`
This is a simple Angular application.
### Installing 
* Under the main directory, run `npm i`.
### Running
* `npm start` or `npm start --port {portNumber}` for a custom port.
