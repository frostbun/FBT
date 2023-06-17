public class SpecBrick extends Brick {
    
    private int color;

    public SpecBrick() {
    }

    public SpecBrick(String place, int price, int color) {
        super(place, price);
        this.color = color;
    }
    
    public void setData() {
        setPlace(getPlace().substring(0, 2) + "BCA" + getPlace().substring(2));
    }
    
    public int getValue() {
        return color>7 ? getPrice()+9 : getPrice()+6;
    }

    @Override
    public String toString() {
        return String.format("%s, %d", super.toString(), color);
    }
}
