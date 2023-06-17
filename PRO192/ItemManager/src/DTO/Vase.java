package DTO;

import java.util.Scanner;

public class Vase extends Item {
    
    private int height;
    private String material;

    public Vase() {}

    public Vase(int value, String creator, int height, String material) {
        super(value, creator);
        this.height = height;
        this.material = material;
    }

    public int getHeight() {
        return height;
    }

    public String getMaterial() {
        return material;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public void inputVase() {
        input();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Input height: ");
            String heightString = sc.nextLine();
            try {
                int height = Integer.parseInt(heightString);
                if (height > 0) {
                    this.height = height;
                    break;
                }
                else {
                    System.out.println("Height must >0, try again!");
                }
            }
            catch (Exception e) {
                System.out.println("Height isn't a number, try again!");
            }
        }
        while (true) {
            System.out.print("Input material: ");
            String material = sc.nextLine();
            if (material.length() > 0) {
                this.material = material;
                break;
            }
            else {
                System.out.println("Material empty, try again!");
            }
        }
        // sc.close();
    }

    public void outputVase() {
        output();
        System.out.format("Height: %d\nMaterial: %s\n", getHeight(), getMaterial());
    }
}
