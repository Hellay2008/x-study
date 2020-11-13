package test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        f();
    }

    private static void f(){
        List<String> list = new ArrayList<>(1000000);
        Random random = new Random();
        String x = null;
        for(int i=0; i<1000000; i++){
            int ys = random.nextInt()%2;
            x = "/data/server/dji/uluka/syncthing-files-dir/SPAB-BPFlog/201022-09/09/QBA/"+(ys==1?"req":"res")+"/3000057888910_154803101.req";
            list.add(x);
        }
        long start = System.currentTimeMillis();
        list.sort(String::compareTo);
        System.out.println(System.currentTimeMillis() - start);

    }
}
