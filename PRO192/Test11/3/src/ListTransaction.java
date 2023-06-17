
import java.util.Collections;
import java.util.List;

public class ListTransaction implements ITransaction {

    @Override
    public void f1(List<Transaction> list) {
        Transaction max = null;
        for(Transaction t: list) {
            if(max == null || t.getMoney() > max.getMoney()) {
                max = t;
            }
        }
        
        Transaction secondMax = null;
        for(Transaction t: list) {
            if(t == max) {
                continue;
            }
            if(secondMax == null || t.getMoney() > secondMax.getMoney()) {
                secondMax = t;
            }
        }
        
        System.out.println(secondMax);
    }

    @Override
    public int f2(List<Transaction> list, int i, long l) {
        int count = 0;
        for(Transaction t: list) {
            if(t.getYear() == i && t.getMoney() >= l) {
                ++count;
            }
        }
        return count;
    }

    @Override
    public void f3(List<Transaction> list) {
        Collections.sort(list);
    }
}
