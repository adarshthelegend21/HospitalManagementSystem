import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static Hospital hospital = new Hospital();

    public static void main(String[] args) {

        System.out.println("========================================");
        System.out.println("       HOSPITAL MANAGEMENT SYSTEM");
        System.out.println("========================================");

        mainMenu();
    }

    public static void mainMenu() {

        while (true) {

            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Patient Management");
            System.out.println("2. Doctor Management");
            System.out.println("3. Appointment Management");
            System.out.println("4. Billing Management");
            
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {

                case 1:
                    patientMenu();
                    break;

                case 2:
                    doctorMenu();
                    break;

                case 3:
                    appointmentMenu();
                    break;

                case 4:
                    billingMenu();
                    break;

                case 6:
                    System.out.println("\nThank you for using the Hospital Management System.");
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void patientMenu() {

        while (true) {

            System.out.println("\n------ PATIENT MANAGEMENT ------");
            System.out.println("1. Add Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. View All Patients");
            System.out.println("4. Update Patient");
            System.out.println("5. Delete Patient");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {

                case 1:
                    addPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    hospital.showAllPatients();
                    break;

                case 4:
                    updatePatient();
                    break;

                case 5:
                    deletePatient();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void addPatient() {

        System.out.print("Patient ID: ");
        int id = readInt();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = readInt();

        System.out.print("Gender: ");
        String gender = sc.nextLine();

        System.out.print("Disease: ");
        String disease = sc.nextLine();

        System.out.print("Phone: ");
        String phone = sc.nextLine();

        System.out.print("Address: ");
        String address = sc.nextLine();

        Patient patient = new Patient(
                id, name, age, gender, disease, phone, address
        );

        try {
            hospital.addPatient(patient);
        } catch (hospitalexception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void searchPatient() {

        System.out.print("Enter Patient ID: ");
        int id = readInt();

        Patient patient = hospital.findPatient(id);

        if (patient == null) {
            System.out.println("Patient not found.");
        } else {
            patient.showPatient();
        }
    }

    public static void updatePatient() {

        System.out.print("Enter Patient ID to update: ");
        int id = readInt();

        Patient patient = hospital.findPatient(id);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        patient.showPatient();

        System.out.println("\nWhat do you want to update?");
        System.out.println("1. Disease");
        System.out.println("2. Phone Number");
        System.out.println("3. Both");
        System.out.print("Enter your choice: ");

        int choice = readInt();

        String newDisease = "";
        String newPhone = "";

        if (choice == 1 || choice == 3) {
            System.out.print("New Disease: ");
            newDisease = sc.nextLine();
        }

        if (choice == 2 || choice == 3) {
            System.out.print("New Phone: ");
            newPhone = sc.nextLine();
        }

        try {
            hospital.updatePatient(id, newDisease, newPhone);
        } catch (hospitalexception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void deletePatient() {

        System.out.print("Enter Patient ID to delete: ");
        int id = readInt();

        Patient patient = hospital.findPatient(id);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        patient.showPatient();

        System.out.print("Are you sure you want to delete? (yes/no): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {

            try {
                hospital.deletePatient(id);
            } catch (hospitalexception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } else {
            System.out.println("Delete cancelled.");
        }
    }


    public static void doctorMenu() {

        while (true) {

            System.out.println("\n------ DOCTOR MANAGEMENT ------");
            System.out.println("1. Add Doctor");
            System.out.println("2. Search Doctor");
            System.out.println("3. View All Doctors");
            System.out.println("4. Update Doctor");
            System.out.println("5. Delete Doctor");
            System.out.println("6. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {

                case 1:
                    addDoctor();
                    break;

                case 2:
                    searchDoctor();
                    break;

                case 3:
                    hospital.showAllDoctors();
                    break;

                case 4:
                    updateDoctor();
                    break;

                case 5:
                    deleteDoctor();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void addDoctor() {

        System.out.print("Doctor ID: ");
        int id = readInt();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Specialization: ");
        String specialization = sc.nextLine();

        System.out.print("Phone: ");
        String phone = sc.nextLine();

        System.out.print("Room Number: ");
        String room = sc.nextLine();

        Doctor doctor = new Doctor(
                id, name, specialization, phone, room
        );

        try {
            hospital.addDoctor(doctor);
        } catch (hospitalexception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void searchDoctor() {

        System.out.print("Enter Doctor ID: ");
        int id = readInt();

        Doctor doctor = hospital.findDoctor(id);

        if (doctor == null) {
            System.out.println("Doctor not found.");
        } else {
            doctor.showDoctor();
        }
    }

    public static void updateDoctor() {

        System.out.print("Enter Doctor ID to update: ");
        int id = readInt();

        Doctor doctor = hospital.findDoctor(id);

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        doctor.showDoctor();

        System.out.println("\nWhat do you want to update?");
        System.out.println("1. Phone Number");
        System.out.println("2. Availability");
        System.out.println("3. Both");
        System.out.print("Enter your choice: ");

        int choice = readInt();

        String newPhone = "";
        int availChoice = 0;

        if (choice == 1 || choice == 3) {
            System.out.print("New Phone: ");
            newPhone = sc.nextLine();
        }

        if (choice == 2 || choice == 3) {
            System.out.println("1. Available");
            System.out.println("2. Not Available");
            System.out.print("Set availability: ");
            availChoice = readInt();
        }

        try {
            hospital.updateDoctor(id, newPhone, availChoice);
        } catch (hospitalexception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void deleteDoctor() {

        System.out.print("Enter Doctor ID to delete: ");
        int id = readInt();

        Doctor doctor = hospital.findDoctor(id);

        if (doctor == null) {
            System.out.println("Doctor not found.");
            return;
        }

        doctor.showDoctor();

        System.out.print("Are you sure you want to delete? (yes/no): ");
        String confirm = sc.nextLine();

        if (confirm.equalsIgnoreCase("yes")) {

            try {
                hospital.deleteDoctor(id);
            } catch (hospitalexception e) {
                System.out.println("Error: " + e.getMessage());
            }

        } else {
            System.out.println("Delete cancelled.");
        }
    }


    public static void appointmentMenu() {

        while (true) {

            System.out.println("\n----- APPOINTMENT MANAGEMENT -----");
            System.out.println("1. Book Appointment");
            System.out.println("2. View All Appointments");
            System.out.println("3. Cancel Appointment");
            System.out.println("4. Complete Appointment");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {

                case 1:
                    bookAppointment();
                    break;

                case 2:
                    hospital.showAllAppointments();
                    break;

                case 3:
                    cancelAppointment();
                    break;

                case 4:
                    completeAppointment();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void bookAppointment() {

        System.out.print("Appointment ID: ");
        int appointmentId = readInt();

        System.out.print("Patient ID: ");
        int patientId = readInt();

        System.out.print("Doctor ID: ");
        int doctorId = readInt();

        System.out.print("Date (DD/MM/YYYY): ");
        String date = sc.nextLine();

        System.out.print("Time (HH:MM): ");
        String time = sc.nextLine();

        System.out.print("Reason for visit: ");
        String reason = sc.nextLine();

        Appointment appointment = new Appointment(
                appointmentId,
                patientId,
                doctorId,
                date,
                time,
                reason
        );

        try {
            hospital.bookAppointment(appointment);
        } catch (hospitalexception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void cancelAppointment() {

        System.out.print("Enter Appointment ID to cancel: ");
        int id = readInt();

        try {
            hospital.cancelAppointment(id);
        } catch (hospitalexception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void completeAppointment() {

        System.out.print("Enter Appointment ID to mark as completed: ");
        int id = readInt();

        try {
            hospital.completeAppointment(id);
        } catch (hospitalexception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void billingMenu() {

        while (true) {

            System.out.println("\n------- BILLING MANAGEMENT -------");
            System.out.println("1. Generate Bill");
            System.out.println("2. View All Bills");
            System.out.println("3. Search Bill");
            System.out.println("4. Make Payment");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = readInt();

            switch (choice) {

                case 1:
                    generateBill();
                    break;

                case 2:
                    hospital.showAllBills();
                    break;

                case 3:
                    searchBill();
                    break;

                case 4:
                    makePayment();
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public static void generateBill() {

        System.out.print("Bill ID: ");
        int billId = readInt();

        System.out.print("Patient ID: ");
        int patientId = readInt();

        System.out.print("Consultation Fee: ");
        double consultation = readDouble();

        System.out.print("Medicine Charges: ");
        double medicine = readDouble();

        System.out.print("Room Charges: ");
        double room = readDouble();

        System.out.print("Test Charges: ");
        double tests = readDouble();

        Bill bill = new Bill(
                billId,
                patientId,
                consultation,
                medicine,
                room,
                tests
        );

        try {
            hospital.addBill(bill);
            bill.showBill();
        } catch (hospitalexception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static void searchBill() {

        System.out.print("Enter Bill ID: ");
        int id = readInt();

        Bill bill = hospital.findBill(id);

        if (bill == null) {
            System.out.println("Bill not found.");
        } else {
            bill.showBill();
        }
    }

    public static void makePayment() {

        System.out.print("Enter Bill ID: ");
        int billId = readInt();

        try {
            hospital.makePayment(billId);
        } catch (hospitalexception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }


    public static int readInt() {

        while (true) {

            try {
                return Integer.parseInt(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.print("Enter a valid number: ");
            }
        }
    }

    public static double readDouble() {

        while (true) {

            try {
                return Double.parseDouble(sc.nextLine());

            } catch (NumberFormatException e) {
                System.out.print("Enter a valid amount: ");
            }
        }
    }
}