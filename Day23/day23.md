Day 23 - Lab Test Appointment Booking System with JWT Authentication
Project Overview
In Day 23, we focused on implementing the Lab Test Appointment Booking System along with JWT Authentication. This system allows users to book lab tests and doctor appointments. After a successful login via JWT, users can securely book appointments and manage their test bookings.

Tasks Completed
1. JWT Authentication Integration
Implemented JWT Authentication for user login and secure access to the Lab Test Appointment Booking System.

Developed JwtAuthenticationFilter to validate JWT tokens with each request.

Configured Spring Security to handle JWT-based authentication for secure endpoints.

2. Lab Test Appointment Booking
Created the LabTest and TestBooking entities to manage test data and bookings.

Set up TestBookingController to handle booking requests from authenticated users.

Implemented the TestBookingService to save the booking details in the database.

3. Doctor Appointment Booking
Integrated Doctor Appointment Booking functionality alongside the Lab Test Appointment system.

Created Doctor and DoctorAppointment entities to store doctor and appointment details.

Developed DoctorController and DoctorAppointmentController to handle doctor registration and appointment booking.

4. Appointment Date Management
Implemented LocalDate for handling booking and appointment dates, ensuring that the Booking Date is automatically set to the current date upon booking.

5. User and Appointment Data Handling
Created UserDTO to transfer user data.

Implemented the UserService to manage user registrations, authentication, and profile updates.

Ensured Appointment and User data were securely handled and linked in the system.

Technologies Used
Spring Boot: For building the backend API and handling business logic.

JWT (JSON Web Tokens): For user authentication and maintaining session security.

Spring Security: For configuring authentication and authorization.

MySQL/PostgreSQL: For storing user and appointment data securely.

Thymeleaf: For rendering HTML views and handling form submissions.

Steps Taken
JWT Authentication:

Implemented a JWT authentication filter for securing endpoints.

Ensured token validation for each request.

Database Configuration:

Created entities like TestBooking, Doctor, DoctorAppointment for storing user and appointment data.

Configured JPA repositories for data access and management.

Controller Layer:

Developed TestBookingController and DoctorAppointmentController for managing booking and doctor appointment endpoints.

Added functionality to book appointments and view confirmation.

Frontend:

Created Thymeleaf templates for booking forms and appointment details views.

Challenges
JWT Token Handling: Managing the JWT token in the frontend and ensuring secure transmission in API requests was a crucial step.

Date Handling: Ensuring that the Booking Date was automatically set to the current date upon booking while also handling the Appointment Date correctly for the test/doctor appointment.