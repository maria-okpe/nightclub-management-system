# NightClub Management System

A simple Spring Boot application to manage a nightclub with three rooms:

- **Common Room:** Any authenticated user can enter.
- **Business Room:** Only users with `BUSINESS` type can enter.
- **Exclusive Room:** Only `VIP` users can enter.

## Features

- JWT-based authentication and authorization
- Role-based access control using `@PreAuthorize`
- User registration and login with secure password hashing
- User validation (age must be above 18)
- H2 in-memory database for quick testing
- REST API endpoints with descriptive responses
- Exception handling with `@RestControllerAdvice`

## Tech Stack

- Java 17+ / Spring Boot
- Spring Security + JWT
- Spring Data JPA / H2 Database
- Lombok
- Validation API
- Maven

## How to Run

1. Clone the repository:
   ```bash
   git clone <repository_url>
