import java.io.*;
class Main 
 {public static void main(String [] args) throws Exception
   {
    OutputStream o = new FileOutputStream("test.txt");
    o.write('A');
    byte [] a = {'a','b','c'};
    o.write(a);
    o.close();
    System.out.println();
  }
 }