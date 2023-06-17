public class SpecCala extends Cala {
    
    private int color;

    public SpecCala() {
    }

    public SpecCala(String owner, int price, int color) {
        super(owner, price);
        this.color = color;
    }
    
    public void setData() {
        String s = getOwner();
        if(s.length() < 2) {
            return;
        }
        String owner = s.substring(0, 1) + "XX";
        if(s.length() > 2) {
            owner += s.substring(2);
        }
        setOwner(owner);
    }
    
    public int getValue() {
        return getPrice() + (color%2==1 ? 3 : 7);
    }

    @Override
    public String toString() {
        return super.toString() + ", " + color;
    }
}
