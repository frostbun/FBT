import java.util.Scanner;

public class Part1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        boolean check = true;
        while(check) {
            try {
                System.out.print("Enter the number: ");
                int num = Integer.parseInt(sc.nextLine());
                if(num < 1) throw new Exception();
                System.out.format("The number is: %d\n", num);
                check = false;
            }
            catch (Exception e){
                System.out.println("The number is invalid");
            }
        }

        sc.close();
    }
}
