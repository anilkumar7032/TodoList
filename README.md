# TodoList
This is a full-stack To-Do List Application built with React.js (Frontend) and Spring Boot (Backend). It allows users to manage daily tasks efficiently through a simple and interactive interface.

⚙️ How It Works
The user enters a task in the input field.

A checkbox must be selected to mark whether the task is complete or not.

On clicking submit, the task (with its status) is sent to the Spring Boot backend and stored.

The app supports:

✅ Adding tasks

📥 Fetching the list of tasks

❌ Deleting tasks

All data is managed in the backend using REST APIs, and the React frontend consumes these APIs for task operations.
Backend
  ToDo_List/
│
├── .gitignore
├── README.md
├── pom.xml
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── example/
│   │   │           ├── ToDoListApplication.java
│   │   │           ├── config/
│   │   │           │   ├── WebClientConfig.java
│   │   │           │   └── WebConfig.java
│   │   │           ├── controller/
│   │   │           │   └── TodoController.java
│   │   │           ├── entity/
│   │   │           │   └── Todo.java
│   │   │           ├── repository/
│   │   │           │   └── TodoRepo.java
│   │   │           └── service/
│   │   │               ├── LlmService.java
│   │   │               ├── SlackService.java
│   │   │               └── TodoService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       ├── static/
│   │       └── templates/
└── target/ (excluded via .gitignore)

Frontend
todolist/
├── public/
│   ├── index.html
│   ├── manifest.json
│   └── robots.txt
│
├── src/
│   ├── component/
│   │   ├── AddTodoForm.js
│   │   └── style.css
│   ├── App.css
│   ├── App.js
│   ├── index.js
│   ├── reportWebVitals.js
│   └── setupTests.js
│
├── .gitignore
├── README.md
├── package.json
├── package-lock.json
└── node_modules/ (excluded via .gitignore)
This project is a To-Do List application built with:

Frontend: React.js

Backend: Spring Boot (Java)

The React app allows users to add and view to-dos. It communicates with the Spring Boot REST API to store and retrieve task data.

▶️ How to Run
1. Start the Spring Boot Backend
bash
Copy
Edit
cd ToDo_List
mvn spring-boot:run
Make sure it runs on http://localhost:8080.

2. Start the React Frontend
bash
Copy
Edit
cd todolist
npm install
npm start
The app will open in your browser at http://localhost:3000.
