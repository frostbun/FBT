package sort;

import java.util.Collections;
import java.util.List;

public class QuickSort<T extends Comparable<T>> {

    private static <T extends Comparable<T>> int divide(List<T> list) {
        T pivot = list.get(0);
        int left = 1, right = list.size()-1;
        while (true) {
            while (left <= right && list.get(left).compareTo(pivot) <= 0) ++left;
            while (left <= right && list.get(right).compareTo(pivot) >= 0) --right;
            if (left >= right) break;
            Collections.swap(list, left++, right--);
        }
        Collections.swap(list, 0, right);
        return right;
    }

    public static <T extends Comparable<T>> List<T> sort(List<T> list) {
        if (list.size() <= 1) return list;
        int mid = divide(list);
        sort(list.subList(0, mid));
        sort(list.subList(mid+1, list.size()));
        return list;
    }
}
