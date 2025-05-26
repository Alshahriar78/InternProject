# Appointment Booking System

A healthcare appointment booking system that demonstrates the implementation of the Open-Closed Principle (OCP) from SOLID principles.

## Table of Contents
- [Overview](#overview)
- [Open-Closed Principle](#open-closed-principle)
- [Examples in this Project](#examples-in-this-project)
- [Project Structure](#project-structure)
- [Setup and Installation](#setup-and-installation)
- [Usage](#usage)
- [Contributing](#contributing)

## Overview

This project is a healthcare appointment booking system that allows users to register, book appointments with doctors, manage lab tests, and more. The system is designed with a focus on maintainability, extensibility, and adherence to SOLID principles, particularly the Open-Closed Principle.

## Open-Closed Principle

The Open-Closed Principle (OCP) is one of the five SOLID principles of object-oriented design. It states that:

> "Software entities (classes, modules, functions, etc.) should be open for extension but closed for modification."

This means that you should be able to extend a class's behavior without modifying its source code. This is typically achieved through the use of abstractions (interfaces or abstract classes) and polymorphism.

### Benefits of OCP

- **Reduced Risk**: Modifying existing code can introduce bugs. By extending rather than modifying, we reduce this risk.
- **Improved Maintainability**: Code that follows OCP is easier to maintain as new functionality can be added without changing existing code.
- **Enhanced Reusability**: Abstractions created for OCP often lead to more reusable components.
- **Better Testability**: Code that follows OCP is typically easier to test as components are more loosely coupled.

## Examples in this Project

This project demonstrates the Open-Closed Principle in several areas:

### 1. User Registration

The system supports different types of user registration through the `UserRegistrationService` interface:

```java
public interface UserRegistrationService {
    ResponseEntity<String> register(UsersDTO userDTO);
}
```

Implementations:
- `StandardUserRegistrationService`: Registers standard users
- `PremiumUserRegistrationService`: Registers premium users with additional roles

This design allows adding new types of user registration (e.g., `CorporateUserRegistrationService`) without modifying existing code.

### 2. Lab Deletion

The system supports different strategies for deleting labs through the `LabDeletionService` interface:

```java
public interface LabDeletionService {
    String deleteLab(Long id);
}
```

Implementations:
- `HardLabDeletionService`: Physically removes the lab record from the database
- `SoftLabDeletionService`: Marks the lab as deleted without removing it from the database

This design allows adding new deletion strategies (e.g., `ArchiveLabDeletionService`) without modifying existing code.

### 3. User Deletion

The system supports user deletion through the `UserDeletionService` interface:

```java
public interface UserDeletionService {
    ResponseEntity<String> deleteUserById(Long id);
}
```

Currently implemented by `StandardUserDeletionService`, but the design allows for future extensions like premium user deletion with different behaviors.

## Project Structure

The project follows a standard Spring Boot application structure:

```
src/
├── main/
│   ├── java/
│   │   └── org/
│   │       └── healthcare/
│   │           └── AppointmentBooking/
│   │               ├── controller/
│   │               ├── model/
│   │               │   ├── dto/
│   │               │   ├── entity/
│   │               │   └── mapper/
│   │               ├── repository/
│   │               └── service/
│   │                   ├── deletion/
│   │                   └── registration/
│   └── resources/
│       ├── static/
│       └── templates/
└── test/
    └── java/
        └── org/
            └── healthcare/
                └── AppointmentBooking/
```

## Setup and Installation

1. Clone the repository:
   ```
   git clone https://github.com/yourusername/appointment-booking.git
   cd appointment-booking
   ```

2. Build the project:
   ```
   ./gradlew build
   ```

3. Run the application:
   ```
   ./gradlew bootRun
   ```

## Usage

The application provides RESTful APIs for:
- User registration (standard and premium)
- Appointment booking
- Lab test management
- User and lab deletion

Refer to the API documentation for detailed usage instructions.

## Contributing

Contributions are welcome! When contributing to this project, please follow these guidelines:

1. Fork the repository
2. Create a feature branch
3. Commit your changes
4. Push to the branch
5. Create a new Pull Request

When adding new features, try to follow the Open-Closed Principle by extending existing interfaces rather than modifying existing implementations.