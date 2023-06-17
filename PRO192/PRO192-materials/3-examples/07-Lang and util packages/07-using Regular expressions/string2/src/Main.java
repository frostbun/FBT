public class Main {

    public static void main(String[] args) {
      String x = "  hoa la  ";
      System.out.println("AB" + x + "CD");
      x = x.trim();
      System.out.println("AB" + x + "CD");
      x = x.toUpperCase();
      System.out.println(x);
      x = "abcdefgh";
      System.out.println(x.charAt(3)); // d
      System.out.println(x.substring(3)); // defgh
      System.out.println(x.substring(3,5)); // de
      System.out.println(x.indexOf("def")); // 3
      System.out.println(x.indexOf("gef")); // -1
           
      

    }
    
}
