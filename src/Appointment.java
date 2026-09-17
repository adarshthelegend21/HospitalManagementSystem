public class Appointment {

    private int appointmentId;
    private int patientId;
    private int doctorId;
    private String date;
    private String time;
    private String reason;
    private String status;

    public Appointment(int appointmentId, int patientId, int doctorId,
                       String date, String time, String reason) {

        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.status = "Booked";
    }

    public int getAppointmentId() {
        return appointmentId;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getReason() {
        return reason;
    }

    public String getStatus() {
        return status;
    }

    public void cancelAppointment() {
        status = "Cancelled";
    }

    public void completeAppointment() {
        status = "Completed";
    }

    public void showAppointment() {
        System.out.println("\n--------------------------------");
        System.out.println("      APPOINTMENT DETAILS");
        System.out.println("--------------------------------");
        System.out.println("Appointment ID : " + appointmentId);
        System.out.println("Patient ID     : " + patientId);
        System.out.println("Doctor ID      : " + doctorId);
        System.out.println("Date           : " + date);
        System.out.println("Time           : " + time);
        System.out.println("Reason         : " + reason);
        System.out.println("Status         : " + status);
        System.out.println("--------------------------------");
    }
}