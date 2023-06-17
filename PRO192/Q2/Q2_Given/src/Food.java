public class Food extends Product {

    private String date;
    private int expireDate;

    public Food(String code, String name, double price, int quantity, String date, int expireDate) {
        super(code, name, price, quantity);
        this.date = date;
        this.expireDate = expireDate;
    }

    @Override
    public double getPrice() {
        if (getQuantity() <= 4) {
            return super.getPrice();
        }
        else {
            return super.getPrice() * 0.9;
        }
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getExpireDate() {
        return expireDate;
    }

    public void setExpireDate(int expireDate) {
        this.expireDate = expireDate;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + date + "\t" + expireDate;
    }
}
