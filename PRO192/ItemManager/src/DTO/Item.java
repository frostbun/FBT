package DTO;

import java.util.Scanner;

public class Item {

    private int value;
    private String creator;

    public Item() {}

    public Item(int value, String creator) {
        this.value = value;
        this.creator = creator;
    }

    public int getValue() {
        return value;
    }

    public String getCreator() {
        return creator;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }
    
    public void input() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Input value: ");
            String valueString = sc.nextLine();
            try {
                int value = Integer.parseInt(valueString);
                if (value > 0) {
                    this.value = value;
                    break;
                }
                else {
                    System.out.println("Value must >0, try again!");
                }
            }
            catch (Exception e) {
                System.out.println("Value isn't a number, try again!");
            }
        }
        while (true) {
            System.out.print("Input creator: ");
            String creator = sc.nextLine();
            if (creator.length() > 0) {
                this.creator = creator;
                break;
            }
            else {
                System.out.println("Creator empty, try again!");
            }
        }
        // sc.close();
    }

    public void output() {
        System.out.format("Value: %d\nCreator: %s\n", getValue(), getCreator());
    }
}
