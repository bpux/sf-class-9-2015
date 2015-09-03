package reductions;

import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Reductions {

    public static void main(String[] args) {
        System.out.println(IntStream.iterate(0, v->v+1)
            .limit(20)
//            .reduce((t,u)->t+u));
            .reduce(new IntBinaryOperator() {
                @Override
                public int applyAsInt(int t, int u) {
                    return t+u;
                }
            }));
            
            
        System.out.println(">" 
            + Stream.of("Fred", "Jim", "Sheila")
                .reduce("", (t,u)->t+u));
        
        
        StringBuilder res = Stream.of("Fred", "Jim", "Sheila")
            .collect(StringBuilder::new, (sb, s)-> sb.append(s), 
                (sb1,sb2)->sb1.append(sb2));
        System.out.println("res: " + res);
    }
    
}
