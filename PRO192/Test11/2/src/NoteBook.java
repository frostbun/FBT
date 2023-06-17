public class NoteBook extends Book {
    
    private int type;

    public NoteBook() {
    }

    public NoteBook(String name, String author, long price, int type) {
        super(name, author, price);
        this.type = type;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
    
    public void setData() {
        String[] name = getAuthor().split("\\s+");
        int n = name.length-1;
        name[0] = name[0].substring(0, 1).toUpperCase() + name[0].substring(1);
        name[n] = name[n].substring(0, 1).toUpperCase() + name[n].substring(1);
        setAuthor(String.join(" ", name));
    }
    
    public long getValue() {
        return getPrice() - (getType()>30 ? 30 : 15);
    }

    @Override
    public String toString() {
        String s = super.toString();
        return String.format("(%s,%d)", s.substring(0, s.length()-1), getType());
    }
}
