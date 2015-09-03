package students;



import java.util.Comparator;
import java.util.function.Predicate;

public class Student implements Comparable<Student> {

    private String name;
    private float gpa;
    private String[] courses;

    public Student(String name, float gpa, String ... courses) {
        this.name = name;
        this.gpa = gpa;
        this.courses = courses;
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

    public String[] getCourses() {
        return courses;
    }

    public void setCourseName(String[] courses) {
        this.courses = courses;
    }

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", gpa=" + gpa + ", courses=" + courses + '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);

    }

    public static Comparator<Student> getGPAComparator() {
        return gpaComparator;
    }
    private static Comparator<Student> gpaComparator = 
        (o1, o2) -> new Float(o1.gpa).compareTo(o2.gpa);

    public static Predicate<Student> getSmartnessPredicate(final float threshold) {
        return theStudent -> theStudent.getGpa() > threshold;
    }
}
