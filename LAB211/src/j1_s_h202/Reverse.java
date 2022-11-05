package j1_s_h202;

import java.util.Scanner;

public class Reverse {

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine().trim();
            if (input.length() == 0) return;
            for (int i=input.length(); i>=0; --i) {
                System.out.print(input.charAt(i));
            }
            System.out.println();
        }
    }
}
