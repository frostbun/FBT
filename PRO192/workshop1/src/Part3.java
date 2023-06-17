
import java.util.Scanner;

public class Part3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input number of names: ");
        int n = Integer.parseInt(sc.nextLine());
        String[] name = new String[n];
        for(int i=0; i<n; ++i) {
            System.out.format("Input name[%d]: ", i);
            name[i] = sc.nextLine().toUpperCase();
        }
        for (int i = 0; i < n; ++i) {
            System.out.format("name[%d] = %s\n", i, name[i]);
        }
        
        sc.close();
    }
}
