import java.util.*;
import java.text.SimpleDateFormat;

class Main 
 {static void display(Date d)
    {
      System.out.println(" Year: " + (1900 + d.getYear()));
      System.out.println(" Month: " + (d.getMonth()+1));
      System.out.println(" Date: " + d.getDate());
      System.out.println(" Day of week: " + (d.getDay()+1));
      System.out.println(" Hour: " + d.getHours());
      System.out.println(" Minute: " + d.getMinutes());
      System.out.println(" Second: " + d.getSeconds());
      System.out.println(" Milli seconds from 1900: " + System.currentTimeMillis());
    }
   public static void main(String [] args) throws Exception
   {Date d = new Date();
     display(d);

     int xYear = 2016;
     int xMonth = 5;
     int xDate = 18;
     System.out.println();
 
     Date x = new Date(xYear - 1900, xMonth - 1, xDate);
     display(x); 
     SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy");
     String y = sd.format(x);
     System.out.println();

     System.out.print("Date in dd/MM/yyyy format: ");
     System.out.println(y);

     System.out.println();
   }
  }

