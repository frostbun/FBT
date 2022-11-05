package j1_l_p0002_db;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import utils.Reader;

public class Manager {

    private static final String USERNAME_REGEX = "^\\w{5,}$";
    private static final String PASSWORD_REGEX = "^[\\w\\p{Punct}]{6,}$";
    private static final String PHONE_REGEX = "^\\d{10}$";
    private static final String EMAIL_REGEX = "^[\\w\\p{Punct}]+@[\\w][.\\w]*$";

    private final Reader reader;

    public Manager(Reader reader) {
        this.reader = reader;
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
            if (User.get(username) != null) {
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
            if (User.insert(new User(username, firstName, lastName, User.hashPassword(password), phone, email))) {
                System.out.println("User added");
            }
            else {
                System.out.println("Failed to add new user");
            }
        } while (reader.confirm("Continue? (Y/N): "));
    }

    public void check() {
        do {
            System.out.println(
                User.get(
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
            List<User> found = User.search(reader.getString("Input name: "));
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
            User user = User.get(reader.getPattern("Input username: ",USERNAME_REGEX));
            // not found
            if (user == null) {
                System.out.println("User not found");
                continue;
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
                if (User.update(user)) {
                    System.out.println("Update success");
                }
                else {
                    System.out.println("Update failed");
                }
            }
            // delete
            else if (reader.confirm("Are you sure? (Y/N): ")) {
                if (User.delete(user)) {
                    System.out.println("Remove success");
                }
                else {
                    System.out.println("Remove failed");
                }
            }
        } while (reader.confirm("Continue? (Y/N): "));
    }

    public void load() {
        print(User.getAll());
    }

    public static void main(String[] args) {
        String title = "\n===USER MANAGEMENT===";
        String prompt = "Your choice: ";
        List<String> menu = new ArrayList<>();
        menu.add("1. Create new user");
        menu.add("2. Check user exists");
        menu.add("3. Search user information by name");
        menu.add("4. Update a user");
        menu.add("5. List all user");
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
                        manager.load();
                }
            }
        }
    }
}
