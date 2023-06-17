public class Car implements Comparable<Car> {

    private String maker;
    private int rate;

    public Car() {
    }

    public Car(String maker, int rate) {
        this.maker = maker;
        this.rate = rate;
    }

    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public int compareTo(Car other) {
        if(this.getMaker().equals(other.getMaker())) {
            return Integer.compare(other.getRate(), this.getRate());
        }
        return this.getMaker().compareTo(other.getMaker());
    }
}
