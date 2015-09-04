package annotation;

public class RunStuffInThis {
    @SetMe("Freddy waz here!")
    private String name;
    private String address;
    
    @RunMe
    public void doStuff() {
        System.out.println("in doStuff" + this);
    }
    
    @RunMe
    private void doMoreStuff() {
        System.out.println("in doMoreStuff" + this);
    }
    
    public void dontDoStuff() {
        System.out.println("in dontDoStuff" + this);
    }

    @Override
    public String toString() {
        return "RunStuffInThis{" + "name=" + name + ", address=" + address + '}';
    }
}
