import java.util.*;
import java.io.*;
public class MyList {
  ArrayList<Emp> t;
  MyList() {
    t = new ArrayList<Emp>();  
  }
void clear() {
  t.clear();  
}
boolean isEmpty() {
  return(t.isEmpty());  
}
void add(Emp x) {
  t.add(x);  
}
void display() {
  for(int i=0;i<t.size(); i++) System.out.print(t.get(i));
  System.out.println();
}
void input() {
 Emp x; int n,i;
 Scanner t = new Scanner(System.in);
 System.out.print("Enter number of employees: ");
 n = t.nextInt();
 for(i=0;i<n;i++) {
   x = new Emp();
   x.input();
   add(x);
 }
}
  void loadFileRA(String fname) throws IOException { // Using RandomAccessFile class
   RandomAccessFile f = new RandomAccessFile(fname,"rw");
   String s; String [] a;
   String xName; int xAge; double xSal;
   while(true) {
     s = f.readLine();
     if(s==null || s.trim().length()<3) break;
     a = s.split("[|]");
     xName = a[0].trim();
     xAge = Integer.parseInt(a[1].trim());
     xSal = Double.parseDouble(a[2].trim());
     add(new Emp(xName,xAge,xSal));
   }
   f.close();
 }

  void loadFileFR(String fname) throws IOException { // Using FileReader class
   FileReader fr = new FileReader(fname);
   BufferedReader br = new BufferedReader(fr);
   String s; String [] a;
   String xName; int xAge; double xSal;
   while(true) {
     s = br.readLine();
     if(s==null || s.trim().length()<3) break;
     a = s.split("[|]");
     xName = a[0].trim();
     xAge = Integer.parseInt(a[1].trim());
     xSal = Double.parseDouble(a[2].trim());
     add(new Emp(xName,xAge,xSal));
   }
   fr.close();
   br.close();
 }

  void saveFileFR(String fname) throws IOException { // Using FileReader class
   FileWriter fw = new FileWriter(fname);
   PrintWriter pw = new PrintWriter(fw);
   int n,i; Emp x;
   n = t.size();
   for(i=0;i<n;i++) {
     x = t.get(i);
     pw.printf("%10s | %2d | %.1f\r\n",x.name,x.age,x.sal);
    }
   fw.close();
   pw.close();
  }

}
