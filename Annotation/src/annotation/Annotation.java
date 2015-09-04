package annotation;

import java.io.BufferedReader;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Annotation {

    public static void main(String[] args) throws Throwable {
        BufferedReader br
            = Files.newBufferedReader(Paths.get("TestItems.txt"));

        String classname = null;
        while ((classname = br.readLine()) != null) {
            Class cl = Class.forName(classname);
            Object o = cl.newInstance();

            System.out.println("object is " + o.getClass().getName());

            Method[] methods = cl.getDeclaredMethods();
            for (Method m : methods) {
                System.out.println("Method: " + m);
                RunMe rm = m.getAnnotation(RunMe.class);
                if (rm != null) {
                    System.out.println("   annotated!");
                    m.setAccessible(true);
                    m.invoke(o);
                }
            }
        }
    }

}
