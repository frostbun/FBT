package j1_s_h207;

import java.util.Scanner;

public class Count {

    public static int secondHalfLetters(String input) {
        int count = 0;
        for (char c: input.toLowerCase().toCharArray()) {
            if (Character.compare(c, 'n') >= 0 &&
                Character.compare(c, 'z') <= 0) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine().trim();
            if (input.length() == 0) return;
            System.out.println(secondHalfLetters(input));
        }
    }
}
