package student1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Student1 {

    public static void main(String[] args) {
        List<Student> ls = new ArrayList<>();
        ls.add(new Student("Fred", 3.5F));
        ls.add(new Student("Sheila", 3.8F));
        ls.add(new Student("Jim", 2.9F));
        System.out.println("List: " + ls);
        
        Collections.sort(ls);
        System.out.println("List: " + ls);
        
        Collections.sort(ls, Student.getGPAComparator());
        System.out.println("List: " + ls);
        
    }
    
}
