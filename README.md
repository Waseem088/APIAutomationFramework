# API Test Automation Framework

## Overview
This repository contains a complete, scalable **API Test Automation Framework** built using **Java, Rest Assured, TestNG, and Maven**.  
The framework is designed with a strong focus on **clean architecture, maintainability, and scalability**, and follows the **Service Object Model (SOM)** pattern to organize API interactions into logical service layers.

It is fully integrated with **GitHub Actions** to support automated execution, scheduled runs, and test reporting as part of a CI/CD pipeline.

---

## Objectives
- Build a maintainable and extensible API automation framework
- Avoid hardcoded and brittle API test scripts
- Apply proven design patterns and clean architecture principles
- Enable seamless CI/CD integration
- Provide complete visibility through structured logging and reporting

---

## Features
- Service Object Model (SOM) architecture
- Centralized API abstraction using `BaseService`
- Request and response modeling using POJOs
- Builder pattern for complex request payloads
- Automatic JSON serialization and deserialization (Jackson)
- Dual-level logging:
  - Test execution logging via TestNG Listeners
  - HTTP request/response logging via Rest Assured Filters
- CI/CD integration with GitHub Actions
- Scheduled test execution using cron jobs

---

## Technology Stack
- **Java 11+**
- **Maven**
- **Rest Assured**
- **TestNG**
- **Jackson**
- **Log4j 2**
- **GitHub Actions**

---

## Project Structure
src/test/java  
└── com.api  
    ├── base        # BaseService and common configurations  
    ├── services    # API service classes (SOM)  
    ├── models  
    │   ├── request  # Request POJOs  
    │   └── response # Response POJOs  
    ├── test        # TestNG test classes  
    ├── listeners   # TestNG listeners  
    └── filters     # Rest Assured logging filters  

---

## Architecture Overview

The framework follows a **layered architecture** based on the **Service Object Model (SOM)**, ensuring clear separation of concerns, maintainability, and scalability. Each layer has a specific responsibility:

**Base Service Layer**  
- Acts as an abstraction layer over Rest Assured  
- Centralizes common request configuration (base URI, headers, filters)  
- Provides reusable methods for HTTP operations (GET, POST, PUT, DELETE)  
- Applies global request and response logging  
- Isolates Rest Assured dependency from higher layers  

**Service Layer (Service Object Model)**  
- Each service class represents an API controller  
- Each public method maps to a single API endpoint  
- Services extend `BaseService` to inherit common behavior  
- Encapsulates endpoint paths and service-specific logic  
- Returns Rest Assured `Response` objects for flexible assertions  

**Model Layer**  
- Consists of POJOs representing request and response payloads  
- Organized into `request` and `response` packages  
- Uses Jackson for automatic JSON serialization and deserialization  
- Implements the Builder pattern for creating complex request objects  

**Test Layer**  
- Contains TestNG test classes only  
- Tests focus solely on validation and assertions  
- API interaction logic is delegated to service classes  
- Changes in APIs require updates only in the service layer  

**Logging Layer**  
- **Test-Level Logging:** Implemented using TestNG `ITestListener` to capture test lifecycle events (start, pass, fail, skip)  
- **API-Level Logging:** Implemented using Rest Assured Filters to intercept and log all HTTP requests and responses (headers, payloads, status codes, and response bodies)  

**CI/CD Layer**  
- Implemented using GitHub Actions  
- Automates test execution on push and pull requests  
- Supports scheduled execution using cron jobs  
- Publishes test results and uploads logs as artifacts  
