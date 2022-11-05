package asm1;

public class Main {

    public static void main(String[] args) {
        Data.save(Data.load("customer.dat", "phone.dat"), "result.dat");
    }
}
