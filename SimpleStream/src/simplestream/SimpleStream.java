package simplestream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Stream;
import students.Student;

public class SimpleStream {

    public static void main(String[] args) {
        boolean allLong = Stream.of("Fred", "Jim", "", "Sheila")
            .peek(s->System.out.println(">" + s))
            .allMatch(s->s.length()>0);
        System.out.println("All long is " + allLong);
        
        IntSummaryStatistics ss = Stream.of("Fred", "Jim", "", "Sheila")
//            .limit(2)
//            .map(s->"Mx. " + s)
//            .map(s->s.length())
//            .forEach(s->System.out.println(">>" + s + " stream type is "
//               + s.getClass().getName()));
            .mapToInt(s->s.length())
            .summaryStatistics();
//            .forEach(s->System.out.println(">>" + s));
        System.out.println("ss = " + ss);
        
        Stream.of("Fred Jones", "Jim Jones", "Albert", "Sheila")
            .flatMap(s->Arrays.stream(s.split("\\W")))
            .forEach(s->System.out.println(">>>" + s));

        Stream.of("Fred", "Jim", "Albert", "Sheila")
            .flatMap(s->{
                char [] ca = s.toCharArray();
                String[] sa = new String[ca.length];
                for (int i = 0; i < ca.length; i++) {
                    sa[i] = "" + ca[i];
                }
                return Stream.of(sa);
            })
            .forEach(s->System.out.println(">>>" + s));
        
        List<Student> students = Arrays.asList(
            new Student("Fred", 2.8F, "Math", "Physics", "Chemistry"),
            new Student("Jim", 3.8F, "Physics", "Fine Art"),
            new Student("Sheila", 3.9F, "Urban Studies", "Journalism"),
            new Student("Bill", 2.9F, "Geography", "Politics"));
        students.stream()
            .map(s->s.getName())
            .forEach(s->System.out.println(s));
        students.stream()
            .filter(s->s.getGpa() > 3.0F)
            .forEach(s->System.out.println(s));
        System.out.println("Average: " 
            + students.stream()
            .mapToDouble(Student::getGpa)
            .average());
        students.stream()
            .flatMap(s->Stream.of(s.getCourses()))
            .distinct()
            .forEach(System.out::println);
    }
    
}
