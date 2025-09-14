# Electricity API

## 📋 Overview

A straightforward REST API built with Spring Boot that returns electricity pricing information including daily rates, night rates, and various transmission fees. Designed for easy integration with energy pricing applications.
## 🛠️ Tech Stack

### Core Technologies
![Java](https://img.shields.io/badge/Java-21-orange?style=flat-square&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.5-brightgreen?style=flat-square&logo=springboot&logoColor=white)
![Spring MVC](https://img.shields.io/badge/Spring%20MVC-Framework-brightgreen?style=flat-square&logo=spring&logoColor=white)

### Build & Testing
![Gradle](https://img.shields.io/badge/Gradle-Build%20Tool-02303A?style=flat-square&logo=gradle&logoColor=white)
![JUnit](https://img.shields.io/badge/JUnit-Testing-25A162?style=flat-square&logo=junit5&logoColor=white)
![Mockito](https://img.shields.io/badge/Mockito-5.2.0-yellow?style=flat-square&logo=mockito&logoColor=white)

### Quality & Deployment
![JaCoCo](https://img.shields.io/badge/JaCoCo-Coverage-red?style=flat-square&logo=java&logoColor=white)
![SonarQube](https://img.shields.io/badge/SonarQube-Quality-4E9BCD?style=flat-square&logo=sonarqube&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Containerization-2496ED?style=flat-square&logo=docker&logoColor=white)
![Heroku](https://img.shields.io/badge/Heroku-Deployment-430098?style=flat-square&logo=heroku&logoColor=white)

## 🚀 Getting Started

### Installation

1. **Clone the repository**
   ```bash
   git clone https://github.com/mark79-github/Electricity-API.git
   cd Electricity-API
   ```

2. **Build the project**
   ```bash
   ./gradlew build
   ```

3. **Run the application**
   ```bash
   ./gradlew bootRun
   ```

### Using Docker

1. **Build the Docker image**
   ```bash
   docker build -t electricity-api .
   ```

2. **Run the container**
   ```bash
   docker run -p 8080:8080 electricity-api
   ```

The API will be available at `http://localhost:8080`
   