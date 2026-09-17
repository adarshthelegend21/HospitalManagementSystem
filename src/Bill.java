public class Bill {

    private int billId;
    private int patientId;
    private double consultationFee;
    private double medicineCharges;
    private double roomCharges;
    private double testCharges;
    private boolean paid;

    public Bill(int billId, int patientId, double consultationFee,
                double medicineCharges, double roomCharges,
                double testCharges) {

        this.billId = billId;
        this.patientId = patientId;
        this.consultationFee = consultationFee;
        this.medicineCharges = medicineCharges;
        this.roomCharges = roomCharges;
        this.testCharges = testCharges;
        this.paid = false;
    }

    public int getBillId() {
        return billId;
    }

    public int getPatientId() {
        return patientId;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public double getMedicineCharges() {
        return medicineCharges;
    }

    public double getRoomCharges() {
        return roomCharges;
    }

    public double getTestCharges() {
        return testCharges;
    }

    public double getTotalAmount() {
        return consultationFee + medicineCharges
                + roomCharges + testCharges;
    }

    public boolean isPaid() {
        return paid;
    }

    public void makePayment() {
        paid = true;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void showBill() {
        System.out.println("\n--------------------------------");
        System.out.println("           HOSPITAL BILL");
        System.out.println("--------------------------------");
        System.out.println("Bill ID           : " + billId);
        System.out.println("Patient ID        : " + patientId);
        System.out.println("Consultation Fee  : Rs. " + consultationFee);
        System.out.println("Medicine Charges  : Rs. " + medicineCharges);
        System.out.println("Room Charges      : Rs. " + roomCharges);
        System.out.println("Test Charges      : Rs. " + testCharges);
        System.out.println("--------------------------------");
        System.out.println("Total Amount      : Rs. " + getTotalAmount());
        System.out.println("Payment Status    : " +
                (paid ? "Paid" : "Pending"));
        System.out.println("--------------------------------");
    }
}