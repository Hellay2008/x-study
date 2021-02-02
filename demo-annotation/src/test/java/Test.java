import com.anno.API;
import com.anno.APIS;
import com.bean.Person;
import org.springframework.util.StringUtils;

public class Test {
    public static void main(String[] args) {

        String x = "/CMB-BPFlog/D-opt-bp3-data-bpflog-bank-CMB2-201223-07/07/SDQ/res/";
        System.out.println(x.indexOf("SDQ"));

        Person p = new Person();
        API[] annos = Person.class.getAnnotationsByType(API.class);
        for(API anno : annos){
            System.out.println(anno.value());
        }

        APIS apis = Person.class.getAnnotation(APIS.class);
        System.out.println(apis.value().length);
        for(API api : apis.value()){
            System.out.println(api.value());
        }
    }


}
