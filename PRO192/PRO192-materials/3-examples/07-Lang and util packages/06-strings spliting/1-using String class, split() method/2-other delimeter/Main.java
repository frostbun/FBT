import java.util.*;
class Main
 {public static void main(String args[])
   {String s = " Tran Van  |  21  |  500 ";
    String [] a = s.split("[|]");
    System.out.println("a.length = " + a.length);
    for(int i=0;i<a.length;i++) System.out.println(a[i].trim());
    System.out.println();
   }
 }
