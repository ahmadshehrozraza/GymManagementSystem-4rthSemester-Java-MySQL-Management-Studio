# Gym Management System (ERP Edition)

This is an enterprise-level desktop application developed during my 4th Semester. It is designed to manage the entire workflow of a gym business, including Member Management, Staff Payroll, Expense Tracking, and Financial Reporting.

## Project Evolution

This project is a major expansion and refactoring of my 2nd Semester Project.

While my previous project focused solely on basic data entry (CRUD) for members, this version introduces ERP (Enterprise Resource Planning) concepts. I shifted the focus from simple record-keeping to building a complete business management solution.

### Comparison: 2nd Semester vs 4th Semester

| Feature | 2nd Semester Version | 4th Semester Version (This Project) |
| :--- | :--- | :--- |
| **Scope** | Customer Data Only | Customer + Staff + Inventory + Finance |
| **Architecture** | Monolithic (All logic in one place) | Modular (Separated logic for Staff, Admin, Finance) |
| **Database** | Single Table Focus | Relational Schema (Linked payments, salaries, expenses) |
| **Reporting** | None | Automated Report Generation for printing |
| **Finance** | Fee Collection Only | Profit & Loss Analysis (Income vs. Expenses) |

You can view the initial version here: https://github.com/ahmadshehrozraza/Gym-Management-System-2nd-semester-Java-SQL-Workbench)

## Key Modules

### 1. Member Management (Extended)
- Complete lifecycle management: Registration, Plan selection, and Body stats.
- Search Engine: Filter members by ID, Name, or Phone Number.
- Attendance Tracking and Fee Status monitoring.

### 2. Staff & Payroll Management
- Employee Records: Manage Trainers, Cleaners, and Receptionists.
- Salary Processing: Track salary status (Paid/Pending) and generate slips.
- Role-Based Access: Managed different designations within the database.

### 3. Finance & Accounts
- Expense Tracker: Log utility bills (Electricity, Water) and equipment maintenance costs.
- Revenue Tracking: Real-time calculation of total fees collected.
- Financial Health: View simple Profit/Loss summaries.

### 4. Reporting System
- The system can generate printable reports for:
  - Monthly Fee Defaulters.
  - Staff Salary Sheets.
  - Daily Expense Reports.

## Technical Architecture

- **Modular Design:** Unlike my first project, I separated the logic into different packages (`C_Management`, `S_Management`, `Billings`) to make the code maintainable.
- **Centralized Database Connection:** Implemented a Singleton-style `DBConnection.java` class to handle database sessions efficiently, replacing the repetitive connection code used in the previous version.
- **External Libraries:** Used `jcalendar` for date handling and `javax.mail` for email notifications.

## Database Setup

To run this project, you need to set up the extended database schema in MySQL.

1. Create a database named: gym_management_studio
2. Run the following SQL commands to create the necessary tables:

```sql
-- Table for Staff
CREATE TABLE staff_data (
    ID INT PRIMARY KEY,
    Name VARCHAR(50),
    Designation VARCHAR(30),
    Salary DOUBLE,
    Contact VARCHAR(20),
    JoinDate DATE
);

-- Table for Expenses
CREATE TABLE expenses (
    Exp_ID INT PRIMARY KEY AUTO_INCREMENT,
    Category VARCHAR(50),
    Amount DOUBLE,
    Date DATE
);

-- Note: The system also requires the 'customers_data' and 'admin_account' tables from the previous version.
Configuration
Before running the application, update the database credentials in src/DBConnection.java:

Java
public static Connection getCon() {
    // Replace "root" and "password" with your local MySQL credentials
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/gym_management_studio", "root", "YOUR_PASSWORD");
    return con;
}

screenshots:
![Uploading GMS (1).jpeg…]()
![Uploading GMS (2).jpeg…]()
![GMS (3)](https://github.com/user-attachments/assets/d83bb89f-3b78-4075-b2fd-0b17e3aeab23)
![GMS (4)](https://github.com/user-attachments/assets/8784b132-c832-458f-8e72-8d7dee476ccf)
![GMS (6)](https://github.com/user-attachments/assets/0a06ef15-2cc2-4ce5-aa85-ab3b02a1fcd4)
![GMS (7)](https://github.com/user-attachments/assets/24c82395-9966-411e-8dd6-6ae5ed53f558)
![GMS (7)](https://github.com/user-attachments/assets/287bf548-fd8a-4a02-ace2-9a8c2b36fab5)
![GMS (8)](https://github.com/user-attachments/assets/e64003a7-4191-42b7-b45f-603ceda82eb2)
![GMS (9)](https://github.com/user-attachments/assets/8bebf4e6-c7d6-4d49-b0d0-e349486466a2)
![GMS (9)](https://github.com/user-attachments/assets/818391c6-34fd-4587-b74c-86a24135bb10)
![GMS (9)](https://github.com/user-attachments/assets/d4384e5f-8a59-409a-8849-af4239428de2)
![GMS (10)](https://github.com/user-attachments/assets/d0db9ec5-9ffb-4420-9dc7-46371a8eda64)
![GMS (11)](https://github.com/user-attachments/assets/41f280f4-89a1-4d30-9817-a81df2e0a73d)
![GMS (12)](https://github.com/user-attachments/assets/9d61cda0-6354-4d9c-908b-9a859b453fdf)
![GMS (13)](https://github.com/user-attachments/assets/80de8159-610a-4200-b660-ac320b16b74c)
![GMS (14)](https://github.com/user-attachments/assets/b7dd0fb3-d86b-4a21-860b-6abfe49a5ea3)
![GMS (15)](https://github.com/user-attachments/assets/fbfb550d-3ea4-4398-b8e5-7718597cf2ac)
![GMS (16)](https://github.com/user-attachments/assets/0abc00bf-5edd-4f00-8e64-078a254bdd05)
![GMS (17)](https://github.com/user-attachments/assets/6440e612-b5af-49aa-8873-64c3dd0fcfa2)


Tech Stack
Java (JDK 11+)

Java Swing (Frontend)

MySQL (Backend)

NetBeans IDE

Developer
Ahmad Shehroz Raza
Software Engineering Student | University of Gujrat
