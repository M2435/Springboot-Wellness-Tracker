# Spring Boot Demo Application

A Spring Boot REST API for managing users, moods, and activities.

## 🚀 Features

* User management
* Mood tracking
* Activity logging
* RESTful API endpoints

## 🛠️ Tech Stack

* Java 11+
* Spring Boot
* Maven

## 🏗️ Architecture

This project follows a **Microkernel Architecture** pattern:

* **Core System (Kernel)**: Central business logic and data access layer with repositories and common services
* **Plug-in Modules**: Independent controllers (User, Mood, Activity) that function as plug-ins
* **Domain Models**: Shared entity models (User, Mood, Activity) used across modules
* **Benefits**: Modularity, easy to extend with new plug-ins, simple to test individual modules

## 📋 Prerequisites

* Java 11 or higher installed
* Maven 3.6+

## ▶️ Build & Run

### Build the project

```bash
./mvnw clean package
```

### Run the application

```bash
./mvnw spring-boot:run
```

Application starts at:

```
http://localhost:8080
```

## 📁 Project Structure

```
src/main/java/com/example/demo/
 ├── controller/   → REST controllers
 ├── model/        → Entity classes
 └── repository/   → Data access layer

src/main/resources/ → Config files
src/test/           → Unit tests
```

## 🌐 API Endpoints

| Module     | Endpoint    |
| ---------- | ----------- |
| Users      | /users      |
| Moods      | /moods      |
| Activities | /activities |

## 👤 Author

Demo project created for learning Spring Boot.
