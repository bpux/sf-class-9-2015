package executorserviceone;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class ExecutorServiceOne {

    public static class MyCallable implements Callable<String> {
        private String name;
        private static int next = 1;
        
        public MyCallable() {
            name = "Callable " + next++;
        }
        @Override
        public String call() throws Exception {
            System.out.println(name + " starting...");
            Thread.sleep((int)(ThreadLocalRandom.current().nextInt(2000, 4000)));
            System.out.println(name + " completing...");
            return name;
        }
        
    }
    
    private static final int JOB_COUNT = 4;
    
    public static void main(String[] args) throws Throwable {
        ExecutorService es = Executors.newFixedThreadPool(2);
        Callable<String>[] jobs = new Callable[JOB_COUNT];
        Future<String>[] handles = new Future[JOB_COUNT];
        boolean [] finished = new boolean[JOB_COUNT];
        
        for (int i = 0; i < jobs.length; i++) {
            jobs[i] = new MyCallable();
            handles[i] = es.submit(jobs[i]);
        }
        while (!allTrue(finished)) {
            for (int i = 0; i < handles.length; i++) {
                if (!finished[i] && handles[i].isDone()) {
                    finished[i] = true;
                    String res = handles[i].get();
                    System.out.println("Job " + i + " produced " + res);
                }
            }
        }
        System.out.println("All jobs completed...");
        System.exit(0);
    }
    
    private static boolean allTrue(boolean[] ba) {
        Boolean[] bba = new Boolean[ba.length];
        for (int i = 0; i < ba.length; i++) {
            bba[i] = ba[i];
        }
        return Stream.of(bba)
            .allMatch(b->b);
    }
}
