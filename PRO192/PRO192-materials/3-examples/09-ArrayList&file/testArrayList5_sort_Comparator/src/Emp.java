import java.util.*;
public class Emp {
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
}
