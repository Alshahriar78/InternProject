# Spring Boot Application: Spring Security Authentication

This project demonstrates how to implement **Authentication** in a **Spring Boot** application using **Spring Security**.  
Alongside, we have worked with Entity-DTO-Mapper-Service-Repository patterns for a clean architecture.

---

## 🔐 Authentication Flow

1. A user will try to **login**.
2. Spring Security will check the **username/password** from the database.
3. If the credentials are valid, Spring will authenticate the user and generate a session/token (depending on your configuration).
4. Unauthorized users trying to access secured APIs will receive a **401 Unauthorized** response.


## 📢 Note

This project is developed for learning purposes to deeply understand how **Authentication** and **Security** work in a real-world Spring Boot application.

---
