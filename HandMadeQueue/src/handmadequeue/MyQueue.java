package handmadequeue;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyQueue<E> {
    private E[] buffer = (E[])new Object[10];
    private int count;
    private ReentrantLock lock = new ReentrantLock();
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
    
    public void put(E e) throws InterruptedException {
        lock.lock();
        try {
            while (count >= buffer.length) {
                notFull.await();
            }
            buffer[count++] = e;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }
    
    public E take() throws InterruptedException {
        lock.lock();
        try {
            while (count <= 0) {
                notEmpty.await();
            }
            E rv = buffer[0];
            System.arraycopy(buffer, 1, buffer, 0, --count);
            notFull.signal();
            return rv;
        } finally {
            lock.unlock();
        }
    }
}
