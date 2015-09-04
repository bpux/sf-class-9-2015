package annotation;

public class RunStuffInThis {
    
    @RunMe
    public void doStuff() {
        System.out.println("in doStuff");
    }
    
    @RunMe
    private void doMoreStuff() {
        System.out.println("in doMoreStuff");
    }
    
    public void dontDoStuff() {
        System.out.println("in dontDoStuff");
    }
}
