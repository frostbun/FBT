import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException  {
     String fname1 = "emp.txt";
     String fname2 = "emp1.txt";
     MyList t = new MyList();
     t.loadFileFR(fname1);
     t.display();
     System.out.println();
     t.input();
     t.saveFileFR(fname1);
     t.display();
     System.out.println();
     
     System.out.println();
    }
    
}
