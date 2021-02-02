import lombok.SneakyThrows;

public class Test {

    public static void main(String[] args) {
        test();
    }

    @SneakyThrows
    public static void test() {
        System.out.println("-------------");
        Generic<String, String> gs = new Generic<>("hello");
        Generic<Integer, String> gi = new Generic<>(100);
        showValue(gs);
        showValue(gi);

    }

    public static void showValue(Generic<?, ?> g){
        System.out.println(g.getObject());
    }

}


