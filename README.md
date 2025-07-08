# 🏥 Hospital Management System - Spring Boot Project

A full-featured Hospital Management System built using **Spring Boot**, **Spring Security (JWT-based)**, **Hibernate (JPA)**, and **Lombok**. The application supports secure role-based access for **Admin**, **Doctor**, **Nurse**, and **Receptionist** roles and provides modules for managing patients, appointments, vitals, and diagnosis records.

---

## 📁 Project Structure

```
src
├── config                     # Spring Security & JWT Filter Configurations
├── controller                 # All REST APIs grouped by roles
├── dto                        # Data Transfer Objects (e.g., AppointmentResponse)
├── model                      # JPA Entity classes
├── repository                 # Spring Data JPA Repositories
├── service                    # Business logic for each user role
└── HospitalManagementSystemApplication.java
```

---

## ⚙️ Technologies Used

- Java 17+
- Spring Boot
- Spring Security (JWT)
- Spring Data JPA (Hibernate)
- Lombok
- H2/MySQL Database
- Maven

---

## 🔐 Roles & Permissions

| Role        | Permissions                                                                 |
|-------------|------------------------------------------------------------------------------|
| ADMIN       | Register/update/delete doctors, nurses, receptionists.                      |
| RECEPTIONIST| Manage patients and appointments.                                           |
| NURSE       | View patients and set/update vitals.                                        |
| DOCTOR      | View appointments, write and view diagnosis.                                |

---

## 📌 Features

### 🔐 Authentication & Authorization
- JWT-based authentication
- Role-based access control using `@PreAuthorize`

### 👨‍⚕️ Admin Module
- Register/Update/Delete Doctors, Nurses, Receptionists
- Create user accounts with roles

### 👩‍⚕️ Nurse Module
- View all patients
- Add or update vitals for patients

### 🧑‍⚕️ Doctor Module
- View appointments
- Write and retrieve diagnosis

### 🧑 Receptionist Module
- Add patients
- Set and manage appointments
- View patient and appointment info

---



## 🔐 Login API & JWT Token

### POST `/hospitalmanagementsystem/api/login`

#### Request:
```json
{
  "username": "adminuser",
  "password": "adminpass"
}
```

#### Response:
```
<JWT TOKEN>
```

Use this token in `Authorization` header:
```
Authorization: Bearer <TOKEN>
```

---

## 🧪 Sample APIs

### Register User (Admin only)
```http
POST /hospitalmanagementsystem/api/register
```

### Set Appointment (Receptionist only)
```http
POST /hospitalmanagementsystem/api/setappointment
```

### Set Vitals (Nurse only)
```http
POST /hospitalmanagementsystem/api/setvitals
```

### Write Diagnosis (Doctor only)
```http
POST /hospitalmanagementsystem/api/writediagnosis
```

---

## 📌 Notes

- Passwords are encoded using `BCrypt`.
- User details are loaded using a custom `UserDetailsService`.
- JWT roles are extracted and converted into `GrantedAuthority`.

---

## 🙌 Author

**Karthik Karaka**  
Email: [karthikkaraka444@gmail.com](mailto:karthikkaraka444@gmail.com)

---

## 📄 License

This project is open-source and free to use.
