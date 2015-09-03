package student1;

import java.util.Comparator;
import java.util.function.Predicate;

public class Student implements Comparable<Student> {

    private String name;
    private float gpa;
    private CourseName courseName;

    public Student(String name, float gpa, CourseName cn) {
        this.name = name;
        this.gpa = gpa;
        this.courseName = cn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public CourseName getCourseName() {
        return courseName;
    }

    public void setCourseName(CourseName courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", gpa=" + gpa + ", courseName=" + courseName + '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);

    }

//    public static Comparator<Student> getGPAComparator() {
//        return new Comparator<Student>() {
//
//            @Override
//            public int compare(Student o1, Student o2) {
//                return new Float(o1.gpa).compareTo(o2.gpa);
//            }
//
//        };
//    }
    //
    //    public static Comparator<Student> getGPAComparator() {
    //        return gpaComparator;
    //    }
    //    
    //    private static Comparator<Student> gpaComparator = new /*GPAComparator();
    //    
    //    private static class GPAComparator implements */Comparator<Student>() {
    //
    //        @Override
    //        public int compare(Student o1, Student o2) {
    //            return new Float(o1.gpa).compareTo(o2.gpa);
    //        }
    //
    //    };
    //    
    //    private static Comparator<Student> gpaComparator = new GPAComparator();
    //    
    //    private static class GPAComparator implements Comparator<Student> {
    //
    //        @Override
    //        public int compare(Student o1, Student o2) {
    //            return new Float(o1.gpa).compareTo(o2.gpa);
    //        }
    //
    //    }
    public static Comparator<Student> getGPAComparator() {
        return gpaComparator;
    }
    private static Comparator<Student> gpaComparator = 
        (o1, o2) -> new Float(o1.gpa).compareTo(o2.gpa);

//    private static Comparator<Student> gpaComparator = (Student o1, Student o2)
//        -> /*{*/ /* return */ new Float(o1.gpa).compareTo(o2.gpa)/*;*/ /*}*/;

//    private static Comparator<Student> gpaComparator = /* new Comparator<Student>() { */
//
//        /*@Override
//        public int compare*/(Student o1, Student o2) -> {
////            System.out.println("in lambda...");
//            return new Float(o1.gpa).compareTo(o2.gpa);
//        }
//
//    /*}*/;
    public static Predicate<Student> getSmartnessPredicate(final float threshold) {
//        int s; // Must not have variables in scope here that are used for lambda method args
//        threshold += 0.1F; // NO NO NO Must be final!
        return theStudent -> theStudent.getGpa() > threshold;
        
    }
}
