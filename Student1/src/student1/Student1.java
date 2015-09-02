package student1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class Student1 {

    public static <T> List<T> filter(List<T> ls, Predicate<T> ps) {
        List<T> result = new ArrayList<>();
        for (T s : ls) {
            if (ps.test(s)) {
                result.add(s);
            }
        }
        return result;
    } 
    
    
    public static void main(String[] args) {
        List<Student> ls = new ArrayList<>();
        ls.add(new Student("Fred", 3.5F, CourseName.CHEMISTRY));
        ls.add(new Student("Sheila", 3.8F, CourseName.PHYSICS));
        ls.add(new Student("Jim", 2.9F, CourseName.MATH));
        System.out.println("List: " + ls);
        
        Collections.sort(ls);
        System.out.println("List: " + ls);
        
        Collections.sort(ls, Student.getGPAComparator());
        System.out.println("List: " + ls);
        
        Collections.sort(ls, 
            (s1, s2)->s1.getCourseName().compareTo(s2.getCourseName())
        );
        System.out.println("List: " + ls);
        
        Collections.sort(ls, 
            (s1, s2)->{ return s1.getCourseName().compareTo(s2.getCourseName()); }
        );
        System.out.println("List: " + ls);
        
        List<Student> smart = filter(ls, (s) -> s.getGpa() > 3.6F);
        System.out.println("Smart: " + smart);
        
        List<String> lstr = Arrays.asList("Fred", "Jim", "Sheila", "William", "Toby");
        List<String> longNames = filter(lstr, (s) -> s.length()>5);
        System.out.println("Long names " + longNames);
    }
    
}
