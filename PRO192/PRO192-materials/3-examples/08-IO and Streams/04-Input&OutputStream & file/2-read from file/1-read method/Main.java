import java.io.*;
class Main 
 {public static void main(String [] args) throws Exception
   {
     InputStream in = new FileInputStream("Main.java");
     int c;
     while ((c = in.read()) != -1)
        { System.out.print((char) c);
        }
    in.close();
  }
 }