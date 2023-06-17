public class TaxiDriver extends Driver {
    
    private int certificateDate;
    private int seniority;

    public TaxiDriver() {}

    public TaxiDriver(int code, String name, int year, int certificateDate) {
        super(code, name, year);
        this.certificateDate = certificateDate;
    }

    public int getSeniority() {
        return 2018 - certificateDate;
    }

    public void setSeniority() {
        seniority = 2018 - certificateDate;
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", super.toString(), certificateDate, getSeniority());
    }
}
