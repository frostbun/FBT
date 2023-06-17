public class Magazine {
    
    private String title;
    private long price;

    public Magazine() {
    }

    public Magazine(String title, long price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title.substring(0, 1).toUpperCase() + title.substring(1);
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", getTitle(), getPrice());
    }
}
