import java.util.Scanner;

public class Part1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number if rows: ");
        int rows = sc.nextInt();
        System.out.print("Enter number if cols: ");
        int cols = sc.nextInt();
        System.out.println("Enter the matrix: ");

        int sum = 0;
        int[][] matrix = new int[rows][cols];
        for(int i=0; i<rows; ++i) {
            for(int j=0; j<cols; ++j) {
                System.out.format("matrix[%d][%d] = ", i, j);
                sum += matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Matrix inputted:");
        for(int i=0; i<rows; ++i) {
            for(int j=0; j<cols; ++j) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + (1.0*sum)/(rows*cols));

        sc.close();
    }
}
