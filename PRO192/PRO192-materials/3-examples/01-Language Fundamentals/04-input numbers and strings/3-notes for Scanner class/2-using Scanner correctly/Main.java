import java.util.*;
class Main
  {
    public static void main(String[] args) throws Exception
     {String code, name; int age; double salary;
       Scanner t = new Scanner(System.in);
       System.out.print("Enter age = ");
       age = t.nextInt();
       t.nextLine();
       System.out.print("Enter salary = ");
       salary = t.nextDouble();
       t.nextLine();
       System.out.print("Enter code = ");
       code = t.nextLine();
       System.out.print("Enter name = ");
       name = t.nextLine();

       System.out.println("age = " + age);
       System.out.println("salary = " + salary);
       System.out.println("code = " + code);
       System.out.println("name = " + name);

     }
  }
