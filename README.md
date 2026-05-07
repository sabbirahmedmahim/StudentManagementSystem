# 🎓 Student Management System (Java GUI)

## 📖 Overview
The **Student Management System** is a comprehensive, role-based desktop application built using **Java** and **Java Swing**. It is designed to digitize and streamline academic operations, featuring dedicated portals for Administrators, Teachers, and Students. 

The application strictly adheres to **Object-Oriented Programming (OOP)** principles, ensuring a clean separation between data storage, user models, and graphical interfaces.

## ✨ Key Features & Role Access

### 🛡️ Administrator Portal
* **Dedicated Login:** Secure access via `AdminLoginWindow`.
* **System Dashboard:** Central control hub (`AdminDashboard`).
* **User Management:** Ability to seamlessly register new students (`AddStudentWindow`) and faculty members (`AddTeacherWindow`) into the system.

### 👨‍🏫 Teacher Portal
* **Dedicated Login:** Faculty access via `TeacherLoginWindow`.
* **Faculty Dashboard:** Portal for daily academic operations (`TeacherDashboard`).
* **Academic Tracking:** Interactive interfaces to record daily presence (`TakeAttendanceWindow`) and input academic grading (`GiveMarksWindow`).

### 🎓 Student Portal
* **Dedicated Login:** Secure student access via `StudentLoginWindow`.
* **Student Dashboard:** A personalized view (`StudentDashboard`) where students can securely view their academic standing and attendance records.

## 🏗️ System Architecture & File Structure
The project utilizes a multi-window GUI architecture backed by a central data storage mechanism.

```text
📦 src/
 ┣ 📂 Core Models & Data
 │ ┣ 📜 DataStore.java            # Centralized memory/database manager
 │ ┣ 📜 Student.java              # Student object blueprint
 │ ┗ 📜 Teacher.java              # Teacher object blueprint
 │
 ┣ 📂 Graphical User Interface (GUI)
 │ ┣ 📜 Main.java                 # System entry point
 │ ┣ 📜 LoginWindow.java          # Main portal selector
 │ ┣ 📜 AdminLoginWindow.java
 │ ┣ 📜 TeacherLoginWindow.java
 │ ┣ 📜 StudentLoginWindow.java
 │ ┣ 📜 AdminDashboard.java
 │ ┣ 📜 TeacherDashboard.java
 │ ┣ 📜 StudentDashboard.java
 │ ┣ 📜 AddStudentWindow.java     # Admin form
 │ ┣ 📜 AddTeacherWindow.java     # Admin form
 │ ┣ 📜 GiveMarksWindow.java      # Teacher form
 │ ┗ 📜 TakeAttendanceWindow.java # Teacher form
