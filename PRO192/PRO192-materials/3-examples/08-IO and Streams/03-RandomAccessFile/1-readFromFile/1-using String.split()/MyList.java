import java.util.*;
import java.io.*;
public class MyList {
  ArrayList<Person> t;
  MyList() {
   t = new ArrayList<Person>();   
  }
  boolean isEmpty() {
    return(t.isEmpty());  
  }
 void clear() {
    t.clear(); 
 }
 void add(Person x) {
    t.add(x); 
 }
 void display() {
   int i,n; n = t.size();
   for(i=0;i<n;i++) System.out.println(t.get(i));
   System.out.println();
 }
 int size() {
   return(t.size());  
 }
 void loadFile(String fname) throws IOException {
   RandomAccessFile f = new RandomAccessFile(fname,"r");
   String s,sName,sAge,sIncome; int xAge; double xIncome;
   String [] a;Person x;
   while(true) {
     s = f.readLine();
     if(s==null || s.trim().equals("")) break;
     a = s.split("[|]");
     sName=a[0].trim();
     sAge=a[1].trim();
     sIncome = a[2].trim();
     xAge = Integer.parseInt(sAge);
     xIncome = Double.parseDouble(sIncome);
     x = new Person(sName,xAge,xIncome);
     add(x);
   }
   f.close();
 }

void saveFile(String fname) throws IOException {
   RandomAccessFile f = new RandomAccessFile(fname,"rw");
   Person x; int i,n;
   n = size();
   for(i=0;i<n;i++) {
     x = t.get(i);
     f.writeBytes(x.name + " || " + x.age + " || " + x.income + "\r\n");
   }
   f.close();
 }
}
