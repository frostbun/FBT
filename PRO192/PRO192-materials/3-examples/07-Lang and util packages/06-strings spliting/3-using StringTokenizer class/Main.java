import java.util.*;
public class Main
 {
  public static void main(String[] args) throws Exception
   {
    // using default delimiter
    String a = "ABC UV XYZ";
    String s;
    StringTokenizer t = new StringTokenizer(a);
    while(t.hasMoreTokens()) 
      {s = t.nextToken();
       System.out.println(s);
      }
    System.out.println();

    // using specified delimiter
    String b = "AB C | UV | X YZ";
    t = new StringTokenizer(b,"|");
    while(t.hasMoreTokens()) 
      {s = t.nextToken();
       System.out.println(s);
      }
    System.out.println();

   }
}
