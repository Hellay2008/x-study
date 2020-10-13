import service.Handler;
import service.TestService;
import service.impl.TestService001Impl;
import service.impl.TestServiceImpl;

public class Client {
    public static void main(String[] args) {
        Handler handler = new TestService001Impl();
        TestServiceImpl testService = (TestServiceImpl)handler;
        testService.process();
    }
}
