package optional;

import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        String x = null;
        System.out.println(Optional.ofNullable(x).orElse("s"));
    }
}
