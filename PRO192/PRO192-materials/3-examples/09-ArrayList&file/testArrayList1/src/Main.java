public class Main {

    public static void main(String[] args) {
      String [] a = {"Hoa","La","Canh","Cay","Goc","Re"};
      int [] b = {22,21,24,19,18,20};
      double [] c = {500,700,400,200,600,550};
      MyList u = new MyList();
      u.addMany(a,b,c);
      u.display();
      System.out.println();
    }
    
}
