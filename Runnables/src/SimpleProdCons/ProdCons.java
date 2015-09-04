package SimpleProdCons;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProdCons {

    static class Pair<T> {

        private T left;
        private T right;

        public T getLeft() {
            return left;
        }

        public void setLeft(T left) {
            this.left = left;
        }

        public T getRight() {
            return right;
        }

        public void setRight(T right) {
            this.right = right;
        }

        public Pair(T left, T right) {
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return "Pair{" + "left=" + left + ", right=" + right + '}';
        }
    }

    public static void main(String[] args) {
        final BlockingQueue<Pair<Integer>> q
            = new ArrayBlockingQueue<Pair<Integer>>(16);
        Runnable p = new Runnable() {
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    Pair<Integer> p = new Pair<>(i, i);
                    try {
                        q.put(p);
//                        Thread.sleep(10);
                        p = null;
                    } catch (InterruptedException ioe) {
                    }
                }
                System.out.println("Producer completed...");
            }
        };
        Runnable c = new Runnable() {
            public void run() {
                for (int i = 0; i < 10_000; i++) {
                    try {
                        Pair<Integer> p = q.take();
                        assert p.left.equals(p.right) 
                            && p.right == i
                            : "failed left " + p.left 
                              + " right " + p.right + " i " + i ;
                        Thread.sleep(1);
                    } catch (InterruptedException ioe) {
                    }
                }
                System.out.println("Consumer completed...");
            }
        };
        
        new Thread(p).start();
        new Thread(c).start();
        System.out.println("Main completed...");
    }
}
