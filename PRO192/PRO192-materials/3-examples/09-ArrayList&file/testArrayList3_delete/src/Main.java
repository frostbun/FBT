import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
      String [] a = {"Hoa","La","Canh","Cay","Goc","Re"};
      int [] b = {22,21,24,19,18,20};
      double [] c = {500,700,400,200,600,550};
      MyList u = new MyList();
      u.addMany(a,b,c);
      u.display();
      System.out.println();
      String fname="emp.txt";
      u.loadFile(fname);
      u.display();
      System.out.println();
      fname="emp_rep.txt";
      u.saveToFile(fname);
      System.out.println();
      System.out.println("Test deleting by name");
      System.out.println("Before deleting:");
      u.display();
      String xName;
      Scanner sc = new Scanner(System.in);
      System.out.print("Enter name to be deleted: ");
      xName = sc.nextLine();
      System.out.println("After deleting:");
      u.remove(xName);
      u.display();
      System.out.println();
      
    }
    
}
