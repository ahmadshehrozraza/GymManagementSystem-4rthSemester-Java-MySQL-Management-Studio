# Scope of the Project
**Gym Management System**

## 1. Introduction
The scope of the Gym Management System project defines the boundaries, functionalities, and objectives of the system being developed. This project focuses on designing and implementing a Desktop-based Gym Management System using **Java (Swing)** and **Microsoft SQL Server**, following a modular architecture. The system is intended to help gym owners and managers efficiently handle daily operations, including member management, staff administration, fee collection, and expense tracking in an organized and secure manner.

The scope outlines what the system will do, what it will not do, and the extent to which administrators can interact with the system. It also clarifies the core features, system limitations, and target users.

## 2. Project Objectives
The primary objective of this project is to develop a reliable, database-driven desktop application that allows authorized administrators to manage gym resources and members effectively. The system aims to:
- Provide a structured way to digitize gym records (Members and Staff).
- Ensure financial transparency by tracking fees, salaries, and gym expenses.
- Streamline the check-in and billing process.
- Offer reporting mechanisms to view business performance.
- Demonstrate practical implementation of Java Swing (GUI), JDBC, and SQL Database management.

## 3. In-Scope Features
The following functionalities are included within the scope of this project:

### 3.1 User/Admin Management
- **Authentication**: Secure login validation for administrators.
- **Account Recovery**: Capabilities to reset or recover passwords via "Forgot Password" functionality.
- **Admin Profile**: Management of admin credentials (username, password, email).

### 3.2 Member (Customer) Management
- **Registration**: Adding new members with detailed personal info (Name, Age, Gender, Contact, Address).
- **Membership Tracking**: Monitoring gym timing quotas and join dates.
- **Update/Delete**: Modifying member details or removing inactive members from the system.
- **Searching**: Finding members quickly by their CNIC or unique identifiers.

### 3.3 Staff & Trainer Management
- **Staff Records**: Managing details for Trainers, Cleaners, and Managers.
- **Role Assignment**: Differentiating handling between various staff types.
- **Employment History**: Tracking joining dates and personal details.

### 3.4 Financial Management
- **Fee Collection**: Recording monthly membership fee payments and updating payment status (Paid/Unpaid).
- **Salary Disbursement**: Managing and recording salary payments to staff.
- **Expense Tracking**: Logging daily operational expenses (Electricity, Maintenance, Equipment).
- **Status Updates**: Automated or manual resetting of fee statuses (e.g., resetting to "Not Paid" at the start of the month).

### 3.5 Reporting & Analytics
- **Member Reports**: Generating lists of active customers.
- **Financial Reports**: Viewing income (fees) vs. expenses to analyze profit/loss.
- **Staff Reports**: Listing active employees and their payment history.

### 3.6 Communication
- **Email Integration**: Functionality to send email notifications (e.g., welcome emails, payment receipts) to members/staff using SMTP integration.

## 4. Technical Scope

### 4.1 Technology Stack
- **Programming Language**: Java
- **User Interface**: Java Swing (GUI Frames, Forms)
- **Database**: Microsoft SQL Server
- **Connectivity**: JDBC (Java Database Connectivity)
- **IDE**: NetBeans

### 4.2 Database Scope
- Relational database design to store data for `Customers`, `Staff`, `Payments`, `Expenses`, and `Admin`.
- Use of Primary Keys (CNIC) to ensure unique records.
- Stored Procedures or SQL Queries for CRUD operations.

### 4.3 Error Handling & Validation
- **Input Validation**: Ensuring correct data types (e.g., numeric fees, valid dates).
- **Exception Handling**: Managing SQL errors and connection timeouts gracefully.

## 5. Out-of-Scope Features
The following features are *not* included in the current scope of this project:
- **Mobile Application**: No Android/iOS companion app.
- **Member Portal**: Members cannot log in themselves; it is an admin-facing tool only.
- **Online Payment Gateway**: Real-time credit card processing is not integrated (cash/manual entry assumed).
- **Biometric Integration**: No hardware integration for fingerprint attendance.
- **Cloud Synchronization**: The database is local to the machine/network and does not sync to a cloud server automatically.

## 6. Target Users
The system is designed for:
- **Gym Owners**: To oversee the entire business.
- **Gym Managers/Receptionists**: To perform daily data entry and member handling.

## 7. Limitations
- **Single Location**: Designed primarily for a single gym branch.
- **Local Dependency**: Requires SQL Server to be running on the local network/host.
- **Manual Data Entry**: Reliance on administrative staff to input data accurately.

## 8. Conclusion
The scope of the Gym Management System project is focused on delivering a robust, user-friendly, and database-backed management solution using Java and SQL Server. The system successfully digitizes manual gym registers, helping owners save time and reduce errors in financial tracking. Within its defined scope, the project fulfills its objective of providing a practical tool for small to medium-sized fitness centers.
