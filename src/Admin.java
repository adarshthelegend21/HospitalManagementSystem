public class Admin extends User {

    private String adminName;

    public Admin(String username, String password, String adminName) {
        super(username, password, "Admin");
        this.adminName = adminName;
    }

    public String getAdminName() {
        return adminName;
    }

    public void showAdminDetails() {
        System.out.println("\n--------------------------------");
        System.out.println("        ADMIN DETAILS");
        System.out.println("--------------------------------");
        System.out.println("Admin Name : " + adminName);
        System.out.println("Username   : " + username);
        System.out.println("Role       : " + role);
        System.out.println("--------------------------------");
    }

    @Override
    public void showUser() {
        System.out.println("Admin: " + adminName);
        System.out.println("Role : " + role);
    }
}