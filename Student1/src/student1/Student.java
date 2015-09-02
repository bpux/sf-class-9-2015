package student1;

import java.util.Comparator;

public class Student implements Comparable<Student> {

    private String name;
    private float gpa;

    public Student(String name, float gpa) {
        this.name = name;
        this.gpa = gpa;
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

    @Override
    public String toString() {
        return "Student{" + "name=" + name + ", gpa=" + gpa + '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.name.compareTo(o.name);

    }

    public static Comparator<Student> getGPAComparator() {
        return gpaComparator;
    }
    
    private static Comparator<Student> gpaComparator = new GPAComparator();
    
    private static class GPAComparator implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            return new Float(o1.gpa).compareTo(o2.gpa);
        }

    }
}
