package sort;

import java.util.Collections;
import java.util.List;

public class InsertionSort<T extends Comparable<T>> {

    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
        for (int i=1; i<list.size(); ++i) {
            for (int j=i; j>0 && list.get(j-1).compareTo(list.get(j)) > 0; --j) {
                Collections.swap(list, j-1, j);
            }
        }
        return list;
    }
}
