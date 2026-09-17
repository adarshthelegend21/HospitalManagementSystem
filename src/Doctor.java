public class Doctor {

    private int doctorId;
    private String name;
    private String specialization;
    private String phone;
    private String roomNumber;
    private boolean available;

    public Doctor(int doctorId, String name, String specialization,
                  String phone, String roomNumber) {

        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.phone = phone;
        this.roomNumber = roomNumber;
        this.available = true;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getPhone() {
        return phone;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailability(boolean available) {
        this.available = available;
    }

    public void updatePhone(String phone) {
        this.phone = phone;
    }

    public void showDoctor() {
        System.out.println("\n--------------------------------");
        System.out.println("         DOCTOR DETAILS");
        System.out.println("--------------------------------");
        System.out.println("Doctor ID      : " + doctorId);
        System.out.println("Name           : " + name);
        System.out.println("Specialization : " + specialization);
        System.out.println("Phone          : " + phone);
        System.out.println("Room Number    : " + roomNumber);
        System.out.println("Availability   : " +
                (available ? "Available" : "Not Available"));
        System.out.println("--------------------------------");
    }
}