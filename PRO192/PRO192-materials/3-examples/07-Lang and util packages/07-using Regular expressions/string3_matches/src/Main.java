public class Main {

    public static void main(String[] args) {
      String reg = "[A-Z]*[0-9]+";
      String u;
      u = "CXT12";
      System.out.println(u.matches(reg)); // true
      u = "3CXT12";
      System.out.println(u.matches(reg)); // false
      reg = "[0-9][A-Z]*[0-9][0-9][0-9]"; 
      u = "3X152";
      System.out.println(u.matches(reg)); // true
      u = "3X1527";
      System.out.println(u.matches(reg)); // false
      reg = "[S][E][0-9][0-9][0-9][0-9][0-9]"; 
      u = "SE12345";
      System.out.println(u.matches(reg)); // true
      u = "SE1234";
      System.out.println(u.matches(reg)); // false
    }
    
}
