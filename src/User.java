public class User {

    protected String username;
    protected String password;
    protected String role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public boolean login(String username, String password) {
        return this.username.equals(username)
                && this.password.equals(password);
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public void showUser() {
        System.out.println("Username : " + username);
        System.out.println("Role     : " + role);
    }
}