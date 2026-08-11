# Employee Leave Management System — Backend

A **Spring Boot REST API** backend for the Employee Leave Management System. The backend provides APIs for employee management, employee login and profile operations, and complete leave-request management.

The application uses **Java 21, Spring Boot, Spring Data JPA, Hibernate, and MySQL**.

---

## 🚀 Live API

**Backend API:**
https://employee-leave-management-backend-production.up.railway.app

---

## 📌 Features

### 👨‍💼 Employee Management

* Get all employees
* Add employee
* Get employee by ID
* Update employee
* Delete employee
* Employee login
* Employee profile
* Change password
* Get employee count
* Get department count

### 🏖️ Leave Management

* Apply for leave
* Get all leave requests
* Get employee leave history
* Approve leave requests
* Reject leave requests
* Get pending leave count
* Get employee pending leave count
* Get employee approved leave count
* Automatically update leave balance when a leave is approved

---

# 🛠️ Tech Stack

| Technology      | Purpose                         |
| --------------- | ------------------------------- |
| Java 21         | Backend programming language    |
| Spring Boot     | REST API development            |
| Spring Data JPA | Database persistence            |
| Hibernate       | ORM                             |
| MySQL           | Relational database             |
| Maven           | Build and dependency management |
| Lombok          | Reducing boilerplate code       |
| REST APIs       | Frontend-backend communication  |

---

# 🏗️ Backend Architecture

```text
                   ┌─────────────────────┐
                   │   React Frontend    │
                   └──────────┬──────────┘
                              │
                              │ HTTP / REST
                              ▼
                   ┌─────────────────────┐
                   │   Spring Boot API   │
                   │                     │
                   │ Employee APIs       │
                   │ Leave APIs          │
                   └──────────┬──────────┘
                              │
                              │ JPA / Hibernate
                              ▼
                   ┌─────────────────────┐
                   │       MySQL         │
                   │                     │
                   │ Employee Data       │
                   │ Leave Data          │
                   └─────────────────────┘
```

---

# 🔌 API Endpoints

## Employee APIs

| Method   | Endpoint                                  | Description          |
| -------- | ----------------------------------------- | -------------------- |
| `GET`    | `/employees`                              | Get all employees    |
| `POST`   | `/employees`                              | Add employee         |
| `POST`   | `/employees/login`                        | Employee login       |
| `GET`    | `/employees/{id}`                         | Get employee by ID   |
| `PUT`    | `/employees/{id}`                         | Update employee      |
| `DELETE` | `/employees/{id}`                         | Delete employee      |
| `GET`    | `/employees/count`                        | Get employee count   |
| `GET`    | `/employees/profile/{employeeId}`         | Get employee profile |
| `PUT`    | `/employees/change-password/{employeeId}` | Change password      |
| `GET`    | `/employees/departments/count`            | Get department count |

---

## Leave APIs

| Method | Endpoint                       | Description                  |
| ------ | ------------------------------ | ---------------------------- |
| `POST` | `/leave/apply`                 | Apply for leave              |
| `GET`  | `/leave`                       | Get all leave requests       |
| `GET`  | `/leave/{employeeId}`          | Get employee leave history   |
| `PUT`  | `/leave/approve/{id}`          | Approve leave                |
| `PUT`  | `/leave/reject/{id}`           | Reject leave                 |
| `GET`  | `/leave/pending-count`         | Get pending leave count      |
| `GET`  | `/leave/pending/{employeeId}`  | Get employee pending leaves  |
| `GET`  | `/leave/approved/{employeeId}` | Get employee approved leaves |

The complete endpoint list is documented in the original backend README.

---

# 🗄️ Database

The application uses **MySQL** with **Spring Data JPA** for employee and leave data management.

```text
MySQL
  │
  ├── Employee Data
  │
  └── Leave Data
```

---

# 🔄 Leave Management Workflow

```text
Employee
    │
    ▼
Apply for Leave
    │
    ▼
Leave Request
    │
    ▼
HR Reviews Request
    │
    ├───────────────┐
    │               │
    ▼               ▼
 Approve          Reject
    │               │
    ▼               ▼
Leave Balance     Request
Updated           Rejected
```

When a leave request is approved, the employee's leave balance is automatically updated.

---

# 🌐 CORS

The backend is configured to allow requests from the deployed frontend and local development environment.

---

# 💻 Run Locally

## Prerequisites

Make sure you have:

* Java 21
* Maven
* MySQL

---

## 1. Clone the Repository

```bash
git clone https://github.com/dHarshasri1411/employee-leave-management-backend.git
```

---

## 2. Navigate to the Project

```bash
cd employee-leave-management-backend
```

---

## 3. Configure MySQL

Make sure MySQL is running and configure the database connection in the application's configuration.

---

## 4. Run the Application

```bash
mvn spring-boot:run
```

The backend will run at:

```text
http://localhost:8080
```

These local setup steps and the default application port are specified in the original backend README.

---

# 🚀 Deployment

The backend is deployed on **Railway**.

| Component | Platform |
| --------- | -------- |
| Backend   | Railway  |
| Database  | MySQL    |
| Frontend  | Vercel   |

---

# 🔗 Frontend

The backend is consumed by the React frontend of the Employee Leave Management System.

**Frontend Repository:**
https://github.com/dHarshasri1411/employee-leave-management-frontend

**Live Frontend:**
https://employee-leave-management-frontend-nine.vercel.app

---

# 📁 Project Responsibilities

The backend is responsible for:

* Employee CRUD operations
* Employee login
* Employee profile management
* Password change functionality
* Employee statistics
* Department statistics
* Leave application
* Leave history
* Leave approval
* Leave rejection
* Leave statistics
* Leave balance updates

---

# 📊 API Base URL

### Production

```text
https://employee-leave-management-backend-production.up.railway.app
```

### Local

```text
http://localhost:8080
```

---

# 📚 Repository

**GitHub:**
https://github.com/dHarshasri1411/employee-leave-management-backend

---

# 👨‍💻 Author

**Harsha sri Dandeboina**

Computer Science & Engineering

---

## ⭐ Support

If you find this project useful, consider giving the repository a ⭐ on GitHub.
