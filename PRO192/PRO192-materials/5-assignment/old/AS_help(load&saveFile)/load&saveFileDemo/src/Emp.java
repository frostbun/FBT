import java.util.*;
public class Emp {
  String name; int age; double sal;
  Emp() {
  }
  Emp(String xName, int xAge, double xSal) {
      name = xName; age = xAge; sal = xSal;
  }
  public String toString() {
    String s = "(" + name + "," + age + "," + sal + ") ";
    return(s);
  }
  void input() {
    Scanner t = new Scanner(System.in);
    System.out.print("Enter name: ");
    name = t.nextLine();
    System.out.print("Enter age: ");
    age = t.nextInt();
    System.out.print("Enter salary: ");
    sal = t.nextDouble();
  }
}
