package reductions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import students.Student;

public class StudentAggregator {

    public static void main(String[] args) {
        HashMap<String, List<String>> results
            = Stream.of(
                new Student("Fred", 2.8F, "Math", "Physics", "Chemistry"),
                new Student("Jim", 3.8F, "Physics", "Fine Art", "Journalism"),
                new Student("Sheila", 3.9F, "Urban Studies", "Journalism"),
                new Student("Bill", 2.9F, "Geography", "Politics")
            )
            .parallel()
            .collect(HashMap::new,
                (m, s) -> {
                    String[] courses = s.getCourses();
                    String studentName = s.getName();
                    for (String course : courses) {
                        List<String> current = m.get(course);
                        if (current == null) {
                            current = new ArrayList<String>();
                            m.put(course, current);
                        }
                        current.add(studentName);
                    }
                },
                (m, m1) -> {
                    for (String course : m1.keySet()) {
                        List<String> current = m.get(course);
                        if (current == null) {
                            m.put((String)course, m1.get(course));
                        } else {
                            current.addAll(m1.get(course));
                        }
                    }
                }
            );
        results.entrySet().stream()
            .forEach(e -> System.out.println("Course " + e.getKey()
                    + " has students "
                    + e.getValue()
                ));
        
    }
}
