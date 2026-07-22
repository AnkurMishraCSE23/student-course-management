# Student Course Management System - Spring Boot REST API

A RESTful backend application built using **Java**, **Spring Boot**, **Spring Data JPA (Hibernate)**, and **MySQL** that manages **Students**, **Courses**, and **Enrollments**. The project follows a clean layered architecture with proper separation of concerns using **Controllers**, **Services**, **Repositories**, **DTOs**, and **Mappers**.

The application demonstrates enterprise backend development practices including validation, exception handling, entity relationships, pagination, sorting, and search functionality.

---

## Features

### Student Management
- Create, retrieve, update, and delete students
- Search students by email
- Search students by name
- Pagination and sorting support
- Email uniqueness validation

### Course Management
- Create, retrieve, update, and delete courses
- Search courses by name
- Pagination and sorting support
- Course name uniqueness validation

### Enrollment Management
- Enroll students into courses
- Prevent duplicate enrollments
- Retrieve enrollments
- View enrollments by student
- View enrollments by course
- Delete enrollments
- Automatic enrollment date generation
- Automatic enrollment status assignment

### Validation
- Bean Validation using Jakarta Validation
- Custom validation messages
- Request DTO validation
- Business rule validation

### Exception Handling
- Global exception handling using `@RestControllerAdvice`
- Custom exceptions
- Structured error responses
- Appropriate HTTP status codes

### REST API Features
- DTO-based API design
- Proper HTTP status codes
- Pagination
- Sorting
- Search APIs

---

# Technology Stack

| Technology | Purpose |
|------------|---------|
| Java 21 | Programming Language |
| Spring Boot | Backend Framework |
| Spring Web | REST APIs |
| Spring Data JPA | ORM |
| Hibernate | JPA Implementation |
| MySQL | Database |
| Maven | Dependency Management |
| Jakarta Bean Validation | Input Validation |

---

# Project Architecture

```
                Client
                   │
                   ▼
        REST Controllers
                   │
                   ▼
             Service Layer
                   │
                   ▼
        Spring Data JPA Repository
                   │
                   ▼
          Hibernate (JPA)
                   │
                   ▼
             MySQL Database
```

The project follows a layered architecture to ensure maintainability, scalability, and separation of concerns.

---

# Project Structure

```
src/main/java
│
├── controller
├── service
│     ├── interfaces
│     └── implementations
├── repository
├── entity
├── dto
│     ├── request
│     └── response
├── mapper
├── exception
├── handler
└── config
```

---

# Database Design

```
+-----------+       +---------------+       +-----------+
|  Student  | 1   * |  Enrollment   | *   1 |  Course   |
+-----------+-------+---------------+-------+-----------+
                    | student_id FK |
                    | course_id FK  |
                    | enroll_date   |
                    | status        |
                    +---------------+
```

The project models the Student–Course relationship using an explicit **Enrollment** entity rather than a direct `@ManyToMany` relationship. This approach is commonly used in enterprise applications because it allows additional attributes such as enrollment date and status to be stored.

---

# JPA Relationships

- One Student → Many Enrollments
- One Course → Many Enrollments
- Many Enrollments → One Student
- Many Enrollments → One Course

---

# REST API Endpoints

## Student APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/students` | Create Student |
| GET | `/students` | Get All Students |
| GET | `/students/{id}` | Get Student By ID |
| PUT | `/students/{id}` | Update Student |
| DELETE | `/students/{id}` | Delete Student |
| GET | `/students/search?name=` | Search Students |

---

## Course APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/courses` | Create Course |
| GET | `/courses` | Get All Courses |
| GET | `/courses/{id}` | Get Course By ID |
| PUT | `/courses/{id}` | Update Course |
| DELETE | `/courses/{id}` | Delete Course |
| GET | `/courses/search?name=` | Search Courses |

---

## Enrollment APIs

| Method | Endpoint | Description |
|--------|----------|-------------|
| POST | `/enrollments` | Enroll Student |
| GET | `/enrollments` | Get All Enrollments |
| GET | `/enrollments/{id}` | Get Enrollment By ID |
| GET | `/enrollments/student/{id}` | Get Student Enrollments |
| GET | `/enrollments/course/{id}` | Get Course Enrollments |
| DELETE | `/enrollments/{id}` | Delete Enrollment |

---

# Validation

The project uses **Jakarta Bean Validation** to validate incoming request data.

Examples include:

- Required fields
- Email validation
- String length validation
- Positive numeric values
- Business rule validations

---

# Exception Handling

The application provides centralized exception handling using `@RestControllerAdvice`.

Custom exceptions include:

- StudentNotFoundException
- CourseNotFoundException
- EnrollmentNotFoundException
- DuplicateEmailException
- DuplicateCourseNameException
- DuplicateEnrollmentException

Each exception returns a structured JSON response containing:

- Timestamp
- HTTP Status
- Error
- Message
- Request Path
- Validation Errors (when applicable)

---

# Key Concepts Demonstrated

- Layered Architecture
- Dependency Injection
- Constructor Injection
- Spring Data JPA
- Hibernate ORM
- DTO Pattern
- Mapper Pattern
- Bean Validation
- Global Exception Handling
- Custom Exceptions
- Pagination
- Sorting
- Derived Query Methods
- Entity Relationships
- Business Logic Implementation

---

# Getting Started

## Clone the repository

```bash
git clone <repository-url>
```

## Configure Database

Update `application.properties` with your MySQL credentials.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_course_management
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

## Run the application

```bash
mvn spring-boot:run
```

The application will start on:

```
http://localhost:8080
```

---

# Future Enhancements

- Spring Security with JWT Authentication
- Role-Based Authorization
- Swagger / OpenAPI Documentation
- Unit Testing with JUnit & Mockito
- Integration Testing
- Docker Support
- Logging using SLF4J
- Transaction Management
- Cascade Operations
- Fetch Strategies
- Enum Mapping
- Cloud Deployment

---

# Author

**Ankur Mishra**

B.Tech Computer Science & Engineering

Backend Developer | Java | Spring Boot | Hibernate | MySQL