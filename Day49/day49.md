# RECAP 

## Spring REST API
### 🚫 Common Mistakes REST API:
Mistake	Explanation

- Missing @RestController	Results in HTML view instead of JSON
- Missing @RequestBody	Data will not bind to DTO
- No @PathVariable used	404 error for dynamic URLs
- Directly using Entity	Bad practice, should use DTO for security and abstraction

### 🧾 REST Endpoint Naming Conventions
* Use Nouns, Not Verbs: Instead of /createUser, use /users with a POST request. 
* Pluralize Collections: GET /users retrieves a list of users, while GET /users/{id} retrieves a specific user. 
* Hyphens for Separation.
* Lowercase: Use lowercase letters in your URIs. 
* Avoid Abbreviations: Use clear, descriptive names instead of abbreviations (e.g., use firstName instead of fn). 
* Versioning: Include API versions in the URI (/v1/users). 


## 🧠 Topic: Spring Data JPA

### 🚫 Common Mistakes 
Mistake	Reason

* Not using @Entity	Table won’t be created
* @Id missing	Error in runtime
* Using @Autowired with constructor injection. Prefer constructor injection manually
* Using Entity directly in Controller. Use DTOs instead