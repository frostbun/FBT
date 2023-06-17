import java.util.*;
import java.io.*;
public class MyList {
  ArrayList<Emp> t;
  MyList() {
    t=new ArrayList<Emp>();  
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
  void addMany(String [] a, int [] b, double [] c) {
    int n,i; n=a.length;
    for(i=0;i<n;i++) add(new Emp(a[i],b[i],c[i]));
  }
  void display() {
     int n,i;
     n=t.size();
     Emp x;
     for(i=0;i<n;i++) {
        x = t.get(i);
       System.out.println(x);
     }
  }
  void loadFile(String fname) throws IOException {
     FileReader fr = new FileReader(fname);
     BufferedReader br = new BufferedReader(fr);
     String s, xName; int xAge; double xIncome; 
     String [] a;
     while(true) {
       s = br.readLine();
       if(s==null) break;
       s = s.trim();
       if(s.length()<3) break;
       a = s.split("[|]");
       xName = a[0];
       xAge = Integer.parseInt(a[1].trim());
       xIncome = Double.parseDouble(a[2].trim());
       add(new Emp(xName,xAge,xIncome));
     }
     fr.close();
     br.close();
  }
  void saveToFile(String fname) throws IOException {
     FileWriter fw = new FileWriter(fname);
     PrintWriter pw = new PrintWriter(fw);
     Emp x; int n,i;
     n = t.size();
     for(i=0;i<n;i++) {
        x = t.get(i);
        pw.printf("%10s | %5d | %5.1f\r\n",x.name,x.age,x.income);
     }
     pw.close();
  }
}
