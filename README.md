Lovable Clone

A Spring Boot backend that recreates the core product mechanics of Lovable — an AI-powered app-builder platform. It handles user authentication, project & file management, team collaboration, subscription billing (Stripe), and per-user usage tracking, all behind a secured REST API.

Note: This is a backend-only clone built for learning purposes — there is no AI code-generation engine or frontend included. It focuses on the surrounding SaaS infrastructure: auth, multi-tenant projects, roles/permissions, billing, and usage limits.

Features
Authentication & Authorization — JWT-based signup/login, stateless session handling, and route protection via Spring Security.
Project Management — Create, update, delete, and list projects; each project owns a tree of generated files.
File Explorer API — List a project's file tree and fetch individual file contents by path.
Team Collaboration — Invite members to a project, assign roles (OWNER, EDITOR, VIEWER), and manage/remove members.
Billing (Stripe-ready) — Fetch available plans, view the current subscription, and create Stripe Checkout / Billing Portal sessions.
Usage Tracking — Track and expose daily usage and plan limits per user.
Clean layered architecture — Controller → Service → Repository, with DTOs and MapStruct-generated mappers keeping entities decoupled from the API layer.
Tech Stack
Layer	Technology
Language	Java 21
Framework	Spring Boot 4.0.1 (Web MVC, Data JPA, Validation, Security)
Database	PostgreSQL
Auth	JWT (jjwt)
Object Mapping	MapStruct
Boilerplate Reduction	Lombok
Build Tool	Maven (with Maven Wrapper)
Project Structure
demo/
└── src/main/java/com/project/lovableproject/demo/
    ├── controller/     # REST endpoints (Auth, Project, File, Member, Billing, Usage)
    ├── service/        # Business logic interfaces + impl/
    ├── repository/     # Spring Data JPA repositories
    ├── entity/         # JPA entities (User, Project, ProjectFile, Subscription, etc.)
    ├── dto/             # Request/response DTOs, grouped by domain
    ├── mapper/         # MapStruct entity <-> DTO mappers
    ├── security/       # JWT filter, auth utils, Spring Security config
    ├── enums/          # ProjectRole, SubscriptionStatus, PreviewStatus, MessageRole
    └── error/          # Global exception handling & custom exceptions
API Overview
Area	Endpoint	Description
Auth	POST /api/auth/signup	Register a new user
Auth	POST /api/auth/login	Authenticate and receive a JWT
Auth	GET /api/auth/me	Get the current authenticated user
Projects	GET /api/projects	List projects
Projects	POST /api/projects	Create a project
Projects	GET /api/projects/{id}	Get a project
Projects	PATCH /api/projects/{id}	Update a project
Projects	DELETE /api/projects/{id}	Delete a project
Files	GET /api/projects/{projectId}/files	List a project's file tree
Files	GET /api/projects/{projectId}/files/{*path}	Get a file's contents
Members	GET/POST/PATCH/DELETE /api/projects/{projectId}/members	Manage project collaborators & roles
Billing	GET /api/plans	List available subscription plans
Billing	GET /api/me/subscription	Get current user's subscription
Billing	POST /api/stripe/checkout	Create a Stripe Checkout session
Billing	POST /api/stripe/portal	Create a Stripe Billing Portal session
Usage	GET /api/usage/today	Get today's usage
Usage	GET /api/usage/limits	Get plan usage limits
Getting Started
Prerequisites
Java 21+
PostgreSQL (running locally or accessible via connection string)
Maven (or use the included wrapper — no local install needed)
Setup
Clone the repository
bash
   git clone https://github.com/shikhar1est/LovableProject.git
   cd LovableProject/demo
Configure your database and JWT secret in src/main/resources/application.yaml, e.g.:
yaml
   spring:
     application:
       name: lovable-clone
     datasource:
       url: jdbc:postgresql://localhost:5432/lovable_clone
       username: your_username
       password: your_password
     jpa:
       hibernate:
         ddl-auto: update

   jwt:
     secret: your-secret-key
     expiration-ms: 86400000
Run the application
bash
   ./mvnw spring-boot:run
The API will be available at http://localhost:8080.
Running Tests
bash
./mvnw test
