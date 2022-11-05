package j1_l_p0005;

import java.util.ArrayList;
import java.util.List;

import utils.Reader;

public class Bank {

    private static final String PASSWORD_REGEX = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[@$!%*?&])[A-Za-z0-9@$!%*?&]{6,}$";

    private final Reader reader;
    private Account session;

    public Bank(Reader reader) {
        this.reader = reader;
    }

    public Account getSession() {
        return session;
    }

    public void createAccount() {
        String id = reader.getString("Input id: ");
        if (Account.get(id) != null) {
            System.out.println("Account existed");
            return;
        }
        String name = reader.getString("Input name: ");
        String password;
        while (true) {
            password = reader.getPattern("Input password (at least 6 characters, including uppercase letters, lower case letters, numeric characters and 1 special character): ", PASSWORD_REGEX);
            if (reader.getRawString("Confirm password: ").equals(password)) {
                break;
            }
            System.out.println("Wrong, please re-enter password");
        }
        if (new Account(id, name, password).insert()) {
            System.out.println("Account created");
        }
        else {
            System.out.println("There was an error creating your account");
        }
    }

    public void login() {
        Account account = Account.get(reader.getString("Input id: "));
        if (account == null) {
            System.out.println("Account not found");
            return;
        }
        String password = reader.getPattern("Input password: ", PASSWORD_REGEX);
        if (!account.validatePassword(password)) {
            System.out.println("Wrong password");
            return;
        }
        session = account;
        System.out.println("Login successful");
    }

    private boolean isLoggedIn() {
        if (session == null) {
            System.out.println("You are not logged in");
            return false;
        }
        System.out.format("You are logged in as %s\nYour balance: %.2f\n", session.getName(), session.getBalance());
        return true;
    }

    public void withdraw() {
        if (!isLoggedIn()) return;
        double amount = reader.getDouble("Input amount: ", 0, session.getBalance());
        if (session.withdraw(amount)) {
            System.out.println("Withdraw success");
        }
        else {
            System.out.println("Withdraw fail");
        }
    }

    public void deposit() {
        if (!isLoggedIn()) return;
        double amount = reader.getDouble("Input amount: ", 0, Double.MAX_VALUE);
        if (session.deposit(amount)) {
            System.out.println("Deposit success");
        }
        else {
            System.out.println("Deposit fail");
        }
    }

    public void transfer() {
        if (!isLoggedIn()) return;
        Account other = Account.get(reader.getString("Input other account id: "));
        if (other == null) {
            System.out.println("Id not found");
            return;
        }
        double amount = reader.getDouble("Input amount: ", 0, Double.MAX_VALUE);
        if (session.transfer(amount, other)) {
            System.out.println("Transfer success");
        }
        else {
            System.out.println("Transfer fail");
        }
    }

    public void delete() {
        if (!isLoggedIn()) return;
        if (reader.confirm("Delete your account? (y/n): ")) {
            if (session.delete()) {
                System.out.println("Your account was deleted");
                session = null;
            }
            else {
                System.out.println("There was an error deleting your account");
            }
        }
    }

    public static void main(String[] args) {
        String title = "\n===The Secret Bank===";
        String prompt = "Your choice: ";
        List<String> menu = new ArrayList<>();
        menu.add("1. Create new account");
        menu.add("2. Login");
        menu.add("3. Withdraw money");
        menu.add("4. Deposit money");
        menu.add("5. Transfer money");
        menu.add("6. Delete account");
        menu.add("Others: Exit");

        try (Reader reader = new Reader()) {
            Bank bank = new Bank(reader);
            while (true) {
                int choice = reader.getChoice(title, menu, prompt, Integer.MIN_VALUE, Integer.MAX_VALUE);
                switch (choice) {
                    case 1:
                        bank.createAccount();
                        break;
                    case 2:
                        bank.login();
                        break;
                    case 3:
                        bank.withdraw();
                        break;
                    case 4:
                        bank.deposit();
                        break;
                    case 5:
                        bank.transfer();
                        break;
                    case 6:
                        bank.delete();
                        break;
                    default:
                        return;
                }
            }
        }
    }
}
