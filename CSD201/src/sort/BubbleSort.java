package sort;

import java.util.Collections;
import java.util.List;

public class BubbleSort<T extends Comparable<T>> {

    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i=0; i<list.size()-1; ++i) {
                if (list.get(i).compareTo(list.get(i+1)) > 0) {
                    Collections.swap(list, i, i+1);
                    sorted = false;
                }
            }
        }
        return list;
    }
}
