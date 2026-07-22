# Task Management API

A Spring Boot REST API for managing tasks. The project demonstrates CRUD operations, RESTful API design, JPA/Hibernate integration, and MySQL database persistence. Swagger/OpenAPI is used for interactive API documentation.

## Features
- Create a new task
- Retrieve all tasks
- Retrieve a task by ID
- Update an existing task
- Delete a task
- Swagger/OpenAPI documentation

## Tech Stack
- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA
- Hibernate
- MySQL
- Springdoc OpenAPI
- Maven

## API Endpoints
- GET /tasks
- GET /tasks/{id}
- POST /tasks
- PUT /tasks/{id}
- DELETE /tasks/{id}

## Database
The project uses a MySQL database for persistent data storage. Hibernate and Spring Data JPA handle the mapping between Java objects and database tables.

## Swagger UI
http://localhost:8080/swagger-ui/index.html

## How to Run
1. Clone the repository
2. Create a MySQL database
3. Configure MySQL in `application.properties`
4. Run the application
5. Open Swagger UI:
   http://localhost:8080/swagger-ui/index.html

## Author
Amaneh Nasr