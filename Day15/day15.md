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

