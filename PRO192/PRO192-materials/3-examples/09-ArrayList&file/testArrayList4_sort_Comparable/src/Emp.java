import java.util.*;
public class Emp implements Comparable<Emp> {
  String name; int age; double income;
  Emp() {
  }
  Emp(String xName, int xAge, double xIncome) {
     name=xName;age=xAge;income=xIncome; 
  }
  public String toString() {
     String s="("+name+","+age+","+income+") ";
     return(s);
  }
  public int compareTo(Emp x) {
    if(age<x.age)
        return(-1);
    else if(age==x.age)
       return(name.compareTo(x.name));
        return(1);
  }
}
