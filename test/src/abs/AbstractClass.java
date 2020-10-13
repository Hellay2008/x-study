package abs;

import service.Handler;
import service.TestService;

public abstract class AbstractClass implements TestService, Handler {
    public void process(){
        System.out.println("AbstractClass.process()");
        commonMethod1();
        test();
        commonMethod2();
    }

    public void commonMethod1(){
        System.out.println("AbstractClass.commonMethod1");
    }

    public void commonMethod2(){
        System.out.println("AbstractClass.commonMethod1");
    }
}
