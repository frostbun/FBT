import java.util.Collections;
import java.util.List;

public class MyBrick implements IBrick {

    @Override
    public int f1(List<Brick> t) {
        int count = 0;
        for(Brick b: t) {
            if(b.getPlace().matches("^[0-9](.*)[a-zA-Z]$")) {
                ++count;
            }
        }
        return count;
    }

    @Override
    public void f2(List<Brick> t) {
        Brick maxOddPrice = null;
        for(Brick b: t) {
            if(b.getPrice()%2 == 1 && (maxOddPrice == null || b.getPrice()>maxOddPrice.getPrice())) {
                maxOddPrice = b;
            }
        }
        if(maxOddPrice != null) {
            maxOddPrice.setPlace("XX");
        }
    }

    @Override
    public void f3(List<Brick> t) {
        Collections.sort(t.subList(0, t.indexOf(Collections.max(t))));
    }
}
