import java.util.*;
public class Main {
  public static void main(String[] args) {
  Calendar t = Calendar.getInstance();
   int   xYear, xMonth, xDay, xDayOfWeek;

    xYear = t.get(Calendar.YEAR);
    xMonth = t.get(Calendar.MONTH)+1;
    xDay = t.get(Calendar.DAY_OF_MONTH);
    xDayOfWeek = t.get(Calendar.DAY_OF_WEEK);
    String dmyDate = String.format("%d - %d - %d",xDay, xMonth, xYear);

   System.out.println("Today is " + dmyDate);
  }
}
