import java.util.Scanner;

public class Part2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number 1: ");
        float a = sc.nextFloat();
        System.out.print("Input number 2: ");
        float b = sc.nextFloat();
        System.out.print("Input the operator(+-*/): ");
        char c = sc.next().charAt(0);
        System.out.println(String.format("%.2f %c %.2f = %.2f", a, c, b, c=='+' ? a+b : c=='-' ? a-b : c=='*' ? a*b : a/b));
    
        sc.close();
    }
}
