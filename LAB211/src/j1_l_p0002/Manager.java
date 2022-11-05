package j1_l_p0002;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.Reader;

public class Manager {

    private static final String USERNAME_REGEX = "^\\w{5,}$";
    private static final String PASSWORD_REGEX = "^[\\w\\p{Punct}]{6,}$";
    private static final String PHONE_REGEX = "^\\d{10}$";
    private static final String EMAIL_REGEX = "^[\\w\\p{Punct}]+@[\\w][.\\w]*$";

    private final List<User> userList;
    private final Reader reader;

    public Manager(Reader reader) {
        userList = new ArrayList<>();
        this.reader = reader;
    }

    private User searchByUsername(String username) {
        for(User user: userList) {
            if(user.getUsername().equalsIgnoreCase(username)) return user;
        }
        return null;
    }

    private void print(List<User> userList) {
        System.out.format(
            "%-10s | %-10s | %-10s | %-10s | %s\n",
            "Username",
            "First Name",
            "Last Name",
            "Phone",
            "Email"
        );
        Collections.sort(userList, (u1,u2) -> u1.getFirstName().compareToIgnoreCase(u2.getFirstName()));
        for (User user:userList) {
            System.out.println(user);
        }
    }

    private boolean login(User user) {
        while (!user.validatePassword(reader.getString("Login with password: "))) {
            if (!reader.confirm("Wrong password, retry? (Y/N)")) return false;
        }
        return true;
    }

    public void add() {
        do {
            String username = reader.getPattern("Input username (at least 5 alphanumeric characters, underscores and no spaces): ", USERNAME_REGEX);
            if (searchByUsername(username) != null) {
                System.out.println("User existed");
                continue;
            }
            String password;
            while (true) {
                password = reader.getPattern("Input password (at least 6 alphanumeric characters, punctuations, underscores and no spaces): ", PASSWORD_REGEX);
                if (reader.getRawString("Confirm password: ").equals(password)) {
                    break;
                }
                System.out.println("Wrong, please re-enter password");
            }
            String firstName = reader.getString("Input first name: ");
            String lastName = reader.getString("Input last name: ");
            String phone = reader.getPattern("Input phone number: ", PHONE_REGEX);
            String email = reader.getPattern("Input email: ", EMAIL_REGEX);
            userList.add(new User(username, firstName, lastName, User.hashPassword(password), phone, email));
            System.out.println("User added");
        } while (reader.confirm("Continue? (Y/N): "));
    }

    public void check() {
        do {
            System.out.println(
                searchByUsername(
                    reader.getPattern(
                        "Input username: ",
                        USERNAME_REGEX
                    )
                ) == null ? "User not found" : "User exist"
            );
        } while (reader.confirm("Continue? (Y/N): "));
    }

    public void search() {
        do {
            String name = reader.getString("Input name: ").toLowerCase();
            List<User> found = new ArrayList<>();
            for (User user: userList) {
                if (
                    user.getFirstName().toLowerCase().contains(name) ||
                    user.getLastName().toLowerCase().contains(name)
                ) {
                    found.add(user);
                }
            }
            if (found.isEmpty()) {
                System.out.println("No user found");
                continue;
            }
            print(found);
        } while (reader.confirm("Continue? (Y/N): "));
    }

    public void update() {
        do {
            // search
            User user = searchByUsername(
                reader.getPattern(
                    "Input username (at least 5 alphanumeric characters, underscores and no spaces): ",
                    USERNAME_REGEX
                )
            );
            // not found
            if (user == null) {
                System.out.println("User not found");
                return;
            }
            // found
            System.out.println("Found 1 user:");
            System.out.println(user);
            // login
            if (!login(user)) continue;
            // update
            if (reader.confirm("Update or Delete (U/D): ", "u", "d")) {
                String password;
                // confirm password
                while (true) {
                    password = reader.getPattern("Input password (at least 6 alphanumeric characters, punctuations, underscores and no spaces): ", PASSWORD_REGEX);
                    if (reader.getRawString("Confirm password: ").equals(password)) {
                        break;
                    }
                    System.out.println("Wrong, please re-enter password");
                }
                user.setPassword(User.hashPassword(password));
                user.setFirstName(reader.getString("Input first name: "));
                user.setLastName(reader.getString("Input last name: "));
                user.setPhone(reader.getPattern("Input phone number: ", PHONE_REGEX));
                user.setEmail(reader.getPattern("Input email: ", EMAIL_REGEX));
                System.out.println("Update success");
            }
            // delete
            else if (reader.confirm("Are you sure? (Y/N): ")) {
                userList.remove(user);
                System.out.println("Remove success");
            }
        } while (reader.confirm("Continue? (Y/N): "));
    }

    public void save() {
        do {
            try (Writer writer = new FileWriter("user.txt", true)) {
                for (User user: userList) {
                    writer.write(String.format(
                        "%s/|\\%s/|\\%s/|\\%s/|\\%s/|\\%s",
                        user.getUsername(),
                        user.getFirstName(),
                        user.getLastName(),
                        user.getPhone(),
                        user.getEmail(),
                        user.getPassword()
                    ));
                }
                System.out.println("Save success");
            }
            catch (IOException e) {
                System.out.println("Save failed");
                System.out.println(e.getMessage());
            }
        } while (reader.confirm("Continue? (Y/N): "));
    }

    public void load() {
        do {
            try (BufferedReader reader = new BufferedReader(new FileReader("user.txt"))) {
                int count = 0;
                String line;
                while ((line = reader.readLine()) != null) {
                    // split
                    String[] args = line.split("\\/\\|\\\\");
                    if (args.length != 6) continue;
                    // validate
                    String username = args[0].trim();
                    if (searchByUsername(username) != null) continue;
                    String phone = args[3].trim();
                    if (!phone.matches(PHONE_REGEX)) continue;
                    String email = args[4].trim();
                    if (!email.matches(EMAIL_REGEX)) continue;
                    String firstName = args[1].trim();
                    String lastName = args[2].trim();
                    String password = args[5].trim();
                    userList.add(new User(username, firstName, lastName, password, phone, email));
                    ++count;
                }
                System.out.println("Loaded " + count + " users");
                print(userList);
            }
            catch (FileNotFoundException e) {
                System.out.println("File \"user.txt\" not found");
            }
            catch (IOException e) {
                System.out.println("Load failed");
            }
        } while (reader.confirm("Continue? (Y/N): "));
    }

    public static void main(String[] args) {
        String title = "\n===USER MANAGEMENT===";
        String prompt = "Your choice: ";
        List<String> menu = new ArrayList<>();
        menu.add("1. Create new user");
        menu.add("2. Check user exists");
        menu.add("3. Search user information by name");
        menu.add("4. Update a user");
        menu.add("5. Save users to file");
        menu.add("6. Load users from file");
        menu.add("Others: Exit");

        try (Reader reader = new Reader()) {
            Manager manager = new Manager(reader);
            while(true) {
                int choice = reader.getChoice(title, menu, prompt, Integer.MIN_VALUE, Integer.MAX_VALUE);
                if (choice<1 || choice>6) break;
                switch(choice) {
                    case 1:
                        manager.add();
                        break;
                    case 2:
                        manager.check();
                        break;
                    case 3:
                        manager.search();
                        break;
                    case 4:
                        manager.update();
                        break;
                    case 5:
                        manager.save();
                        break;
                    case 6:
                        manager.load();
                }
            }
        }
    }
}
