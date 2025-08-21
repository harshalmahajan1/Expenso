📊 Expenso – Expense Tracker Application

Expenso is a Full Stack Expense Tracker Application built with React.js (frontend) and Spring Boot (backend), designed to help users manage daily expenses efficiently.

🚀 Tech Stack
Frontend

⚛️ React.js

🎨 CSS 

Backend

☕ Java + Spring Boot

🛠️ Maven

🌐 REST APIs

Database

🐬 MySQL

✨ Features

➕ Add expenses

📂 Categorize expenses

📊 View expense history

🔐 Secure backend with Spring Boot REST API

💾 Persistent storage using MySQL

📂 Project Structure
Expenso/
├── frontend/expenso/       # React frontend
│   ├── src/
│   ├── public/
│   └── package.json
│
├── backend/expensetracker/ # Spring Boot backend
│   ├── src/main/java/
│   ├── src/main/resources/
│   └── pom.xml

⚡ Getting Started
1️⃣ Clone the repository
git clone https://github.com/<your-username>/Expenso.git
cd Expenso

2️⃣ Setup Backend (Spring Boot)
cd backend/expensetracker
mvn spring-boot:run


Backend runs at 👉 http://localhost:8080

3️⃣ Setup Frontend (React)
cd frontend/expenso
npm install
npm start


Frontend runs at 👉 http://localhost:3000

🔒 Environment Variables

In application.properties (backend), configure your database:

spring.datasource.url=jdbc:mysql://localhost:3306/expenso
spring.datasource.username=your_username
spring.datasource.password=your_password


🤝 Contributing

Pull requests are welcome. For major changes, please open an issue first to discuss what you’d like to change.

📜 License

This project is licensed under the MIT License.
