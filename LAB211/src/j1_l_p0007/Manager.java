package j1_l_p0007;

import java.util.List;

import utils.Reader;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;

public class Manager {

    private final List<Phone> phoneList;
    private final Reader reader;

    public Manager(Reader reader) {
        phoneList = new ArrayList<>();
        this.reader = reader;
    }

    private Phone searchByModel(String model) {
        for(Phone phone: phoneList) {
            if(phone.getModel().equalsIgnoreCase(model)) return phone;
        }
        return null;
    }

    private void print(List<Phone> phoneList) {
        System.out.format(
            "%-10s | %-30s | %-30s | %-30s | %-11s | %-10s | %-10s | %s\n",
            "Model",
            "CPU",
            "RAM",
            "Primary Camera",
            "Screen Size",
            "Price",
            "Color",
            "Brand"
        );
        Collections.sort(phoneList, (p1,p2) -> p2.getModel().compareToIgnoreCase(p1.getModel()));
        for (Phone phone: phoneList) {
            System.out.println(phone);
        }
    }

    public void add() {
        do {
            String model = reader.getString("Input model: ");
            if(searchByModel(model) != null) {
                System.out.println("Phone model existed");
                continue;
            }
            String cpu = reader.getString("Input cpu: ");
            String ram = reader.getString("Input ram: ");
            String primaryCamera = reader.getString("Input primary camera: ");
            String screenSize = reader.getPattern("Input screen size (1080x1920): ", "^\\d+\\s*x\\s*\\d+$");
            double price = reader.getDouble("Input price: ", 0.0, Double.MAX_VALUE);
            String color = reader.getString("Input color: ");
            String brand = reader.getString("Input brand: ");
            phoneList.add(new Phone(model, cpu, ram, primaryCamera, screenSize, price, color, brand));
            System.out.println("Phone added");
        } while (reader.confirm("Continue? (Y/N): "));
    }

    public void search() {
        do {
            String model = reader.getString("Input model: ").toLowerCase();
            List<Phone> found = new ArrayList<>();
            for (Phone phone: phoneList) {
                if (phone.getModel().toLowerCase().contains(model)) {
                    found.add(phone);
                }
            }
            if (found.isEmpty()) {
                System.out.println("This phone Model does not exist!");
                continue;
            }
            print(found);
        } while (reader.confirm("Continue? (Y/N): "));
    }

    public void remove() {
        Phone phone = searchByModel(reader.getString("Input model: "));
        if (phone == null) {
            System.out.println("This phone Model does not exist!");
            return;
        }
        System.out.println("Found 1 phone:");
        System.out.println(phone);
        if (reader.confirm("Are you sure? (Y/N): ")) {
            phoneList.remove(phone);
            System.out.println("Remove success");
        }
    }

    public void printAll() {
        print(phoneList);
    }

    public void save() {
        String filename = reader.getPattern("Input file name: ", "^*+.*+$");
        try (Writer writer = new FileWriter(filename)) {
            for (Phone phone: phoneList) {
                writer.write(phone + "\n");
            }
            System.out.println("Save success");
        }
        catch (IOException e) {
            System.out.println("Save failed");
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        String title = "\n===PHONE MANAGEMENT===";
        String prompt = "Your choice: ";
        List<String> menu = new ArrayList<>();
        menu.add("1. Add a phone");
        menu.add("2. Search phones by model");
        menu.add("3. Remove a phone");
        menu.add("4. Show all phones");
        menu.add("5. Save all phones to file");
        menu.add("6. Exit");

        try (Reader reader = new Reader()) {
            Manager manager = new Manager(reader);
            int choice;
            while((choice = reader.getChoice(title, menu, prompt)) != 6) {
                switch(choice) {
                    case 1:
                        manager.add();
                        break;
                    case 2:
                        manager.search();
                        break;
                    case 3:
                        manager.remove();
                        break;
                    case 4:
                        manager.printAll();
                        break;
                    case 5:
                        manager.save();
                }
            }
        }
    }
}
