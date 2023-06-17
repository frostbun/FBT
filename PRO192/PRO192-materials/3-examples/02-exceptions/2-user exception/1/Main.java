import java.util.*;
class MyException extends Exception
 {public MyException(String s)
    {super(s);
    }
 }
class Test
 {int x=0;
  public void input() throws MyException
   {Scanner h = new Scanner(System.in);
    try 
     {System.out.print(" Enter x (>=10): ");
      x = h.nextInt();
      if(x<10) throw new MyException("Sai roi");
      x=100;
     }
     catch(MyException e) {System.out.println(e.getMessage());}
   }
  public void display()
   {System.out.println(" x = "+x);
   }
 }
public class Main
 {public static void main(String args[])
    { Test g = new Test();
      try {g.input();} catch(Exception e) {}
      g.display();    
    }
 }