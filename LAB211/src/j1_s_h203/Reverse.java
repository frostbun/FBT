package j1_s_h203;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Reverse {

    private static final String[] PUNCTUATIONS = {"!", ";", ".", ","};

    public static void printReverse(String s) {
        String[] input = s.trim().split("\\s+");
        List<String> curPunc = new ArrayList<>();
        // check for punctuation of each word and delete it
        for (int i=0; i<input.length; ++i) {
            boolean hasPunc = false;
            for (String c: PUNCTUATIONS) {
                if (input[i].endsWith(c)) {
                    hasPunc = true;
                    curPunc.add(c);
                    input[i] = input[i].substring(0, input[i].length()-1);
                    break;
                }
            }
            if (!hasPunc) {
                curPunc.add("");
            }
        }
        int n = input.length;
        boolean capital = true;
        for (int i=0; i<n; ++i) {
            // curr word
            String output = input[n-i-1] + curPunc.get(i);
            // uppercase
            if (capital) {
                String tmp = output.substring(0, 1).toUpperCase();
                if (output.length() > 1) {
                    tmp += output.substring(1);
                }
                output = tmp;
                capital = false;
            }
            System.out.print(output + " ");
            // if current punc is not , then uppercase next word
            if (curPunc.get(i).length()>0 && !curPunc.get(i).equals(",")) {
                capital = true;
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String input = sc.nextLine().trim();
            if (input.length() == 0) return;
            printReverse(input);
        }
    }
}
