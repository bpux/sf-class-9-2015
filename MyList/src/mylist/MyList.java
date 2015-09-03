package mylist;

import java.util.Iterator;
import java.util.stream.Stream;

public class MyList<E> implements Iterable<E> {
    @SuppressWarnings("unchecked")
    private E[] data = (E[])new Object[20];
    private int count = 0;
    
    public void add(E item) {
        // will fail if overflowed
        data[count++] = item;
    }
    
    public E get(int idx) {
        if (idx < count) {
            return data[idx];
        }
        throw new IndexOutOfBoundsException();
    }
    
    @Override
    public String toString() {
        return "MyList[ "
            + Stream.of(data)
            .limit(count)
            .map(i->""+i)
            .reduce((t,u)->t + ", "+ u)
            + " ]";
    }
    
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int progress = 0;
            @Override
            public boolean hasNext() {
                return progress < count;
            }

            @Override
            public E next() {
                return data[progress++];
            }
        };
    }
    
}
