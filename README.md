# Task Management API

A RESTful Task Management API built with **Java 17 and Spring Boot 3**.

The application allows users to create, manage, update, delete, and filter tasks. Task data is stored persistently in a **MySQL/MariaDB database** using Spring Data JPA and Hibernate.

## Features

* Create, read, update, and delete tasks
* Task priorities: `LOW`, `MEDIUM`, `HIGH`
* Due dates
* Filter tasks by priority
* Automatic priority suggestion through `AIService`
* MySQL/MariaDB database persistence
* Exception handling
* Swagger/OpenAPI documentation
* Layered Controller–Service–Repository architecture

## Technologies

* Java 17
* Spring Boot 3
* Spring Web
* Spring Data JPA
* Hibernate
* MySQL / MariaDB
* Maven
* Lombok
* Swagger / OpenAPI

## API Endpoints

| Method | Endpoint               | Description        |
| ------ | ---------------------- | ------------------ |
| GET    | `/tasks`               | Get all tasks      |
| GET    | `/tasks/{id}`          | Get a task by ID   |
| POST   | `/tasks`               | Create a task      |
| PUT    | `/tasks/{id}`          | Update a task      |
| DELETE | `/tasks/{id}`          | Delete a task      |
| GET    | `/tasks?priority=HIGH` | Filter by priority |

## Architecture

The project follows a layered architecture:

```text
Client / Postman
       │
       ▼
TaskController
       │
       ▼
TaskService
       │
       ├──► AIService
       │
       ▼
TaskRepository
       │
       ▼
MySQL / MariaDB
```

* **Controller** – handles HTTP requests
* **Service** – contains business logic
* **AIService** – suggests task priority when none is provided
* **Repository** – handles database access

## Swagger UI

After starting the application, Swagger UI is available at:

```text
http://localhost:8080/swagger-ui/index.html
```

Swagger can be used to view and test the REST API directly in the browser.

## How to Run

### 1. Clone the repository

```bash
git clone https://github.com/Amaneh-Nasr/spring-boot-task-management-api.git
```

### 2. Configure the database

Create a MySQL/MariaDB database and configure the connection in:

```text
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/taskdb
spring.datasource.username=root
spring.datasource.password=YOUR_PASSWORD
```

### 3. Run the application

With IntelliJ IDEA, run:

```text
TaskManagementApiApplication
```

Or using Maven:

```bash
./mvnw spring-boot:run
```

On Windows:

```powershell
.\mvnw.cmd spring-boot:run
```

The application runs on:

```text
http://localhost:8080
```

## Author

**Amaneh Nasr**
