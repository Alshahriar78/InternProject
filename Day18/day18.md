Lab Test Appointment Booking System - Day 18

Date: May 5, 2025

Overview

On Day 18, we focused on implementing user registration end-to-end using Spring Boot and Thymeleaf, including DTO validation, password encoding, and a responsive Bootstrap-based front-end form.

Completed Tasks

DTO & Entity Mapping

Defined UsersDTO with JSR‑303 validation (@NotBlank, @Pattern, etc.).

Created Users JPA entity with fields: id, fullName, mobileNumber, gender, email, password, dateOfBirth, roles, enabled.

Implemented UsersMapper for DTO ↔ Entity conversion (omitting id and enabled for registration flows).

Service Layer

Configured PasswordEncoder bean (BCryptPasswordEncoder) in SecurityConfig.

Implemented UsersService with register(UsersDTO):

Mapped DTO to entity.

Encoded user password.

Persisted user via UsersRepository.

Controller

Switched from @RestController to @Controller for HTML views.

Added GET /users/register to display the empty registration form.

Added POST /users/register to process form submission, validate input, and redirect on success.

Thymeleaf Front-End

Created templates/users/register.html:

Bootstrap 5 styling and responsive layout.

Form bound to UsersDTO using th:object and th:field.

Real-time validation messages via th:errors and BindingResult.

Password visibility toggle with Bootstrap Icons.

Next Steps

Implement login functionality with Spring Security.

Build appointment booking form and service search.

Create admin portal for managing user roles and appointment statuses.