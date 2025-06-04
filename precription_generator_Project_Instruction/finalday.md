🧾 Prescription Management System
A modern, web-based application built with Spring Boot for managing medical prescriptions, integrated with JWT-based authentication and an H2 in-memory database. Designed for doctors, patients, and admins with a user-friendly dashboard and REST API capabilities.

🚀 How to Run the Project
Clone the repository and open it in your IDE.

Run PrescriptionManagementSystemApplication.java to start the application.

Open your browser and go to:
👉 http://localhost:8080

Click on "Login with Dummy Data First Time" to pre-fill the database with sample users and roles.

Use the following credentials to log in:

Role	    email	               Password
DOCTOR	  doctor@example.com	   password
PATIENT	  patient@example.com       password
DOCTOR    doctor3@example.com      password

✅ Core Features
🔐 Authentication & Authorization
Secure login using JWT (JSON Web Token)

Role-based access control for Doctor, Patient

📝 Prescription Management
Create prescriptions with full form validation

Edit and delete prescriptions securely

View prescriptions 

Filter prescriptions by custom date range

Generate day-wise prescription count report (with date & count)

📊 Doctor Dashboard
View all recent prescriptions in tabular format

View registered patients

Create prescriptions for registered patients

🌐 External API Integration
Fetch and display posts from:https://prescription-generation.free.beeceptor.com/todos";
 show to Create Button in Dashboard ui for view this json body in tabluar format

🎁 Bonus Features
🩺 Patient Management
Patient self-registration and storage in the system

Doctors can view and select patients while writing prescriptions



🔧 Full API documentation is available via Swagger UI:
📍 http://localhost:8080/swagger-ui/index.html

🛠️ Tech Stack
⚙️ Java 21

🚀 Spring Boot 3.4.5

🔐 Spring Security with JWT

🗄️ Spring Data JPA

🧠 H2 In-Memory Database

🎨 Thymeleaf (for UI rendering)

📘 Swagger (for REST API documentation)

🧠 Apply SOLID PRINCIPAL


Mobile-responsive UI for doctors and patients