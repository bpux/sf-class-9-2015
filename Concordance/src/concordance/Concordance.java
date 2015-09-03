package concordance;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Concordance {

    public static void main(String[] args) throws Throwable {
        Set<String> common = new HashSet<>();
        common.addAll(Arrays.asList("", "the", "a", "to", "of", "and"
        , "her", "I", "in", "was", "that", "not", "she", "it", "be"));
        
        Files
            .lines(Paths.get("prideandprejudice.txt"))
            .flatMap(s->Stream.of(s.split("\\W+")))
            .filter(s->!(common.contains(s)))
            .collect(Collectors.groupingBy(s->s, Collectors.counting()))
            .entrySet()
            .stream()
            .sorted((e1,e2)-> e2.getValue().compareTo(e1.getValue()))
            .limit(200)
            .forEach(e->System.out.printf("%14s : %5d\n", e.getKey(), e.getValue()));
            
    }
    
}
