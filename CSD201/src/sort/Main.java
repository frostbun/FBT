package sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int n = 20;
        List<Integer> list = new ArrayList<>(n);
        for (int i=0; i<n; ++i) {
            list.add(i);
        }
        Collections.shuffle(list);
        System.out.println(BubbleSort.sort(list));
        Collections.shuffle(list);
        System.out.println(SelectionSort.sort(list));
        Collections.shuffle(list);
        System.out.println(InsertionSort.sort(list));
        Collections.shuffle(list);
        System.out.println(MergeSort.sort(list));
        Collections.shuffle(list);
        System.out.println(QuickSort.sort(list));
        Collections.shuffle(list);
        System.out.println(TreeSort.sort(list));
    }
}
