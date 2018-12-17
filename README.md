# backend-task
Please create an HTTP based PersonService to create, update, delete, and query Person data with JSON request / responses.

## Project Setup
1. Create a [fork](https://help.github.com/articles/fork-a-repo/) of the [Softtech Training Service](https://github.com/softtechconsulting/backend-task) in your Github account
1. Clone the new repo to your development environment 
`> git clone git@github.com:YOUR_ACCOUNT/backend-task.git`
1. View available tasks with `./gradlew tasks` or `gradlew.bat tasks`

### Eclipse Setup
1. Install gradle dependencies and source using gradle wrapper `> cd backend-task; ./gradlew eclipse`
1. Import the project `File > Import > General > Existing Projects into Workspace`

### Task
Update the `PersonService` to correctly persist and retrieve `Person` data from the in-memory database using [Spring Data](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#dependencies.spring-boot) and [Springboot Starter JPA](https://spring.io/guides/gs/accessing-data-jpa/).
A `PersonService` stub and `PersonServiceIntTest` have been created with failing tests that should be expanded to fully test the completed `PersonService`.

Add any aditional test / classes you want to verify the functionality of the `create`, `update`, `delete`, `findById`, `findAll` methods. Feel free to make changes to the project or model in anyway you see fit.

### Debugging Service Code
* You can run the java tests directly in Eclipse with the debugger `Select PersonServiceIntTest > Run as Junit`
* You can run the entire app in debug mode by selecting the `ServiceApplication` class and `Debug as Java Application`

### Common Gradle Tasks
* Run the app locally with `>./gradlew bootRun`
* Run tests locally with `>./gradlew test`
* View test coverage with `>./gradlew test jacocoTestReport; open ./build/reports/coverage/index.html`
* Test running api with swagger: 
  1. start the service `>./gradlew bootRun`
  1. navigate to http://localhost:8080/swagger-ui.html#/person-service
  1. Use the swagger UI to find and test methods, verify responses, etc
