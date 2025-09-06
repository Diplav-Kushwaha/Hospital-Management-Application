🏥 Hospital Management Application
A Spring Boot based Hospital Management System designed to streamline hospital operations by managing Admins, Doctors, Patients, and Receptionists. This project follows a clean MVC architecture (Controller – Service – Repository – Entity) for scalability and maintainability.

📌 Features
👨‍⚕️ Admin Management – Manage doctors, patients, and receptionists.
🧑‍⚕️ Doctor Module – View patients, manage appointments.
🧑‍🤝‍🧑 Patient Module – Register, book appointments.
💁 Receptionist Module – Manage patient entries, schedule appointments, and assist with hospital operations.
🗄️ Database Integration with JPA and Hibernate.

⚙️ Tech Stack
Backend: Java, Spring Boot, Spring MVC, Spring Data JPA
Database: MySQL 
Build Tool: Maven / Gradle
Frontend: HTML, Thymeleaf / Bootstrap
Version Control: Git & GitHub

hospital-management/
│
├── controller/
│   ├── AdminController.java
│   ├── DoctorController.java
│   ├── PatientController.java
│   └── ReceptionistController.java
│
├── entity/
│   ├── Admin.java
│   ├── Doctor.java
│   ├── Patient.java
│   └── Receptionist.java
│
├── service/
│   ├── AdminService.java
│   ├── DoctorService.java
│   ├── PatientService.java
│   └── ReceptionistService.java
│
├── repository/
│   ├── AdminRepository.java
│   ├── DoctorRepository.java
│   ├── PatientRepository.java
│   └── ReceptionistRepository.java
│
└── HospitalManagementApplication.java
