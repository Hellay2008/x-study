import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        TargetClass target = new TargetClass("gongye");
        TargetInterface targetInterface = (TargetInterface)Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object obj = method.invoke(target, args);
                return obj;
            }
        });
        System.out.println(targetInterface.method1());
        System.out.println(targetInterface.method2());
    }
}
