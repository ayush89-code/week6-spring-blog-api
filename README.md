# 🚀 Blog Management REST API

**Spring Boot 3.5.11** | **JPA/Hibernate** | **H2 + MySQL** | **Swagger UI** | **Production Ready**

Complete **CRUD REST API** for managing blog **Posts**, **Categories**, and **Comments** with full **JPA relationships**, **pagination**, **validation**, and **exception handling**.

[![Swagger UI](https://img.shields.io/badge/Swagger-UI-brightgreen)](http://localhost:8080/swagger-ui.html)
[![H2 Console](https://img.shields.io/badge/H2-Console-blue)](http://localhost:8080/h2-console)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.11-orange)](https://spring.io/projects/spring-boot)
[![License](https://img.shields.io/badge/License-Apache_2.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)

## ✨ **Features**

✅ **Full CRUD Operations**: Posts, Categories, Comments  
✅ **JPA Relationships**: Post↔Category (Many-to-One), Post↔Comment (One-to-Many)  
✅ **Pagination & Sorting**: `/api/posts?page=0&size=10`  
✅ **Input Validation**: `@Valid` + Custom Messages  
✅ **Global Exception Handling**: 400, 404, 500 JSON responses  
✅ **H2 Persistent Database** (file-based - data survives restart)  
✅ **MySQL Production Ready** (`prod` profile)  
✅ **Swagger UI Documentation** (24 endpoints)  
✅ **Unit Tests** (`@MockitoBean` - Spring Boot 3.5.11)  
✅ **Transaction Management** (`@Transactional`)  

## 🛠 **Tech Stack**
🔹 Spring Boot 3.5.11
🔹 Spring Data JPA + Hibernate 6.x
🔹 H2 Database (Development)
🔹 MySQL 8.x (Production)
🔹 Lombok
🔹 SpringDoc OpenAPI (Swagger UI 2.6.0)
🔹 Spring Validation
🔹 JUnit 5 + Mockito
🔹 Maven


## 🚀 **Quick Start**

### **1. Clone & Run (H2 - 30 seconds)**
```bash
git clone <your-repo-url>
cd week6-spring-blog-api
./mvnw clean spring-boot:run
```
# 2. Access Applications

| Service | URL | Description |
|----------|----------|----------|
| Swagger UI |      http://localhost:8080/swagger-ui.html| Interactive API Docs|
| H2 Console |     http://localhost:8080/h2-console | Database Browser |
| API Base |       http://localhost:8080/api | REST Endpoints |

## H2 Console Settings:
```bash
JDBC URL: jdbc:h2:file:./blogdb
User: sa
Password: (empty)
```
## 3. Test API (Swagger UI)
```bash
1. POST /api/categories → {"name": "Java"}
2. POST /api/posts → {"title": "Spring Boot Guide", "categoryId": 1}
3. GET /api/posts?page=0&size=5 → Paginated results
```
| Profile      | Command                                                | Database      | Persistence  |
| ------------ | ------------------------------------------------------ | ------------- | ------------ |
| H2 (Default) | ./mvnw spring-boot:run                                 | File-based H2 | ✅ Persistent |
| MySQL (Prod) | ./mvnw spring-boot:run -Dspring-boot.run.profiles=prod | MySQL 8.x     | ✅ Persistent |

# MySQL Setup:
   1. Start MySQL Service (XAMPP/Services)

   2. Create Database:
```bash
    mysql -u root -p
    CREATE DATABASE blogdb CHARACTER SET utf8mb4;
```
   3. Run Prod Profile:

```bash
./mvnw spring-boot:run -Dspring-boot.run.profiles=prod
```
   4. Verify Tables:
```bash
    USE blogdb;
    SHOW TABLES;  -- categories, posts, comments
```

# 🗺 API Endpoints (24 Total)
graph TD
    A[Categories] --> B[POST /api/categories]
    A --> C[GET /api/categories]
    A --> D[GET /api/categories/{id}]
    A --> E[PUT /api/categories/{id}]
    A --> F[DELETE /api/categories/{id}]
    
    G[Posts] --> H[POST /api/posts]
    G --> I[GET /api/posts]
    G --> J[GET /api/posts/{id}]
    G --> K[PUT /api/posts/{id}]
    G --> L[DELETE /api/posts/{id}]
    
    M[Comments] --> N[POST /api/comments/post/{postId}]
    M --> O[GET /api/comments/post/{postId}]
    M --> P[PUT /api/comments/{id}]
    M --> Q[DELETE /api/comments/{id}]

# 🧪 Running Tests
```bash
# Compile Tests
./mvnw clean test-compile

# Run Tests
./mvnw test
```

