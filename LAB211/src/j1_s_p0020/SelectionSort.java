package j1_s_p0020;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import utils.Reader;

public class SelectionSort {

    public static void sort(List<Integer> list) {
        for (int i=0; i<list.size()-1; ++i) {
            int index = i;
            for (int j=i+1; j<list.size(); ++j) {
                if (list.get(j) < list.get(index)) {
                    index = j;
                }
            }
            if (index != i) {
                Collections.swap(list, i, index);
            }
        }
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
