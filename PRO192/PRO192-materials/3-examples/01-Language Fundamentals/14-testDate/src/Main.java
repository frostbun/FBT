import java.util.*;
public class Main {

    public static void main(String[] args) {
      int xYear, xMonth, xDay;
      xYear = 2019;
      xMonth = 10;
      xDay = 25;
      TestDate t = new TestDate();
      Date x = t.ymdToDate(xYear,xMonth,xDay);
      System.out.println("Date x = " + x);
      System.out.println();
      String s = t.dateToDmyString(x);
      System.out.println("Date x = " + s);
      System.out.println();
    }
    
}
