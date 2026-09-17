import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String PATIENT_FILE = "data/patients.txt";
    private static final String DOCTOR_FILE = "data/doctors.txt";
    private static final String APPOINTMENT_FILE = "data/appointments.txt";
    private static final String BILL_FILE = "data/bills.txt";

    

    public static void savePatient(Patient patient) {
        try {
            createDataFolder();

            FileWriter writer = new FileWriter(PATIENT_FILE, true);

            writer.write(patient.getPatientId() + "," +
                    patient.getName() + "," +
                    patient.getAge() + "," +
                    patient.getGender() + "," +
                    patient.getDisease() + "," +
                    patient.getPhone() + "," +
                    patient.getAddress() + "\n");

            writer.close();

        } catch (IOException e) {
            System.out.println("Unable to save patient data.");
        }
    }

    public static void saveDoctor(Doctor doctor) {
        try {
            createDataFolder();

            FileWriter writer = new FileWriter(DOCTOR_FILE, true);

            writer.write(doctor.getDoctorId() + "," +
                    doctor.getName() + "," +
                    doctor.getSpecialization() + "," +
                    doctor.getPhone() + "," +
                    doctor.getRoomNumber() + "," +
                    (doctor.isAvailable() ? "1" : "0") + "\n");

            writer.close();

        } catch (IOException e) {
            System.out.println("Unable to save doctor data.");
        }
    }

    public static void saveAppointment(Appointment appointment) {
        try {
            createDataFolder();

            FileWriter writer = new FileWriter(APPOINTMENT_FILE, true);

            writer.write(appointment.getAppointmentId() + "," +
                    appointment.getPatientId() + "," +
                    appointment.getDoctorId() + "," +
                    appointment.getDate() + "," +
                    appointment.getTime() + "," +
                    appointment.getReason() + "," +
                    appointment.getStatus() + "\n");

            writer.close();

        } catch (IOException e) {
            System.out.println("Unable to save appointment data.");
        }
    }

    public static void saveBill(Bill bill) {
        try {
            createDataFolder();

            FileWriter writer = new FileWriter(BILL_FILE, true);

            writer.write(bill.getBillId() + "," +
                    bill.getPatientId() + "," +
                    bill.getConsultationFee() + "," +
                    bill.getMedicineCharges() + "," +
                    bill.getRoomCharges() + "," +
                    bill.getTestCharges() + "," +
                    (bill.isPaid() ? "1" : "0") + "\n");

            writer.close();

        } catch (IOException e) {
            System.out.println("Unable to save bill data.");
        }
    }
    

    public static ArrayList<Patient> loadPatients() {

        ArrayList<Patient> patients = new ArrayList<>();
        ArrayList<String> lines = readFile(PATIENT_FILE);

        for (String line : lines) {
            try {
                String[] parts = line.split(",");

                if (parts.length >= 7) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    int age = Integer.parseInt(parts[2].trim());
                    String gender = parts[3].trim();
                    String disease = parts[4].trim();
                    String phone = parts[5].trim();
                    String address = parts[6].trim();

                    Patient patient = new Patient(
                            id, name, age, gender, disease, phone, address
                    );
                    patients.add(patient);
                }
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid patient record.");
            }
        }

        return patients;
    }

    public static ArrayList<Doctor> loadDoctors() {

        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<String> lines = readFile(DOCTOR_FILE);

        for (String line : lines) {
            try {
                String[] parts = line.split(",");

                if (parts.length >= 5) {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String specialization = parts[2].trim();
                    String phone = parts[3].trim();
                    String room = parts[4].trim();

                    Doctor doctor = new Doctor(
                            id, name, specialization, phone, room
                    );

                    // check if availability data is present
                    if (parts.length >= 6) {
                        boolean available = parts[5].trim().equals("1");
                        doctor.setAvailability(available);
                    }

                    doctors.add(doctor);
                }
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid doctor record.");
            }
        }

        return doctors;
    }

    public static ArrayList<Appointment> loadAppointments() {

        ArrayList<Appointment> appointments = new ArrayList<>();
        ArrayList<String> lines = readFile(APPOINTMENT_FILE);

        for (String line : lines) {
            try {
                String[] parts = line.split(",");

                if (parts.length >= 6) {
                    int appointmentId = Integer.parseInt(parts[0].trim());
                    int patientId = Integer.parseInt(parts[1].trim());
                    int doctorId = Integer.parseInt(parts[2].trim());
                    String date = parts[3].trim();
                    String time = parts[4].trim();
                    String reason = parts[5].trim();

                    Appointment appointment = new Appointment(
                            appointmentId, patientId, doctorId,
                            date, time, reason
                    );

                    // check if status is stored in the file
                    if (parts.length >= 7) {
                        String status = parts[6].trim();
                        if (status.equals("Cancelled")) {
                            appointment.cancelAppointment();
                        } else if (status.equals("Completed")) {
                            appointment.completeAppointment();
                        }
                    }

                    appointments.add(appointment);
                }
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid appointment record.");
            }
        }

        return appointments;
    }

    public static ArrayList<Bill> loadBills() {

        ArrayList<Bill> bills = new ArrayList<>();
        ArrayList<String> lines = readFile(BILL_FILE);

        for (String line : lines) {
            try {
                String[] parts = line.split(",");

                if (parts.length >= 6) {
                    int billId = Integer.parseInt(parts[0].trim());
                    int patientId = Integer.parseInt(parts[1].trim());
                    double consultation = Double.parseDouble(parts[2].trim());
                    double medicine = Double.parseDouble(parts[3].trim());
                    double room = Double.parseDouble(parts[4].trim());
                    double tests = Double.parseDouble(parts[5].trim());

                    Bill bill = new Bill(
                            billId, patientId,
                            consultation, medicine, room, tests
                    );

                    // check if payment status is stored
                    if (parts.length >= 7 && parts[6].trim().equals("1")) {
                        bill.setPaid(true);
                    }

                    bills.add(bill);
                }
            } catch (NumberFormatException e) {
                System.out.println("Skipping invalid bill record.");
            }
        }

        return bills;
    }

    public static void rewritePatients(ArrayList<Patient> patients) {
        try {
            createDataFolder();

            FileWriter writer = new FileWriter(PATIENT_FILE, false);

            for (Patient patient : patients) {
                writer.write(patient.getPatientId() + "," +
                        patient.getName() + "," +
                        patient.getAge() + "," +
                        patient.getGender() + "," +
                        patient.getDisease() + "," +
                        patient.getPhone() + "," +
                        patient.getAddress() + "\n");
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Unable to update patient data file.");
        }
    }

    public static void rewriteDoctors(ArrayList<Doctor> doctors) {
        try {
            createDataFolder();

            FileWriter writer = new FileWriter(DOCTOR_FILE, false);

            for (Doctor doctor : doctors) {
                writer.write(doctor.getDoctorId() + "," +
                        doctor.getName() + "," +
                        doctor.getSpecialization() + "," +
                        doctor.getPhone() + "," +
                        doctor.getRoomNumber() + "," +
                        (doctor.isAvailable() ? "1" : "0") + "\n");
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Unable to update doctor data file.");
        }
    }

    public static void rewriteAppointments(ArrayList<Appointment> appointments) {
        try {
            createDataFolder();

            FileWriter writer = new FileWriter(APPOINTMENT_FILE, false);

            for (Appointment appointment : appointments) {
                writer.write(appointment.getAppointmentId() + "," +
                        appointment.getPatientId() + "," +
                        appointment.getDoctorId() + "," +
                        appointment.getDate() + "," +
                        appointment.getTime() + "," +
                        appointment.getReason() + "," +
                        appointment.getStatus() + "\n");
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Unable to update appointment data file.");
        }
    }

    public static void rewriteBills(ArrayList<Bill> bills) {
        try {
            createDataFolder();

            FileWriter writer = new FileWriter(BILL_FILE, false);

            for (Bill bill : bills) {
                writer.write(bill.getBillId() + "," +
                        bill.getPatientId() + "," +
                        bill.getConsultationFee() + "," +
                        bill.getMedicineCharges() + "," +
                        bill.getRoomCharges() + "," +
                        bill.getTestCharges() + "," +
                        (bill.isPaid() ? "1" : "0") + "\n");
            }

            writer.close();

        } catch (IOException e) {
            System.out.println("Unable to update bill data file.");
        }
    }

    private static ArrayList<String> readFile(String fileName) {

        ArrayList<String> records = new ArrayList<>();

        try {
            File file = new File(fileName);

            if (!file.exists()) {
                return records;
            }

            BufferedReader reader = new BufferedReader(
                    new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    records.add(line);
                }
            }

            reader.close();

        } catch (IOException e) {
            System.out.println("Unable to read data from " + fileName);
        }

        return records;
    }

    private static void createDataFolder() {
        File folder = new File("data");
        if (!folder.exists()) {
            folder.mkdir();
        }
    }
}