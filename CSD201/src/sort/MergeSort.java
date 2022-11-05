package sort;

import java.util.ArrayList;
import java.util.List;

public class MergeSort<T extends Comparable<T>> {

    private static <T extends Comparable<T>> List<T> merge(List<T> list, List<T> l1, List<T> l2) {
        int index1 = 0;
        int index2 = 0;
        for (int i=0; i<list.size(); ++i) {
            if (index1 >= l1.size()) {
                list.set(i, l2.get(index2++));
            }
            else if (index2 >= l2.size()) {
                list.set(i, l1.get(index1++));
            }
            else if (l1.get(index1).compareTo(l2.get(index2)) > 0) {
                list.set(i, l2.get(index2++));
            }
            else {
                list.set(i, l1.get(index1++));
            }
        }
        return list;
    }

    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
        if (list.size() <= 1) return list;
        int mid = list.size()/2;
        List<T> l1 = new ArrayList<T>(list.subList(0, mid));
        List<T> l2 = new ArrayList<T>(list.subList(mid, list.size()));
        return merge(list, sort(l1), sort(l2));
    }
}
