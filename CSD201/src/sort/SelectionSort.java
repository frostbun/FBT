package sort;

import java.util.Collections;
import java.util.List;

public class SelectionSort<T extends Comparable<T>> {

    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
        for (int i=0; i<list.size()-1; ++i) {
            List<T> subList = list.subList(i, list.size());
            Collections.swap(list, i, i+subList.indexOf(Collections.min(subList)));
        }
        return list;
    }
}
