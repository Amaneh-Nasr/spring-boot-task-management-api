# Task Management API

A RESTful API built with **Java 17 and Spring Boot 3** to create, manage, and filter tasks. Task data is stored in MySQL using Spring Data JPA.

The project also integrates a local AI model through Ollama to suggest task priorities.

## Features

- Create, retrieve, update, and delete tasks
- Filter tasks by priority (`LOW`, `MEDIUM`, `HIGH`)
- Manage due dates and completion status
- AI-based priority suggestions using Ollama
- Centralized exception handling
- Swagger/OpenAPI documentation

## Technologies

Java 17 · Spring Boot 3 · Spring Data JPA · MySQL · Maven · Ollama · Swagger/OpenAPI

## API Endpoints

| Method | Endpoint | Description |
|---|---|---|
| GET | `/tasks` | Get all tasks |
| GET | `/tasks/{id}` | Get a task by ID |
| GET | `/tasks?priority=HIGH` | Filter by priority |
| POST | `/tasks` | Create a task |
| PUT | `/tasks/{id}` | Update a task |
| DELETE | `/tasks/{id}` | Delete a task |

## Architecture

```text
Client
  |
  v
TaskController
  |
  v
TaskService ----> AIService ----> Ollama
  |
  v
TaskRepository
  |
  v
MySQL
```

- **Controller:** Handles HTTP requests.
- **Service:** Contains business logic.
- **Repository:** Handles database access.
- **AIService:** Requests priority suggestions from Ollama.

## Run the Application

**Prerequisites:** JDK 17, MySQL, Ollama, and the model `qwen2.5-coder:3b`.

1. Clone the repository:

   ```bash
   git clone https://github.com/Amaneh-Nasr/spring-boot-task-management-api.git
   cd spring-boot-task-management-api
   ```

2. Configure the database connection and Ollama settings in `application.properties`.

3. Start the application on Windows:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

4. Open Swagger UI:

   http://localhost:8080/swagger-ui/index.html

## Author

**Amaneh Nasrramzy**
