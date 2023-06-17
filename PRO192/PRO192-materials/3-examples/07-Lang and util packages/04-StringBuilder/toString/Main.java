public class Main 
  {
       public static void main(String args[])
            {
        String s = "123456 78";
        StringBuilder t = new StringBuilder(s);
        t.reverse();
        String u = t.toString();
        System.out.println(u);
             }
  }
//String substring(int startIndex);
