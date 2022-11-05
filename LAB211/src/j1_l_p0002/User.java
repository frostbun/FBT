package j1_l_p0002;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class User {

    private final String username;
    private String firstName;
    private String lastName;
    private String password;
    private String phone;
    private String email;

    public User(String username, String firstName, String lastName, String password, String phone, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.phone = phone;
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format(
            "%-10s | %-10s | %-10s | %s | %s",
            username,
            firstName,
            lastName,
            phone,
            email
        );
    }

    public boolean validatePassword(String password) {
        return hashPassword(password).equals(this.password);
    }

    public static String hashPassword(String password) {
        try {
            byte[] hashedPass = MessageDigest.getInstance("SHA-256").digest(password.getBytes());
            StringBuilder builder = new StringBuilder();
            for (byte b: hashedPass) {
                builder.append(Integer.toHexString(b & 0xff));
            }
            return builder.toString();
        }
        catch (NoSuchAlgorithmException e) {
            return "";
        }
    }
}
