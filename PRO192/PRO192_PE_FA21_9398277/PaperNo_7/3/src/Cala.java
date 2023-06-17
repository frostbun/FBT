public class Cala implements Comparable<Cala> {

    private String owner;
    private int price;

    public Cala() {
    }

    public Cala(String owner, int price) {
        this.owner = owner;
        this.price = price;
    }

    public String getOwner() {
        return owner;
    }

    public int getPrice() {
        return price;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public int compareTo(Cala other) {
        return Character.compare(other.getOwner().charAt(1), this.getOwner().charAt(1));
    }

    @Override
    public String toString() {
        return getOwner() + ", " + getPrice();
    }
}
