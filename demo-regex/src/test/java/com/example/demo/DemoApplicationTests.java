package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Pattern;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void test(){
        String content = "I am noob " +
                "from runoob.com.";

        String pattern = ".*runoob.*";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println("字符串中是否包含了 'runoob' 子字符串? " + isMatch);
    }

    @Test
    public void test1(){
        String content = "<ERRMSG>NCB6143: -资源未登记，企业银行:P0040443类型:CUS,要素值:595919028967</ERRMSG>\\n";

        String pattern = ".*<ERRMSG>.*</ERRMSG>.*";

        boolean isMatch = Pattern.matches(pattern, content);
        System.out.println(content + "match regex " + pattern + " ? " + isMatch);
    }


}
