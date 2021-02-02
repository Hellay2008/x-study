

public class TargetClass implements TargetInterface, TargetInterface1{
    private String name;
    public TargetClass(String name){
        this.name = name;
    }
    @Override
    public String method1() {
        return "method1 " + name;
    }

    @Override
    public String method2() {
        return "method2 " + name;
    }

    @Override
    public String method3() {
        return "method3 " + name;
    }

}
