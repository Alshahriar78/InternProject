## Day 20 - Appointment Booking System
Overview
On Day 20, I continued working on the Appointment Booking System with a focus on integrating Spring Security for authentication. The main task was to implement JWT-based authentication and configure the Spring Security setup to secure the application. However, there was an issue with UserDetailsService that couldn't be resolved in time.

## Tasks Completed
JWT Authentication Setup:

Implemented a JwtAuthenticationFilter to handle JWT token-based authentication.

Created a custom JwtAuthenticationFilter class that validates the JWT token from the HTTP request header and sets the authentication context in the SecurityContextHolder.

Spring Security Configuration:

Configured the SecurityConfig class to use the JwtAuthenticationFilter in the filter chain.

Set up HttpSecurity to disable CSRF, configure public endpoints, and secure others.

UserDetailsService Issue:

Implemented a custom UserDetailsService to load user data from the database.

Attempted to integrate the custom UserDetailsService into the Spring Security configuration for user authentication.

Issue with UserDetailsService Bean:

Encountered an error during the integration of UserDetailsService.

The error stated that UserDetailsService was not defined as a Spring bean, which caused the application to fail during startup.

Despite multiple attempts to define the necessary UserDetailsService bean, the issue persists and couldn't be resolved in time.

Issue Not Resolved
The main issue encountered was with the UserDetailsService bean. The application failed to start due to UserDetailsService being undefined as a Spring bean. The issue was that Spring Security could not find the UserDetailsService required for authenticationProvider in SecurityConfig. Even though I attempted to define the bean and troubleshoot the configuration, the problem remained unresolved by the end of the day.

Next Steps
Debug the UserDetailsService Issue: Investigate further why the UserDetailsService bean is not being recognized by Spring.

Refactor Authentication Flow: Ensure that the JWT-based authentication is integrated correctly and securely in the project.