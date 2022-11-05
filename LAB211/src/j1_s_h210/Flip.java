package j1_s_h210;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Flip {

    public static void flipLines(Scanner scanner) {
        String prevLine = null;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            if (prevLine == null) {
                prevLine = line;
            }
            else {
                System.out.println(line);
                System.out.println(prevLine);
                prevLine = null;
            }
        }
        if (prevLine != null) {
            System.out.println(prevLine);
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Input filename: ");
            File file = new File(scanner.nextLine().trim());
            try (Scanner fileScanner = new Scanner(file)) {
                flipLines(fileScanner);
            }
            catch (FileNotFoundException e) {
                System.err.println("File not found");
            }
        }
    }
}
