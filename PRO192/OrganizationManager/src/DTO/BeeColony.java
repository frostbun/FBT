package DTO;

public class BeeColony extends Colony implements Role {
    
    private String type;

    public BeeColony() {}

    public BeeColony(int size, String place, String type) {
        super(size, place);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void createWorker() {
        System.out.println("Worker bees perform all the work of the bees");
    }

    @Override
    public String toString() {
        return String.format("The colony’s type is %s, size is about %d, and the place is %s", getType(), getSize(), getPlace());
    }
}
