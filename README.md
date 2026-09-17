# Hospital Management System

## Project Overview

Hospital Management System is a Java-based console application designed to
manage basic hospital operations in an organized manner.

The system allows hospital staff to manage patient records, doctor records,
appointments and billing information. It also provides file-based data
storage so that important records can be retained when the application is
restarted.

## Features

### Patient Management
- Add new patient records
- Search patients using Patient ID
- View all patients
- Update patient information
- Delete patient records

### Doctor Management
- Add new doctor records
- Search doctors using Doctor ID
- View all doctors
- Update doctor information
- Delete doctor records
- Manage doctor availability

### Appointment Management
- Book appointments
- View all appointments
- Cancel appointments
- Complete appointments
- Check patient and doctor availability

### Billing Management
- Generate bills
- View all bills
- Search bills using Bill ID
- Calculate total bill amount
- Make payments
- Check payment status

### Data Storage
- Store patient, doctor and appointment records in text files
- Load saved records when the application starts
- Maintain data between application sessions

## Technologies / Tools Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- File Handling
- Exception Handling
- Java Scanner
- VS Code
- Git
- GitHub

## Java Concepts Used

- Classes and Objects
- Encapsulation
- Inheritance
- Method Overriding
- Polymorphism
- Constructors
- ArrayList Collections
- Custom Exception Handling
- File Input/Output
- CRUD Operations
- Input Validation

## Project Structure

```text
HospitalManagementSystem/
│
├── src/
│   ├── Main.java
│   ├── Patient.java
│   ├── Doctor.java
│   ├── Appointment.java
│   ├── Bill.java
│   ├── User.java
│   ├── Admin.java
│   ├── Hospital.java
│   ├── FileManager.java
│   └── HospitalException.java
│
├── data/
│   ├── patients.txt
│   ├── doctors.txt
│   └── appointments.txt
│
├── README.md
├── statement.md
└── .gitignore