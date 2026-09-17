import java.util.ArrayList;

public class Hospital {

    private ArrayList<Patient> patients;
    private ArrayList<Doctor> doctors;
    private ArrayList<Appointment> appointments;
    private ArrayList<Bill> bills;

    public Hospital() {

        // load saved data from files when program starts
        patients = FileManager.loadPatients();
        doctors = FileManager.loadDoctors();
        appointments = FileManager.loadAppointments();
        bills = FileManager.loadBills();

        System.out.println("Data loaded successfully.");
        System.out.println("Patients: " + patients.size() +
                " | Doctors: " + doctors.size() +
                " | Appointments: " + appointments.size() +
                " | Bills: " + bills.size());
    }

    // ============ PATIENT MANAGEMENT ============

    public void addPatient(Patient patient) throws hospitalexception {

        if (findPatient(patient.getPatientId()) != null) {
            throw new hospitalexception("Patient ID " +
                    patient.getPatientId() + " already exists.");
        }

        patients.add(patient);
        FileManager.savePatient(patient);
        System.out.println("Patient added successfully.");
    }

    public Patient findPatient(int patientId) {
        for (Patient patient : patients) {
            if (patient.getPatientId() == patientId) {
                return patient;
            }
        }
        return null;
    }

    public void updatePatient(int patientId, String newDisease,
                              String newPhone) throws hospitalexception {

        Patient patient = findPatient(patientId);

        if (patient == null) {
            throw new hospitalexception("Patient with ID " +
                    patientId + " not found.");
        }

        if (newDisease != null && !newDisease.isEmpty()) {
            patient.updateDisease(newDisease);
        }

        if (newPhone != null && !newPhone.isEmpty()) {
            patient.updatePhone(newPhone);
        }

        FileManager.rewritePatients(patients);
        System.out.println("Patient updated successfully.");
    }

    public void deletePatient(int patientId) throws hospitalexception {

        Patient patient = findPatient(patientId);

        if (patient == null) {
            throw new hospitalexception("Patient with ID " +
                    patientId + " not found.");
        }

        patients.remove(patient);
        FileManager.rewritePatients(patients);
        System.out.println("Patient deleted successfully.");
    }

    public void showAllPatients() {
        if (patients.isEmpty()) {
            System.out.println("No patient records found.");
            return;
        }

        System.out.println("\n======= ALL PATIENTS (" +
                patients.size() + " records) =======");

        for (Patient patient : patients) {
            patient.showPatient();
        }
    }

    

    public void addDoctor(Doctor doctor) throws hospitalexception {

        if (findDoctor(doctor.getDoctorId()) != null) {
            throw new hospitalexception("Doctor ID " +
                    doctor.getDoctorId() + " already exists.");
        }

        doctors.add(doctor);
        FileManager.saveDoctor(doctor);
        System.out.println("Doctor added successfully.");
    }

    public Doctor findDoctor(int doctorId) {
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorId() == doctorId) {
                return doctor;
            }
        }
        return null;
    }

    public void updateDoctor(int doctorId, String newPhone,
                             int availChoice) throws hospitalexception {

        Doctor doctor = findDoctor(doctorId);

        if (doctor == null) {
            throw new hospitalexception("Doctor with ID " +
                    doctorId + " not found.");
        }

        if (newPhone != null && !newPhone.isEmpty()) {
            doctor.updatePhone(newPhone);
        }

        // 1 = Available, 2 = Not Available, 0 = no change
        if (availChoice == 1) {
            doctor.setAvailability(true);
        } else if (availChoice == 2) {
            doctor.setAvailability(false);
        }

        FileManager.rewriteDoctors(doctors);
        System.out.println("Doctor updated successfully.");
    }

    public void deleteDoctor(int doctorId) throws hospitalexception {

        Doctor doctor = findDoctor(doctorId);

        if (doctor == null) {
            throw new hospitalexception("Doctor with ID " +
                    doctorId + " not found.");
        }

        doctors.remove(doctor);
        FileManager.rewriteDoctors(doctors);
        System.out.println("Doctor deleted successfully.");
    }

    public void showAllDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("No doctor records found.");
            return;
        }

        System.out.println("\n======= ALL DOCTORS (" +
                doctors.size() + " records) =======");

        for (Doctor doctor : doctors) {
            doctor.showDoctor();
        }
    }

    public void bookAppointment(Appointment appointment)
            throws hospitalexception {

        Patient patient = findPatient(appointment.getPatientId());
        Doctor doctor = findDoctor(appointment.getDoctorId());

        if (patient == null) {
            throw new hospitalexception("Patient with ID " +
                    appointment.getPatientId() + " not found.");
        }

        if (doctor == null) {
            throw new hospitalexception("Doctor with ID " +
                    appointment.getDoctorId() + " not found.");
        }

        if (!doctor.isAvailable()) {
            throw new hospitalexception("Doctor " + doctor.getName() +
                    " is currently unavailable.");
        }

        appointments.add(appointment);
        doctor.setAvailability(false);

        FileManager.saveAppointment(appointment);
        FileManager.rewriteDoctors(doctors);

        System.out.println("Appointment booked successfully.");
        System.out.println("Patient: " + patient.getName() +
                " | Doctor: " + doctor.getName());
    }

    public void cancelAppointment(int appointmentId)
            throws hospitalexception {

        Appointment appointment = findAppointment(appointmentId);

        if (appointment == null) {
            throw new hospitalexception("Appointment with ID " +
                    appointmentId + " not found.");
        }

        if (appointment.getStatus().equals("Cancelled")) {
            throw new hospitalexception("Appointment is already cancelled.");
        }

        if (appointment.getStatus().equals("Completed")) {
            throw new hospitalexception("Cannot cancel a completed appointment.");
        }

        appointment.cancelAppointment();

        // make the doctor available again
        Doctor doctor = findDoctor(appointment.getDoctorId());
        if (doctor != null) {
            doctor.setAvailability(true);
            FileManager.rewriteDoctors(doctors);
        }

        FileManager.rewriteAppointments(appointments);
        System.out.println("Appointment cancelled successfully.");
    }

    public void completeAppointment(int appointmentId)
            throws hospitalexception {

        Appointment appointment = findAppointment(appointmentId);

        if (appointment == null) {
            throw new hospitalexception("Appointment with ID " +
                    appointmentId + " not found.");
        }

        if (appointment.getStatus().equals("Completed")) {
            throw new hospitalexception("Appointment is already completed.");
        }

        if (appointment.getStatus().equals("Cancelled")) {
            throw new hospitalexception("Cannot complete a cancelled appointment.");
        }

        appointment.completeAppointment();

        // make the doctor available again after completing
        Doctor doctor = findDoctor(appointment.getDoctorId());
        if (doctor != null) {
            doctor.setAvailability(true);
            FileManager.rewriteDoctors(doctors);
        }

        FileManager.rewriteAppointments(appointments);
        System.out.println("Appointment marked as completed.");
    }

    public Appointment findAppointment(int appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId() == appointmentId) {
                return appointment;
            }
        }
        return null;
    }

    public void showAllAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("No appointment records found.");
            return;
        }

        System.out.println("\n======= ALL APPOINTMENTS (" +
                appointments.size() + " records) =======");

        for (Appointment appointment : appointments) {
            appointment.showAppointment();
        }
    }


    public void addBill(Bill bill) throws hospitalexception {

        if (findBill(bill.getBillId()) != null) {
            throw new hospitalexception("Bill ID " +
                    bill.getBillId() + " already exists.");
        }

        Patient patient = findPatient(bill.getPatientId());
        if (patient == null) {
            throw new hospitalexception("Patient with ID " +
                    bill.getPatientId() + " not found.");
        }

        bills.add(bill);
        FileManager.saveBill(bill);
        System.out.println("Bill generated successfully for patient: " +
                patient.getName());
    }

    public Bill findBill(int billId) {
        for (Bill bill : bills) {
            if (bill.getBillId() == billId) {
                return bill;
            }
        }
        return null;
    }

    public void makePayment(int billId) throws hospitalexception {

        Bill bill = findBill(billId);

        if (bill == null) {
            throw new hospitalexception("Bill with ID " +
                    billId + " not found.");
        }

        if (bill.isPaid()) {
            throw new hospitalexception("Bill is already paid.");
        }

        bill.makePayment();
        FileManager.rewriteBills(bills);
        System.out.println("Payment completed successfully.");
        System.out.println("Amount Paid: Rs. " + bill.getTotalAmount());
    }

    public void showAllBills() {
        if (bills.isEmpty()) {
            System.out.println("No billing records found.");
            return;
        }

        System.out.println("\n======= ALL BILLS (" +
                bills.size() + " records) =======");

        for (Bill bill : bills) {
            bill.showBill();
        }
    }
}