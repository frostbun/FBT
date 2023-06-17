public class Person {
 String name; int age; double income;
 Person() {
     
 }
 Person(String xName, int xAge, double xIncome) {
    name=xName;age=xAge;income=xIncome; 
 }
 public String toString() {
    String s = "("+name+","+age+","+income+") ";
    return(s);
 }
}
