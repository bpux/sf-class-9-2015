package simplestream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {
    public static void main(String[] args) {
        List<String> text = Arrays.asList(
            "It", "was", "a", "dark", "and", "stormy", "night",
            "It", "dark", "Snoopy", "It", "dark"
            );
        Map<String, Long> output = text.stream()
            .collect(Collectors.groupingBy(s->s, Collectors.counting()));
        output.entrySet()
            .forEach(e->System.out.println(e.getKey() + ": " + e.getValue()));
    }
}
