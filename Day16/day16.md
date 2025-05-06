## What is JWT?
jwt stands for JSON Web Token. it is a token based authentication mechanism used to securely verify user's identity When a user logs in, the server generates and returns a JWT token. Then, for every subsequent request to a protected resource, the user sends this token, and the server verifies it to confirm that the user is authenticated.

## A JWT consists of three parts:

* Header – Contains metadata like the signing algorithm (e.g., HS256)
* Payload – Contains user data (like user ID, roles, etc.)
* Signature – Verifies that the token has not been tampered with

## How JWT Works in Spring Boot

1. User logs in with username and password.
* Sends a POST request to /authenticate endpoint.

2. Server validates credentials using UserDetailsService.

If valid, a JWT token is generated using a utility class like JwtUtil with:

Username

Issue date

Expiration date

Secret key

4. Token is sent back to the client (usually in the response body or header).

5. Client stores token (e.g., localStorage, sessionStorage, or in a cookie).

6. For each future request to protected endpoints, client sends token in:

makefile

Authorization: Bearer <JWT token>

7. Spring Boot filters each request using a custom JWTFilter, verifies the token, and:

If valid, sets Authentication in SecurityContext

If invalid, rejects the request (401 Unauthorized)

