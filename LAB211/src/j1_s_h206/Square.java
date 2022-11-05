package j1_s_h206;

import java.util.ArrayList;
import java.util.List;

import utils.Reader;

public class Square {
    
    public static void printSquare(int min, int max) {
        int n = max-min+1;
        List<Integer> toPrint = new ArrayList<>();
        for (int i=min; i<=max; ++i) {
            toPrint.add(i);
        }
        for (int i=0; i<n; ++i) {
            for (int j=i; j<i+n; ++j) {
                System.out.print(toPrint.get(j%n));
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        try (Reader reader = new Reader()) {
            printSquare(reader.getInteger("Input min: "), reader.getInteger("Input max: "));
        }
    }
}
