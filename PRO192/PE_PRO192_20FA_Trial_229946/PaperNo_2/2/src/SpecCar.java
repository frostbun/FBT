public class SpecCar extends Car {
    
    private int type;

    public SpecCar() {
    }

    public SpecCar(String maker, int price, int type) {
        super(maker, price);
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("%s, %d", super.toString(), type);
    }
    
    public void setData() {
        setMaker("XZ" + getMaker());
    }
    
    public int getValue() {
        return getPrice() + (type<7 ? 10 : 15);
    }
}
