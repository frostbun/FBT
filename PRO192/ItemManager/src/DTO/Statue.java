package DTO;

import java.util.Scanner;

public class Statue extends Item {
    
    private int weight;
    private String colour;

    public Statue() {}

    public Statue(int value, String creator, int weight, String colour) {
        super(value, creator);
        this.weight = weight;
        this.colour = colour;
    }

    public int getWeight() {
        return weight;
    }

    public String getColour() {
        return colour;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void inputStatue() {
        input();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Input weight: ");
            String weightString = sc.nextLine();
            try {
                int weight = Integer.parseInt(weightString);
                if (weight > 0) {
                    this.weight = weight;
                    break;
                }
                else {
                    System.out.println("Weight must >0, try again!");
                }
            }
            catch (Exception e) {
                System.out.println("Weight isn't a number, try again!");
            }
        }
        while (true) {
            System.out.print("Input colour: ");
            String colour = sc.nextLine();
            if (colour.length() > 0) {
                this.colour = colour;
                break;
            }
            else {
                System.out.println("Colour empty, try again!");
            }
        }
        // sc.close();
    }

    public void outputStatue() {
        output();
        System.out.format("Weight: %d\nColour: %s\n", getWeight(), getColour());
    }
}
