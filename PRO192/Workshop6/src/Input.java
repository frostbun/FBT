import java.util.Scanner;

public class Input {
    
    public static int inputInt(String message, int min, int max) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print(message);
            try {
                int input = Integer.parseInt(sc.nextLine());
                if(input>=min && input<=max) {
                    return input;
                }
                System.out.println("Invalid input, try again!");
            }
            catch(Exception e) {
                System.out.println("Invalid input, try again!");
            }
        }
    }
    
    public static String inputNonBlankStr(String message) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print(message);
            String input = sc.nextLine();
            if(input.length() > 0) {
                return input;
            }
            System.out.println("Invalid input, try again!");
        }
    }

    public static String inputPattern(String message, String pattern) {
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print(message);
            String input = sc.nextLine();
            if(input.matches(pattern)) {
                return input;
            }
            System.out.println("Invalid input, try again!");
        }
    }

    public static int getChoice(String[] options) {
        for(int i=0; i<options.length; ++i) {
            System.out.format("%d. %s\n", i+1, options[i]);
        }
        return inputInt(String.format("Choose 1-%d: ", options.length), 1, options.length);
    }
}
