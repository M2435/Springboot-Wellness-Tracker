# Spring Boot Demo Application

A Spring Boot application for managing users, moods, and activities.

## Features

- User management
- Mood tracking
- Activity logging
- RESTful API endpoints

## Prerequisites

- Java 11 or higher
- Maven 3.6+

## Building and Running

### Build the project
```bash
./mvnw clean package
```

### Run the application
```bash
./mvnw spring-boot:run
```

The application will start on `http://localhost:8080`

## Project Structure

- `src/main/java/com/example/demo/` - Main application code
  - `controller/` - REST controllers
  - `model/` - Entity models
  - `repository/` - Data access layer
- `src/main/resources/` - Configuration and static files
- `src/test/` - Unit tests

## API Endpoints

- Users: `/users`
- Moods: `/moods`
- Activities: `/activities`

## Author

Created for demo purposes
