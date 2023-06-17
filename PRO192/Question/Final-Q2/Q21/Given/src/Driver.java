public class Driver {
    
    private int code;
    private String name;
    private int year;

    public Driver() {}

    public Driver(int code, String name, int year) {
        this.code = code;
        this.name = name;
        this.year = year;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("%d %s %d", getCode(), getName(), getYear());
    }
}
