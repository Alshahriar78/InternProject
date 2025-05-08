## Day 21: JWT Authentication Implementation
## Overview
On Day 21, I worked on implementing JWT Authentication in my project. The goal was to enable stateless authentication using JSON Web Tokens (JWT) to securely handle user login, generate tokens, and ensure that users are authenticated for protected routes.

Steps Taken
1. Setup JWT Authentication Flow
Created an AuthenticationController to handle user login requests and generate a JWT token upon successful authentication.

Used AuthenticationManager to authenticate users based on their credentials (username and password).

Integrated BCryptPasswordEncoder for password encoding and validation.

2. Token Generation
Created a JwtUtil class to handle token generation, validation, and expiration.

Token Structure: The token consists of Header, Payload, and Signature.

Expiration: Tokens are set to expire in 10 hours, after which users must log in again.

Token Signing: Used HS256 algorithm with a secret key to sign the tokens.

3. Security Config
Configured Spring Security to authenticate users and validate JWT tokens using JwtAuthenticationFilter.

Added JwtAuthenticationFilter before the UsernamePasswordAuthenticationFilter to ensure token validation happens during the authentication process.

4. Login Endpoint
Implemented a login endpoint (/api/auth/login) to receive username and password, authenticate the user, generate a JWT token, and return the token in the response.

Included a successful login message and the JWT token in the response for the frontend to use.

5. Token Validation
In the JwtAuthenticationFilter, added logic to validate the JWT token for each incoming request.

JWT token is extracted from the Authorization header, and the token is validated against the secret key to ensure the user is authenticated.

6. Redirection After Login
After a successful login, returned the JWT token to the frontend.

Optionally, added a redirect URL for the dashboard after login (handled by frontend).

7. Frontend Interaction
The frontend stores the JWT token after successful login (in localStorage or cookies).

For subsequent requests, the token is sent in the Authorization header as Bearer <token> to authenticate the user for protected routes.


## Future Work
Integrate Refresh Token functionality to allow users to stay logged in without constantly refreshing the token.

Add Role-based Access Control using JWT, where different roles (admin, user, etc.) are decoded from the JWT token and used to control access to various parts of the application.

Implement secure token storage (like HttpOnly Cookies) to protect tokens from XSS attacks.

## Conclusion
In Day 21, I successfully implemented JWT Authentication to securely authenticate users, generate tokens, and verify tokens for protected resources. The solution includes secure token generation, validation, and integration with Spring Security to manage authentication.