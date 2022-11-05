package j1_s_h208;

import utils.Reader;

public class Swap {

    public static int swapDigitPairs(int input) {
        int n = 0;
        int[] digits = new int[10];
        while (input > 0) {
            digits[n++] = input % 10;
            input /= 10;
        }
        for (int i=0; i<n-1; i+=2) {
            int tmp = digits[i];
            digits[i] = digits[i+1];
            digits[i+1] = tmp;
        }
        int output = 0;
        while (n-->0) {
            output = output*10 + digits[n];
        }
        return output;
    }

    public static void main(String[] args) {
        try (Reader reader = new Reader()) {
            int input = reader.getInteger("Input a positive integer: ", 1, Integer.MAX_VALUE);
            System.out.println(swapDigitPairs(input));
        }
    }
}
