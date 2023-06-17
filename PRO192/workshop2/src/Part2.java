import java.util.Scanner;

public class Part2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean check = true;
        while(check) {
            try {
                System.out.print("Enter the string: ");
                String str = sc.nextLine().toUpperCase();
                if(!str.matches("SE\\d{3}")) throw new Exception();
                System.out.format("The string is: %s\n", str);
                check = false;
                
            } catch (Exception e) {
                System.out.println("The string is invalid");
            }
        }

        sc.close();
    }
}
