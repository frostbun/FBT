import java.util.*;
import java.text.SimpleDateFormat;
public class Main {
  public static void main(String[] args) {
   // SimpleDateFormat  df = new SimpleDateFormat("dd-mm-yyyy"); /* incorrect usage */
   SimpleDateFormat  df = new SimpleDateFormat("dd-MM-yyyy");
   String xDate = df.format(new Date());
   System.out.println("Today is " + xDate);
  }
}
