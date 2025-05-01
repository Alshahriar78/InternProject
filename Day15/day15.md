 # 📅 Day 15 - Spring Security: Authentication & Role-Based Access
Today I learned how to implement authentication and authorization in Spring Boot using Spring Security.

## There is mainly six way to authentication in spring Boot
  * In-Memory Authentication
  * JDBC Authentication
  * UserDetailsService (Custom Authentication)
  * LDAP Authentication
  * OAuth2 / OpenID Connect
  * JWT (JSON Web Token) Authentication 

---
## What is Servlet? How its Works?
A servlet is a java class that used to handle Http request and response in web application. Its run on a servlets Container.
🔄 Servlet Life Cycle Phases:
*Loading and Instantiation
*Initialization (init() method)
*Request Handling (service() method)
*Destruction (destroy() method)

## What is Servlets Container & How its work?
A Servlet conatiner is a part of web Container that manges lifecycle of a servlets, Handles Http Request/Response and map URls to appropriate servlet class.Handles multi-threading, security, and session management.
In Spring Boot, the servlet container allows you to run your application as a web application without needing an external server.

📌 Common Servlet Containers:
* Tomcat (default in Spring Boot)

* Jetty

* Undertow 

🔹 Steps of How It Works:

*Startup
Loads web apps (.war or Spring Boot app)
Reads web.xml or @WebServlet for URL mappings

*Client Request
User sends HTTP request (e.g., /hello)
Container receives request

*Request Mapping
Matches URL with corresponding servlet

*Servlet Instantiation (if not created yet)
Loads servlet class
Creates servlet object
Calls init() method once

*Request Handling
Calls service() method
Based on method type: GET → doGet() ,POST → doPost()

*Response Sending
Servlet sends response (HTML/JSON)
Container returns it to the client

*Shutdown
Calls destroy() method during server stop




## ✅ Topics Covered

- Spring Security Authentication Overview
- `InMemoryUserDetailsManager` for user setup
- Role-based access control using `.requestMatchers()`
- Using `@PreAuthorize` for method-level security
- Creating admin-only secured endpoints
- Introduction to `DaoAuthenticationProvider`

---

## 🔐 Users Defined (InMemory)

```java
UserDetails user = User.withDefaultPasswordEncoder()
    .username("user")
    .password("password")
    .roles("USER")
    .build();

UserDetails admin = User.withDefaultPasswordEncoder()
    .username("admin")
    .password("admin123")
    .roles("ADMIN")
    .build();

return new InMemoryUserDetailsManager(user, admin);

