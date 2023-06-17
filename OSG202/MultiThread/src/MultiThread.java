public class MultiThread {

    public static void main(String[] args) {
        Thread tA = new Thread(new Thread() {
            public void run() {
                for(int i=0; i<10; ++i) {
                    System.out.println("A" + i);
                }
            }
        });
        
        Thread tB = new Thread(new Thread() {
            public void run() {
                for (int i = 0; i < 10; ++i) {
                    System.out.println("B" + i);
                }
            }
        });
        
        tA.start();
        tB.start();
    }
}
