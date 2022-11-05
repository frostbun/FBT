package j1_s_p0074;

import java.util.List;

import utils.Reader;

import java.util.ArrayList;

public class Calculator {

    private final Reader reader;

    public Calculator(Reader reader) {
        this.reader = reader;
    }

    private Matrix inputMaxtrix(int row, int column) {        
        List<List<Integer>> input = new ArrayList<>();
        for (int i=0; i<row; ++i) {
            input.add(reader.getIntegerList(column, String.format("Input %d integers of row %d: ", column, i+1)));
        }
        return new Matrix(input);
    }

    public void add() {
        int row = reader.getInteger("Input row: ", 1, Integer.MAX_VALUE);
        int column = reader.getInteger("Input column: ", 1, Integer.MAX_VALUE);
        System.out.println("Matrix 1:");
        Matrix m1 = inputMaxtrix(row, column);
        System.out.println("Matrix 2:");
        Matrix m2 = inputMaxtrix(row, column);
        System.out.format("%s\n+\n%s\n=\n%s\n", m1, m2, Matrix.add(m1, m2));
    }

    public void subtract() {
        int row = reader.getInteger("Input row: ", 1, Integer.MAX_VALUE);
        int column = reader.getInteger("Input column: ", 1, Integer.MAX_VALUE);
        System.out.println("Matrix 1:");
        Matrix m1 = inputMaxtrix(row, column);
        System.out.println("Matrix 2:");
        Matrix m2 = inputMaxtrix(row, column);
        System.out.format("%s\n-\n%s\n=\n%s\n", m1, m2, Matrix.subtract(m1, m2));
    }

    public void multiply() {
        int row1 = reader.getInteger("Input matrix 1 row: ", 1, Integer.MAX_VALUE);
        int column1 = reader.getInteger("Input matrix 1 column / matrix 2 row: ", 1, Integer.MAX_VALUE);
        int row2 = column1;
        int column2 = reader.getInteger("Input matrix 2 column: ", 1, Integer.MAX_VALUE);
        System.out.println("Matrix 1:");
        Matrix m1 = inputMaxtrix(row1, column1);
        System.out.println("Matrix 2:");
        Matrix m2 = inputMaxtrix(row2, column2);
        System.out.format("%s\n*\n%s\n=\n%s\n", m1, m2, Matrix.multiply(m1, m2));
    }

    public static void main(String[] args) {
        String title = "\nMATRIX CALCULATOR";
        String prompt = "Your choice: ";
        List<String> menu = new ArrayList<>();
        menu.add("1. Additdion");
        menu.add("2. Subtraction");
        menu.add("3. Multiplication");
        menu.add("4. Quit");

        try (Reader reader = new Reader()) {
            Calculator calculator = new Calculator(reader);
            int choice;
            while ((choice = reader.getChoice(title, menu, prompt)) != 4) {
                switch (choice) {
                    case 1:
                        calculator.add();
                        break;
                    case 2:
                        calculator.subtract();
                        break;
                    case 3:
                        calculator.multiply();
                }
                reader.getRawString("");
            }
        }
    }
}
