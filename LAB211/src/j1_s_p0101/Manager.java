package j1_s_p0101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.Reader;

public class Manager {

    private static final String PHONE_REGEX = "^\\d{10}$";
    private static final String EMAIL_REGEX = "^[\\w\\p{Punct}]+@[\\w][.\\w]*$";
    private static final String DOB_REGEX = "^\\d{1,2}/\\d{1,2}/\\d{4}$";
    
    private final List<Employee> employeeList;
    private final Reader reader;

    public Manager(Reader reader) {
        employeeList = new ArrayList<>();
        this.reader = reader;
    }

    private Employee searchById(String id) {
        for (Employee employee: employeeList) {
            if (employee.getId().equalsIgnoreCase(id)) {
                return employee;
            }
        }
        return null;
    }

    private void print(List<Employee> list) {
        System.out.format(
            "%-5s | %-15s | %-15s | %-10s | %-15s | %-30s | %-10s | %-6s | %-10s | %s\n",
            "Id",
            "First Name",
            "Last Name",
            "Phone",
            "Email",
            "Address",
            "Dob",
            "Sex",
            "Salary",
            "Agency"
        );
        list.forEach(System.out::println);
    }

    public void add() {
        String id = reader.getString("Input id: ");
        if (searchById(id) != null) {
            System.out.println("Employee existed");
            return;
        }
        String firstName = reader.getString("Input first name: ");
        String lastName = reader.getString("Input last name: ");
        String phone = reader.getPattern("Input phone number: ", PHONE_REGEX);
        String email = reader.getPattern("Input email: ", EMAIL_REGEX);
        String address = reader.getString("Input address: ");
        String dob = reader.getPattern("Input DOB: ", DOB_REGEX);
        boolean sex = reader.confirm("Input sex (M/F):", "m", "f");
        double salary = reader.getDouble("Input salary: ", 0, Double.MAX_VALUE);
        String agency = reader.getString("Input agency: ");
        employeeList.add(new Employee(id, firstName, lastName, phone, email, address, dob, sex, salary, agency));
        System.out.println("Employee added");
    }

    public void search() {
        String name = reader.getString("Input name: ").toLowerCase();
        List<Employee> found = new ArrayList<>();
        for (Employee employee: employeeList) {
            if (
                employee.getFirstName().toLowerCase().contains(name) ||
                employee.getLastName().toLowerCase().contains(name)
            ) {
                found.add(employee);
            }
        }
        if (found.isEmpty()) {
            System.out.println("No employee found");
            return;
        }
        print(found);
    }

    public void update() {
        Employee employee = searchById(reader.getString("Input id: "));
        if (employee == null) {
            System.out.println("Employee not found");
            return;
        }
        employee.setFirstName(reader.getString("Input first name: "));
        employee.setLastName(reader.getString("Input last name: "));
        employee.setPhone(reader.getPattern("Input phone number: ", PHONE_REGEX));
        employee.setEmail(reader.getPattern("Input email: ", EMAIL_REGEX));
        employee.setAddress(reader.getString("Input address: "));
        employee.setDob(reader.getPattern("Input DOB: ", DOB_REGEX));
        employee.setSex(reader.confirm("Input sex (M/F):", "m", "f"));
        employee.setSalary(reader.getDouble("Input salary: ", 0, Double.MAX_VALUE));
        employee.setAgency(reader.getString("Input agency: "));
        System.out.println("Employee updated");
    }

    public void remove() {
        Employee employee = searchById(reader.getString("Input id: "));
        if (employee == null) {
            System.out.println("Employee not found");
            return;
        }
        employeeList.remove(employee);
        System.out.println("Employee removed");
    }

    public void sort() {
        Collections.sort(employeeList, (e1,e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        print(employeeList);
    }

    public static void main(String[] args) {
        String title = "\n===EMPLOYEE MANAGEMENT===";
        String prompt = "Your choice: ";
        List<String> menu = new ArrayList<>();
        menu.add("1. Add new employee");
        menu.add("2. Update an employee");
        menu.add("3. Remove an employee");
        menu.add("4. Search employees");
        menu.add("5. Sort employees by salary");
        menu.add("Others: Exit");

        try (Reader reader = new Reader()) {
            Manager manager = new Manager(reader);
            int choice;
            while((choice = reader.getChoice(title, menu, prompt)) != 6) {
                switch(choice) {
                    case 1:
                        manager.add();
                        break;
                    case 2:
                        manager.update();
                        break;
                    case 3:
                        manager.remove();
                        break;
                    case 4:
                        manager.search();
                        break;
                    case 5:
                        manager.sort();
                }
            }
        }
    }
}
