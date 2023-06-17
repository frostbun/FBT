import java.util.Collections;
import java.util.List;

public class MyCar implements ICar {

    @Override
    public int f1(List<Car> t) {
        int sumRate = 0;
        for(Car c: t) {
            sumRate += c.getRate();
        }
        return sumRate/t.size();
    }

    @Override
    public void f2(List<Car> t) {
        int minIndex = 0;
        int maxIndex = 0;        
        int minRate = t.get(0).getRate();
        int maxRate = t.get(0).getRate();
        
        for(int i=1; i<t.size(); ++i) {
            int curRate = t.get(i).getRate();
            if(curRate > maxRate) {
                maxIndex = i;
                maxRate = curRate;
            }
            if(curRate < minRate) {
                minIndex = i;
                minRate = curRate;
            }
        }
        Collections.swap(t, minIndex, maxIndex);
    }

    @Override
    public void f3(List<Car> t) {
        Collections.sort(t);
    }
}
