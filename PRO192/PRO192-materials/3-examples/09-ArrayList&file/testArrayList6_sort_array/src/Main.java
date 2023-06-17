import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
      MyList u = new MyList();
      String fname = "emp.txt";
      u.loadFile(fname);
      System.out.println("Test sorting by age and name");
      System.out.println("Before sorting:");
      u.display();
      System.out.println("After sorting:");
      u.sortByAgeName(3,6);
      u.display();
      System.out.println();
      
    }
    
}
