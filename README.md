# **Personal Project — Full-Stack Web Banking Application**

A full-stack personal project website to showcase my knowledge about how two application communicate with each other.
This full-stack personal project showcases my technical skills, professional experience, and background with modern technology

The application consits of frontend and a dedicated backend using Java SpringBoot.
The application performs **CRUD operations**, inspired by day-to-day task of a **banking system**.

🌐 Live Demo:  
💻 Frontend: https://github.com/marcusmeki26/banking-app-ui  
⚙️ Backend: https://github.com/marcusmeki26/banking-app

## **Overview**
This project is the backend of my personal project **Banking Applcication**  
A RESTful backend application built with **Java and Spring Boot** that provides **CRUD (Create, Read, Update, Delete) functionality** for a **banking system**.  
This project was created as a personal project to practice and demonstrate backend development concepts, including REST API design, Spring Boot, database integration, layered architecture, and CRUD operations.

## **Features**  
- Create new accounts
- Retrieve accounts created
- Perform deposits
- Perform withdrawal
- Perform transfering of funds
- Retrieve transaction history
- RESTful API architecture
- Controller layer validation
- Exception handling
- Logging implementation using Logback + SLF4J

## **Tech Stack**
- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Mapstruct
- MySQL
- SLF4J
- Logback
- Maven

## **Layers**  
### **Controller**  
Handles HTTP requests and exposes the REST API endpoints.

### **Service**  
Contains the application's business logic and communicates between the controllers and repositories.

### ***Repository***  
Handles database operations using Spring Data JPA.

### **Model / Entity**  
Represents the data stored in the database, such as bank accounts and customers.

### **DTO**  
Used to control the data exposed through the API and separate API requests/responses from database entities.

### **Exception**  
Contains custom exceptions and global exception handling for errors such as resources not being found or invalid requests.

## **API Endpoints**
The following endpoints provide CRUD functionality for bank accounts.
### **Account**  
```
Method    Endpoint              Description    
POST      /v1/account           Create a new bank account   
POST      /v1/account/deposit   Performs deposit of a specific account  
POST      /v1/account/withdraw  Performs withdraw of a specific account  
POST      /v1/account/transfer  Performs transfering of funds from source to destination account   
GET       /v1/account           Retrieves all bank accounts      
GET       /v1/{accountNumber}   Retrieves balance of a specifc account
```
### **Transaction**  
```
Method    Endpoint              Description    
GET       /v1/transaction       Retrieves all transaction of a specific account
```

## **Getting Started**
**Prerequisites**
Make sure you have the following installed:  
Java 21  
Maven  
Git  
A supported relational database such as MySQL  

## **Installation**
1. Clone the Repository
git clone https://github.com/marcusmeki26/banking-app.git
cd banking-app
2. Configure the Database
Update the database configuration in:

src/main/resources/application.properties  
Example:  
### **JPA**    
spring.datasource.url=jdbc:mysql://localhost:9090/banking_app  
spring.datasource.username=your-username   
spring.datasource.password=your-password  
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver  
spring.jpa.show-sql=true  
spring.jpa.hibernate.ddl-auto=update  
### **SLF4J API + LOGBACK**  
logging.level.root=INFO  
logging.file.name=logs/app.log  

3. Build the Application   
Using Maven:  
./mvnw clean install   
On Windows:   
mvnw.cmd clean install   
 
4. Run the Application   
./mvnw spring-boot:run   
On Windows:  
mvnw.cmd spring-boot:run    
The application should start on:    
http://localhost:8080   

--- 
## **Author**
### **Daniel Marcus Felixmeña**

GitHub: [Github Profile](https://github.com/marcusmeki26)  
Email: felixmenamarcus@gmail.com  
Portfolio: [Personal Portfolio Website](https://marcusmeki26.github.io/)  