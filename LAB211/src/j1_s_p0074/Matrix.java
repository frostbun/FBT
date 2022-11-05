package j1_s_p0074;

import java.util.List;
import java.util.ArrayList;

public class Matrix {

    private final List<List<Integer>> value;

    public Matrix(List<List<Integer>> value) throws ArithmeticException {
        // if (value.isEmpty()) {
        //     throw new ArithmeticException("Empty matrix exception");
        // }
        // if (value.get(0).isEmpty()) {
        //     throw new ArithmeticException("Empty matrix exception");
        // }
        // for (int i=1; i<value.size(); ++i) {
        //     if (value.get(i).size() != value.get(i-1).size()) {
        //         throw new ArithmeticException("Invalid matrix row size exception");
        //     }
        // }
        this.value = value;
    }

    public int getValue(int row, int column) {
        return value.get(row).get(column);
    }

    public int getHeigh() {
        return value.size();
    }

    public int getWidth() {
        return value.get(0).size();
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for(List<Integer> row: value) {
            for(int v: row) {
                str.append(String.format("[%d]", v));
            }
            str.append("\n");
        }
        str.deleteCharAt(str.length()-1);
        return str.toString();
    }

    public static Matrix add(Matrix m1, Matrix m2) throws ArithmeticException {
        // if (m1.getHeigh() != m2.getHeigh() || m1.getWidth() != m2.getWidth()) {
        //     throw new ArithmeticException("Matrix size not match exception");
        // }
        List<List<Integer>> sum = new ArrayList<>();
        for (int row=0; row<m1.getHeigh(); ++row) {
            sum.add(new ArrayList<>());
            for (int column=0; column<m1.getWidth(); ++column) {
                sum.get(row).add(m1.getValue(row, column) + m2.getValue(row, column));
            }
        }
        return new Matrix(sum);
    }

    public static Matrix subtract(Matrix m1, Matrix m2) throws ArithmeticException {
        // if (m1.getHeigh() != m2.getHeigh() || m1.getWidth() != m2.getWidth()) {
        //     throw new ArithmeticException("Matrix size not match exception");
        // }
        List<List<Integer>> diff = new ArrayList<>();
        for (int row=0; row<m1.getHeigh(); ++row) {
            diff.add(new ArrayList<>());
            for (int column=0; column<m1.getWidth(); ++column) {
                diff.get(row).add(m1.getValue(row, column) - m2.getValue(row, column));
            }
        }
        return new Matrix(diff);
    }

    public static Matrix multiply(Matrix m1, Matrix m2) throws ArithmeticException {
        // if (m1.getWidth() != m2.getHeigh()) {
        //     throw new ArithmeticException("Matrix size not match exception");
        // }
        List<List<Integer>> prod = new ArrayList<>();
        for (int row=0; row<m1.getHeigh(); ++row) {
            prod.add(new ArrayList<>());
            for (int column=0; column<m2.getWidth(); ++column) {
                int tmp = 0;
                for (int i=0; i<m1.getWidth(); ++i) {
                    tmp += m1.getValue(row, i) * m2.getValue(i, column);
                }
                prod.get(row).add(tmp);
            }
        }
        return new Matrix(prod);
    }
}