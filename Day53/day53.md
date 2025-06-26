# 🚀 Day 53 - Spring Security & Servlet Architecture (Learning Log)

Today was all about diving deep into **Spring Backend**, with a strong focus on **Spring Security**, **Servlet architecture**, and **filter chains**. Here's a complete summary of the concepts, implementations, and explanations covered.

---

## ✅ Topics Covered

### 🔐 Spring Security & JWT
- What is **JSON Web Token (JWT)**?
- JWT structure: Header, Payload, Signature
- Use cases of JWT in stateless authentication
- Generating and validating JWT in Spring Boot


### 🧾 Logging in Spring
- `log.info()` vs `System.out.println()`
- Logging levels: `info`, `debug`, `warn`, `error`
- Configuring logs in `application.properties`

### 🌐 URI Creation
- Using `ServletUriComponentsBuilder`:
  ```java
  URI.create(ServletUriComponentsBuilder
      .fromCurrentContextPath()
      .path("/api/user/save")
      .toUriString());
    ```

### 🛡️ Spring Security Architecture
- Security filter chain (15+ filters)

- Authentication flow:

  - - Request → Filter → AuthenticationManager

- UserDetailsService → DB check → Authentication success

- SecurityContextHolder holds authenticated user

Authorization flow:

- Role checking using @PreAuthorize, hasRole()

- SecurityContextHolder, Authentication, GrantedAuthority


### 🔀 FilterChain

### 📨 DispatcherServlet
- Core of Spring MVC, extends HttpServlet

- Handles all requests and routes them to controllers

- Integrated automatically in Spring Boot

### 📎 Servlet Concept
- A Java class that handles HTTP requests/responses

- Runs inside a Servlet container (e.g., Tomcat)

- Spring Boot uses DispatcherServlet as its front controller
