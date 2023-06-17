public class Brick implements Comparable<Brick> {

    private String place;
    private int price;

    public Brick() {
    }

    public Brick(String place, int price) {
        this.place = place;
        this.price = price;
    }

    public String getPlace() {
        return place;
    }

    public int getPrice() {
        return price;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Brick other) {
        return Integer.compare(this.getPrice(), other.getPrice());
    }
}
