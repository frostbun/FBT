import java.util.*;
public class Main
 {
   public static void main(String args[])
     {
       Date h = new Date(2016-1900,4,17);
       Date t = new Date();

       t.setYear(2016-1900);
       t.setMonth(5-1);
       t.setDate(17);

       System.out.println(t);
       System.out.println("Year: " +  (1900+t.getYear()));
       System.out.println("Month: " +  (1+ t.getMonth()));
       System.out.println("Day: " +  t.getDay());

       System.out.println();
     } 
}
