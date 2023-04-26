package choreotype;

public class User {
    private int id;
    private String username;
    private String password;
    private String email;
    private String role;

    public User(String username, String role) {
        this.username = username;
        this.role = role;
    }

    // Getters and setters for attributes

    // registerUser(), loginUser(), logoutUser(), updateUser(), deleteUser()
}