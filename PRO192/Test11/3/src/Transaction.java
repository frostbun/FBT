public class Transaction implements Comparable<Transaction> {
    
    private String time;
    private long money;

    public Transaction() {
    }

    public Transaction(String time, long money) {
        this.time = time;
        this.money = money;
    }

    public String getTime() {
        return time;
    }

    public long getMoney() {
        return money;
    }
    
    public int getYear() {
        return Integer.parseInt(time.split("/")[2]);
    }

    @Override
    public int compareTo(Transaction other) {
        return Integer.compare(this.getYear(), other.getYear());
    }

    @Override
    public String toString() {
        return String.format("%s: %d", getTime(), getMoney());
    }
}
