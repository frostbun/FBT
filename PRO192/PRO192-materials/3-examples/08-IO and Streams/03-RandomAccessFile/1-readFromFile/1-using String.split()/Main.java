import java.io.*;
public class Main {

    public static void main(String[] args) throws IOException {
     String fname="person.txt";
     String fname_r = "report.txt";
     MyList t = new MyList();
     t.loadFile(fname);
     t.display();
     t.saveFile(fname_r);
     System.out.println();
    }
    
}
