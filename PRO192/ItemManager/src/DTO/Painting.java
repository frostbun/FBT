package DTO;

import java.util.Scanner;

public class Painting extends Item {
    
    private int height;
    private int width;
    private boolean isWaterColour;
    private boolean isFramed;

    public Painting() {}

    public Painting(int value, String creator, int height, int width, boolean isWaterColour, boolean isFramed) {
        super(value, creator);
        this.height = height;
        this.width = width;
        this.isWaterColour = isWaterColour;
        this.isFramed = isFramed;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public boolean isWaterColour() {
        return isWaterColour;
    }

    public boolean isFramed() {
        return isFramed;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setWaterColour(boolean isWaterColour) {
        this.isWaterColour = isWaterColour;
    }

    public void setFramed(boolean isFramed) {
        this.isFramed = isFramed;
    }

    public void inputPainting() {
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
            System.out.print("Input width: ");
            String widthString = sc.nextLine();
            try {
                int width = Integer.parseInt(widthString);
                if (width > 0) {
                    this.width = width;
                    break;
                }
                else {
                    System.out.println("Width must >0, try again!");
                }
            }
            catch (Exception e) {
                System.out.println("Width isn't a number, try again!");
            }
        }
        while (true) {
            System.out.print("Input WaterColour: ");
            String isWaterColourString = sc.nextLine();
            try {
                boolean isWaterColour = Boolean.parseBoolean(isWaterColourString);
                this.isWaterColour = isWaterColour;
                break;
            }
            catch (Exception e) {
                System.out.println("True/False only!");
            }
        }
        while (true) {
            System.out.print("Input Framed: ");
            String isFramedString = sc.nextLine();
            try {
                boolean isFramed = Boolean.parseBoolean(isFramedString);
                this.isFramed = isFramed;
                break;
            }
            catch (Exception e) {
                System.out.println("True/False only!");
            }
        }
        // sc.close();
    }

    public void outputPainting() {
        output();
        System.out.println("Height: " + getHeight());
        System.out.println("Width: " + getWidth());
        System.out.println("WaterColour: " + isWaterColour());
        System.out.println("Framed: " + isFramed());
    }
}
