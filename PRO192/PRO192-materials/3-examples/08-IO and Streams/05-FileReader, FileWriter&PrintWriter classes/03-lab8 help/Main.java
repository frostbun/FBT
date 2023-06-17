
import java.util.*;
import java.io.*;
class Main {
  public static void main(String args[]) throws Exception {
    
    FileWriter f = new FileWriter("test1.txt");
    f.write("abcABxyz");
    f.close();   
    FileReader g = new FileReader("test1.txt");
    String s = ""; char c; int k;
    while((k= g.read()) != -1) {
       if(k >= (int) 'a' && k <= (int) 'x') k += 2; 
       c = (char) k;
       s += c;
     }
    System.out.println(s);
  } 
}
