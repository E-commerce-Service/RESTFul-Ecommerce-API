# 🛍️ E-commerce RESTful API

![Java](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.5-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/RabbitMQ-FF6600?style=for-the-badge&logo=rabbitmq&logoColor=white)

This repository hosts the core **Backend Service** for the E-commerce Microservices system. It provides a robust RESTful API handling products, users, shopping carts, orders, and authentication using a modern tech stack.

## 🚀 Key Features

* **Authentication & Security**:
    * Stateless authentication via **JWT** (RS256 signing).
    * Role-based access control (RBAC).
    * Custom Security Filters and OAuth2 Resource Server implementation.
* **Product Catalog**:
    * Complete CRUD for Products and Categories.
    * Image hosting integration with **Cloudinary**.
    * Review and Rating system.
* **Shopping Logic**:
    * Persistent Shopping Cart management.
    * Stock validation and management.
    * Checkout process with `PaymentRequest` integration.
* **Event-Driven Architecture**:
    * Asynchronous event handling using **RabbitMQ** (e.g., `CommentAddedEvent`, `PaymentConcludedEvent`).
    * Decoupled listeners for high scalability.
* **Database Management**:
    * Versioned database migrations using **Flyway**.
    * Optimized PostgreSQL schema.
* **Observability**:
    * Metrics exposure via **Spring Actuator** and **Prometheus**.
    * Health checks and detailed application info.

## 🛠️ Tech Stack

* **Language**: Java 21
* **Framework**: Spring Boot 3.2.5
* **Database**: PostgreSQL
* **Messaging**: RabbitMQ
* **Migration**: Flyway
* **Documentation**: OpenAPI (Swagger UI)
* **Build Tool**: Gradle
* **Containerization**: Docker & Docker Compose

## 🏗️ Architecture & Structure

The application follows a clean layered architecture:

```text
src/main/java/org/wesley/ecommerce/
├── application/    # Controllers, DTOs, Requests/Responses
├── config/         # Configuration classes (Security, RabbitMQ, Swagger, Cloudinary)
├── domain/         # Entities, Enums, Repositories, Custom Exceptions
├── service/        # Business Logic and Interfaces
└── utility/        # Helper classes
```

## ⚙️ Environment Configuration

To run the application, you must configure the environment variables. Create a `.env` file in the root directory based on `.env.example`:

```env
# Database
POSTGRES_HOST=db
POSTGRES_DB=ecommerce_db
POSTGRES_USER=postgres
POSTGRES_PASSWORD=your_password

# JWT
ISSUER=your_issuer_name

# Cloudinary (Image Hosting)
CLOUDINARY_NAME=your_cloud_name
CLOUDINARY_API_KEY=your_api_key
CLOUDINARY_API_SECRET=your_api_secret

# RabbitMQ
RABBITMQ_DEFAULT_USER=guest
RABBITMQ_DEFAULT_PASS=guest
SPRING_RABBITMQ_HOST=rabbitmq
SPRING_RABBITMQ_PORT=5672
```

> **Note:** Ensure you have the RSA keys (`private_key.pem` and `public_key.pem`) located in `src/main/resources/certs/` for JWT signing.

## 🐳 Running with Docker (Recommended)

The easiest way to run the API along with the Database and Exporters is using Docker Compose.

1.  **Build and Start:**
    ```bash
    docker-compose up -d --build
    ```

2.  **Access the services:**
    * **API**: `http://localhost:8080/ecommerce/api`
    * **Swagger UI**: `http://localhost:8080/ecommerce/api/docs/swagger-ui/index.html`
    * **Prometheus Metrics**: `http://localhost:8080/ecommerce/api/actuator/prometheus`

## 📦 Manual Installation (Gradle)

1.  **Prerequisites:**
    * JDK 21
    * PostgreSQL running locally
    * RabbitMQ running locally

2.  **Install Dependencies:**
    ```bash
    ./gradlew clean build -x test
    ```

3.  **Run the Application:**
    ```bash
    ./gradlew bootRun --args='--spring.profiles.active=dev'
    ```

## 📚 API Documentation

The API is fully documented using **OpenAPI/Swagger**. Once the application is running, you can access the interactive documentation at:

**URL:** `/ecommerce/api/docs`

## 🤝 Contributing

1.  Fork the repository.
2.  Create a feature branch (`git checkout -b feature/NewEndpoint`).
3.  Commit your changes (`git commit -m 'Add new endpoint for X'`).
4.  Push to the branch (`git push origin feature/NewEndpoint`).
5.  Open a Pull Request.

## 📄 License

This project is licensed under the MIT License.