package mylist;

import java.util.Iterator;

public class TestMyList {

    public static void main(String[] args) {
        MyList<String> ml = new MyList<>();
        ml.add("Fred");
        ml.add("Jim");
        ml.add("Sheila");
        ml.add("Bert");
        System.out.println("toString: " + ml);
        
        for (String s : ml) {
            System.out.println("> " + s);
        }
        
        Iterator<String> i1 = ml.iterator();
        Iterator<String> i2 = ml.iterator();
        System.out.println("i1.next() " + i1.next());
        System.out.println("i2.next()                  " + i2.next());
        System.out.println("i1.next() " + i1.next());
        System.out.println("i2.next()                  " + i2.next());
        System.out.println("i2.next()                  " + i2.next());
        System.out.println("i1.next() " + i1.next());
        System.out.println("i1.next() " + i1.next());
        System.out.println("i2.next()                  " + i2.next());
    }
}
