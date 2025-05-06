# 🏥 Lab Test Appointment Booking System

A Spring Boot web application for patients to register, log in, and book lab test appointments.  
Built with a layered architecture using DTOs, Services, Repositories, Spring Security (with database-based login), and Thymeleaf frontend views.

---

## 🚀 Features Implemented Today

### 🔐 User Registration (with Form Validation)
- Multi-step user registration with form validation (`@Valid`, `BindingResult`).
- DTO to Entity conversion using a custom `UsersMapper`.
- Passwords encoded using `BCryptPasswordEncoder`.
- Persisted using `UsersRepository` (extends `JpaRepository`).

### 🔒 User Login & Logout (Spring Security)
- Custom login page (`/login`) using Spring Security.
- Authentication using database (via `CustomUserDetailsService`).
- `Users` entity used as the source of truth.
- Post-login redirect to `/dashboard`.
- Logout support via `/logout`.

### 🛡️ Security Configuration
- `SecurityConfig` class with:
  - `PasswordEncoder` bean
  - `SecurityFilterChain` bean
  - CSRF disabled (for now)
  - Public access to registration, login, and static assets
  - Role-based or URL-based access control (ready for future use)

### 🧠 Custom Classes
- `UsersDTO`: Carries registration data with validation annotations.
- `UsersMapper`: Maps between `UsersDTO` and `Users` entity.
- `UsersService`: Handles registration logic.
- `CustomUserDetailsService`: Implements Spring Security's `UserDetailsService`.

---

## 🗂️ Project Structure (Relevant Packages)

org.healthcare.AppointmentBooking
├── config
│ └── SecurityConfig.java
├── controller
│ └── UsersController.java
├── service
│ └── UsersService.java
│ └── CustomUserDetailsService.java
├── model
│ ├── dto
│ │ └── UsersDTO.java
│ ├── entity
│ │ └── Users.java
│ └── mapper
│ └── UsersMapper.java
├── repository
│ └── UsersRepository.java




---

## ✅ Dependencies Used
- Spring Boot Starter Web
- Spring Boot Starter Security
- Spring Boot Starter Thymeleaf
- Spring Boot Starter Validation
- Spring Data JPA
- H2 / MySQL (for persistence)
- Lombok

---

## ⚠️ Known Issues & To-Dos
- [ ] Implement email uniqueness check during registration.
- [ ] Add role-based access (ADMIN, PATIENT).
- [ ] Add appointment booking features.
- [ ] Add unit tests for registration and login.
- [ ] Add CSRF protection properly.

---

