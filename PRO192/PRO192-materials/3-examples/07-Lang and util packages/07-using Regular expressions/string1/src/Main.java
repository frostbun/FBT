public class Main {

    public static void main(String[] args) {
      String x,y,z;
      x = "ABCD";
      y = " EF";
      z = x + " " + y;
      System.out.println(z);
      x = new String("Hoa La");
      char [] u = {'h','o','a',' ','l','a'};
      x = new String(u);
      System.out.println(x);
      x = new String("Hoa");
      y = new String("Hoa");
      System.out.println(x==y); //false
      System.out.println(x.equals(y)); //true
      x = "Hoa";
      y = "hoa";
      System.out.println(x.compareTo(y)); //<0
      System.out.println(x.compareToIgnoreCase(y)); //0
      char pt='+';
      int a,b,c;
      a=15;b=7;
      if(pt=='+')
         c = a+b;
      else if (pt=='-')
          c = a-b;
      else if (pt=='*')
          c = a*b;
         else
           c = a/b;
          
      System.out.println(""+ a + pt + b + " = " + c);
      
    }
    
}
