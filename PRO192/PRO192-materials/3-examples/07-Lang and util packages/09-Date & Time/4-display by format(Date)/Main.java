import java.util.*;
public class Main {
  public static void main(String[] args) {
   Date x = new Date();
   int   xYear, xMonth, xDate, xDayOfWeek;
   xYear = 1900 + x.getYear();
   xMonth = 1+ x.getMonth();
   xDate = x.getDate();
   xDayOfWeek = x.getDay();
   String dmyDate = String.format("%d - %d - %d",xDate, xMonth, xYear);

   System.out.println("Today is " + dmyDate);
   System.out.println("Day of week of today is " + xDayOfWeek);

  }
}
