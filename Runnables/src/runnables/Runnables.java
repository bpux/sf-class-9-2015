package runnables;

public class Runnables {

    public static void main(String[] args) {
        Runnable r = new Runnable() {
            private int i = 0;
            public void run() {
                for (; i < 10_000; i++) {
                    System.out.println(Thread.currentThread().getName()
                        + " i is " + i);
                }
            }
        };
        
        Thread t = new Thread(r);
        t.start();
        Thread t2 = new Thread(r);
        t2.start();
        System.out.println("Finished!");
    }
    
}
