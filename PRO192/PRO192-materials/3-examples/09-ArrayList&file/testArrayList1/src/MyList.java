import java.util.*;
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
}
