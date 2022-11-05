package j1_s_p0001;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import utils.Reader;

public class BubbleSort {

    private static boolean onePass(List<Integer> list, int count) {
        boolean sorted = true;
        for (int i=1; i<list.size()-count; ++i) {
            if (list.get(i-1) > list.get(i)) {
                Collections.swap(list, i-1, i);
                sorted = false;
            }
        }
        return sorted;
    }

    public static void sort(List<Integer> list) {
        int count = 0;
        while (!onePass(list, count++));
    }

    public static void main(String[] args) {
        try (Reader reader = new Reader()) {
            int count = reader.getInteger("Input quantity: ", 1, Integer.MAX_VALUE);
            int limit = reader.getInteger("Input range: ", 0, Integer.MAX_VALUE);
            List<Integer> list = new ArrayList<>();
            Random rand = new Random();
            while (count-->0) list.add(rand.nextInt(limit*2+1)-limit);
            System.out.printf("Unsorted array: %s\n", list);
            sort(list);
            System.out.printf("Sorted array: %s\n", list);
        }
    }
}
