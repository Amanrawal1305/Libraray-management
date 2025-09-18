📚 Digital Library Management System

A Spring Boot Backend Project for managing library operations such as books, students, and transactions.
This project is built with Spring Boot, MySQL, and JDBC, and follows RESTful API principles.

🚀 Features

📖 Book Management – Add, update, delete, and fetch books.

👨‍🎓 Student Management – Register students and manage their profiles.

🔄 Transactions – Issue and return books with proper validations.

🗄️ Database Integration – Persistent data storage using MySQL.

🛠️ REST APIs – Clean, structured, and easy-to-use endpoints.

⚡ Spring Boot Power – Fast development with Spring Boot Starter dependencies.

🏗️ Tech Stack

Java 17

Spring Boot 3.5.5

Spring Boot Starter Web

Spring Boot Starter JDBC

MySQL Database

Lombok (for cleaner code)

Maven (Dependency Management)

📂 Project Structure
digitalLibrary/
 ┣ src/main/java/com/aman/digitalLibrary
 ┃ ┣ controller/     # REST API Controllers
 ┃ ┣ service/        # Business Logic
 ┃ ┣ repository/     # Database Layer
 ┃ ┣ model/          # Entity Classes
 ┃ ┗ DigitalLibraryApplication.java
 ┣ src/main/resources
 ┃ ┣ application.properties  # DB Configurations
 ┗ pom.xml

⚙️ Setup & Installation
1️⃣ Clone the Repository
git clone https://github.com/Amanrawal1305/digitalLibrary.git
cd digitalLibrary

2️⃣ Configure Database (MySQL)

Create a database in MySQL:

CREATE DATABASE digital_library;


Update application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/digital_library
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

3️⃣ Build & Run
mvn clean install
mvn spring-boot:run


Server runs at: http://localhost:8080

📌 API Endpoints
Method	Endpoint	Description
POST	/books	Add new book
GET	/books	Get all books
GET	/books/{id}	Get book by ID
PUT	/books/{id}	Update book details
DELETE	/books/{id}	Delete book
POST	/students	Register new student
GET	/students	Get all students
POST	/transactions/issue	Issue a book
POST	/transactions/return	Return a book
🧑‍💻 Contribution

Contributions are always welcome!

Fork the repo

Create a new branch (feature-xyz)

Commit your changes

Submit a Pull Request 🎉

⭐ Show Your Support

If you like this project, please ⭐ star the repository on GitHub.
It motivates me to build more awesome projects! 🚀
