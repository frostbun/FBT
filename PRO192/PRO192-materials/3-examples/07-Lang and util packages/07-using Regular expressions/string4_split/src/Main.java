public class Main {

    public static void main(String[] args) {
      String x = "   hoa, la   canh.  cay  ";
      x = x.trim();
      String [] a;
      String reg = "[ ,.]+";
      a = x.split(reg);
      for(int i=0;i<a.length;i++)
         System.out.println(a[i]);
      System.out.println();
    }
    
}
