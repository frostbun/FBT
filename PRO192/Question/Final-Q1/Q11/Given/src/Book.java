public class Book {

    private String code;
    private String title;
    private int quantity;
    private double price;

    public Book() {}

    public Book(String code, String title, double price, int quantity) {
        this.code = code;
        this.title = title;
        this.price = price;
        this.quantity = quantity;
    }

    public String getCode() {
        return code.toUpperCase();
    }

    public String getTitle() {
        return title;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%s %s %.2lf %d %.2lf", getCode(), getTitle(), getPrice(), getQuantity(), getPrice() * getQuantity());
    }
}
