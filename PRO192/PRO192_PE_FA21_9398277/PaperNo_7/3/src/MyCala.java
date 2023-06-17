import java.util.Collections;
import java.util.List;

public class MyCala implements ICala {

    @Override
    public int f1(List<Cala> t) {
        int count = 0;
        for(Cala c: t) {
            if(Character.isLetter(c.getOwner().charAt(1))) {
                ++count;
            }
        }
        return count;
    }

    @Override
    public void f2(List<Cala> t) {
        
        Cala min = null;
        for(Cala c: t) {
            if(min == null || c.getPrice() < min.getPrice()) {
                min = c;
            }
        }
        
        for(Cala c: t) {
            if(c != min && c.getPrice() == min.getPrice()) {
                t.remove(c);
                return;
            }
        }
    }

    @Override
    public void f3(List<Cala> t) {
        Collections.sort(t);
    }
}
