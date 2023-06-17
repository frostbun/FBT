public class Service {
    
    private String name;
    private double rate;
    private String country;

    public Service() {}

    public Service(String name, String country, double rate) {
        this.name = name;
        this.country = country;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public double getRate() {
        return rate;
    }

    public String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return String.format("%s %s %d", getName(), getCountry(), getRate());
    }
}
