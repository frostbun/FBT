import java.util.List;

public class MyService implements IService {
    
    public double f1(List<Service> a, double rate) {
        double ret = 0;
        for(Service s: a) {
            if(s.getRate() >= rate) {
                ret += s.getRate();
            }
        }
        return ret;
    }

    public int f2(List<Service> a, String country) {
        int ret = 0;
        for(Service s: a) {
            if(s.getCountry().equalsIgnoreCase(country)) {
                ++ret;
            }
        }
        return ret;
    }

    public void f3(List<Service> a, String country) {
        for(Service s: a) {
            if(s.getCountry().toLowerCase().contains(country.toLowerCase())) {
                System.out.println(s);
            }
        }
    }
}
