import java.util.Scanner;

public class Patient {

    private int patientId;
    private String name;
    private int age;
    private String gender;
    private String disease;
    private String phone;
    private String address;

    public Patient(int patientId, String name, int age, String gender,
                   String disease, String phone, String address) {

        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.disease = disease;
        this.phone = phone;
        this.address = address;
    }

    public int getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String getDisease() {
        return disease;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }

    public void updateDisease(String disease) {
        this.disease = disease;
    }

    public void updatePhone(String phone) {
        this.phone = phone;
    }

    public void showPatient() {
        System.out.println("\n--------------------------------");
        System.out.println("        PATIENT DETAILS");
        System.out.println("--------------------------------");
        System.out.println("Patient ID : " + patientId);
        System.out.println("Name       : " + name);
        System.out.println("Age        : " + age);
        System.out.println("Gender     : " + gender);
        System.out.println("Disease    : " + disease);
        System.out.println("Phone      : " + phone);
        System.out.println("Address    : " + address);
        System.out.println("--------------------------------");
    }
}