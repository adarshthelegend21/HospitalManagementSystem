# Hospital Management System

A console-based Hospital Management System built using Core Java. This project manages patients, doctors, appointments, and billing through a simple menu-driven interface with file-based data storage.

## Features

- **Login System** — Admin authentication with username and password (3 attempts)
- **Patient Management** — Add, Search, View All, Update, and Delete patients
- **Doctor Management** — Add, Search, View All, Update, and Delete doctors
- **Appointment Management** — Book, View All, Cancel, and Complete appointments
- **Billing Management** — Generate Bill, View All Bills, Search Bill, and Make Payment
- **Data Persistence** — All data is saved in text files and loaded automatically on startup

## Project Structure

```
HospitalManagementSystem/
├── src/
│   ├── Main.java              - Entry point, menus, user input
│   ├── Hospital.java          - Core logic for all operations
│   ├── Patient.java           - Patient data class
│   ├── Doctor.java            - Doctor data class
│   ├── Appointment.java       - Appointment data class
│   ├── Bill.java              - Bill data class
│   ├── User.java              - Base class for login
│   ├── Admin.java             - Admin class (extends User)
│   ├── FileManager.java       - File read/write operations
│   └── hospitalexception.java - Custom exception class
├── data/
│   ├── patients.txt           - Patient records
│   ├── doctors.txt            - Doctor records
│   ├── appointments.txt       - Appointment records
│   └── bills.txt              - Bill records
└── README.md
```

## OOP Concepts Used

- **Inheritance** — Admin extends User
- **Encapsulation** — Private fields with getters/setters
- **Polymorphism** — Method overriding (showUser in Admin)
- **Abstraction** — Separate classes for each entity
- **Exception Handling** — Custom hospitalexception class
- **File Handling** — Read/Write data using FileWriter and BufferedReader
- **ArrayList** — Dynamic collections for storing records

## How to Compile and Run

```bash
# Step 1: Compile all Java files
javac -d out src/*.java

# Step 2: Run the program
java -cp out Main
```

## Default Login Credentials

| Username | Password |
|----------|----------|
| admin    | 1234     |

## Data Storage

All data is stored in CSV format inside the `data/` folder:
- `patients.txt` — PatientID, Name, Age, Gender, Disease, Phone, Address
- `doctors.txt` — DoctorID, Name, Specialization, Phone, RoomNumber, Available
- `appointments.txt` — AppointmentID, PatientID, DoctorID, Date, Time, Reason, Status
- `bills.txt` — BillID, PatientID, ConsultationFee, MedicineCharges, RoomCharges, TestCharges, Paid

## Built With

- Java (JDK 8 or above)
- No external libraries or frameworks
