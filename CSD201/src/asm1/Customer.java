package asm1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Customer {

    private final String phone;
    private final String name;

    private Customer(String phone, String name) {
        this.phone = phone;
        this.name = name;
    }

    public String getPhone() {
        return this.phone;
    }

    public String toString() {
        return String.format("%s; %s", this.name, this.phone);
    }

    public static List<Customer> load(String file) {
        List<Customer> customerList = new LinkedList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                try {
                    String[] args = line.trim().split("; ");
                    String phone = args[1];
                    String name = args[0];
                    if (!phone.matches("^8\\d{6}$")) continue;
                    if (name.length() > 25) continue;
                    customerList.add(new Customer(phone, name));
                }
                catch (RuntimeException e) {}
            }
        }
        catch (IOException e) {
            System.out.println(e);
        }
        return customerList;
    }
}
