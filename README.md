# Student Management System (Spring Boot + JWT)

A simple backend REST API built using Spring Boot that demonstrates authentication and CRUD operations with JWT-based security.

---

##  Features

- User registration
- User login with JWT authentication
- Password encryption using BCrypt
- Secure REST APIs using Spring Security
- Student CRUD operations (Create, Read, Update, Delete)
- MySQL database integration

---

##  Tech Stack

- Java 21
- Spring Boot
- Spring Security
- JWT (jjwt)
- Spring Data JPA
- MySQL
- Maven

---

##  Authentication Flow

1. User registers via `/auth/register`
2. User logs in via `/auth/login`
3. Server generates and returns a JWT token
4. Token must be sent in every request header:
   Authorization: Bearer <eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiIsImlhdCI6MTc4MjI0MDg0NCwiZXhwIjoxNzgyMzI3MjQ0fQ.Whc8-X1QNwqauHdObwKI3WfM00wmatwOD79KL8-oUII>
5. All protected endpoints require a valid token

---

##  API Endpoints

### Auth APIs (Public)
- POST `/auth/register` → Register new user
- POST `/auth/login` → Login and receive JWT token

### Student APIs (Protected)
- GET `/students` → Get all students
- GET `/students/{id}` → Get student by ID
- POST `/students` → Add new student
- PUT `/students/{id}` → Update student
- DELETE `/students/{id}` → Delete student

---

##  Database

- MySQL database
- Tables:
  - `student`
  - `users`
- Auto table creation enabled using JPA/Hibernate

---

##  How to Run the Project

### 1. Clone the repository
```bash
git clone https://github.com/shahedkaraki/student-management-system.git
```
### 2. Configure database
Update src/main/resources/application.properties:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=root
spring.datasource.password=your_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run the project

```bash
mvn spring-boot:run
```

### 4. Access the application
```text
http://localhost:8080
```


---

##  Author

Developed by: Shahed Alkaraki
