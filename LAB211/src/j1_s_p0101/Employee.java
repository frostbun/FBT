package j1_s_p0101;

public class Employee {

    private final String id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String address;
    private String dob;
    private boolean sex;
    private double salary;
    private String agency;

    public Employee(String id, String firstName, String lastName, String phone, String email, String address, String dob, boolean sex, double salary, String agency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.dob = dob;
        this.sex = sex;
    }

    public String getId() {
        return this.id;
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

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDob() {
        return this.dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean getSex() {
        return this.sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public double getSalary() {
        return this.salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getAgency() {
        return this.agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }


    @Override
    public String toString() {
        return String.format(
            "%-5s | %-15s | %-15s | %-10s | %-15s | %-30s | %-10s | %-6s | %-10.2f | %s",
            id,
            firstName,
            lastName,
            phone,
            email,
            address,
            dob,
            sex ? "Male" : "Female",
            salary,
            agency
        );
    }

}
