package handmadequeue;

public class HandMadeQueue {

    
    public static void main(String[] args) {
        final MyQueue<Integer> mq = new MyQueue<>();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    try {
                        mq.put(i);
//                        Thread.sleep(1);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
                System.out.println("producer complete...");
            }
        }).start();
        new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    try {
                        int v = mq.take();
                        if (v != i) {
                            System.out.println("ERROR!!!!!");
                        }
                        Thread.sleep(1);
                    } catch (InterruptedException ie) {
                        ie.printStackTrace();
                    }
                }
                System.out.println("consumer complete...");
                
            }
        }).start();
    }
    
}
