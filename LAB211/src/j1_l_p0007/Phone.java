package j1_l_p0007;

public class Phone {

    private final String model;
    private String cpu;
    private String ram;
    private String primaryCamera;
    private String screenSize;
    private double price;
    private String color;
    private String brand;

    public Phone(String model, String cpu, String ram, String primaryCamera, String screenSize, double price, String color, String brand) {
        this.model = model;
        this.cpu = cpu;
        this.ram = ram;
        this.primaryCamera = primaryCamera;
        this.screenSize = screenSize;
        this.price = price;
        this.color = color;
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getPrimaryCamera() {
        return primaryCamera;
    }

    public void setPrimaryCamera(String primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public String getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(String screenSize) {
        this.screenSize = screenSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return String.format(
            "%-10s | %-30s | %-30s | %-30s | %-11s | %-10.2f | %-10s | %s",
            model,
            cpu,
            ram,
            primaryCamera,
            screenSize,
            price,
            color,
            brand
        );
    }

}
