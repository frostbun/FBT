public class Book {
    
    private String name;
    private String author;
    private long price;

    public Book() {
    }

    public Book(String name, String author, long price) {
        this.name = name;
        this.author = author;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public long getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("(%s,%s,%d)", getName(), getAuthor(), getPrice());
    }
}
