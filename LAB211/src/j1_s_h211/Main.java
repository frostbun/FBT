package j1_s_h211;

import java.util.ArrayList;
import java.util.List;

import utils.Reader;

public class Main {

    public static List<Integer> fromCounts(List<Integer> input) {
        List<Integer> output = new ArrayList<>();
        for (int i=0; i<input.size(); i+=2) {
            for (int j = 0; j<input.get(i); ++j) {
                output.add(input.get(i+1));
            }
        }
        return output;
    }

    public static void main(String[] args) {
        try (Reader reader = new Reader()) {
            List<Integer> input = reader.getIntegerList();
            if (input.size() % 2 == 1) {
                System.err.println("Invalid input");
                return;
            }
            for (int i=0; i<input.size(); i+=2) {
                if (input.get(i) < 0) {
                    System.err.println("Invalid input");
                    return;
                }
            }
            System.out.println(fromCounts(input));
        }
    }
}
