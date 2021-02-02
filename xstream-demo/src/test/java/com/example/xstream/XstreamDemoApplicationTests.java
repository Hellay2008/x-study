package com.example.xstream;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;

@SpringBootTest
class XstreamDemoApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    public void test(){
        try {
            File file = new File("d:/temp/yue-fail.res");
            XStream xStream = new XStream(new Xpp3Driver());
            xStream.alias("CMBSDKPGK", CMBSDKPGK.class);
            xStream.alias("INFO", CMBSDKPGK.INFO.class);
            XStream.setupDefaultSecurity(xStream);
            xStream.allowTypes(new Class[]{CMBSDKPGK.class, CMBSDKPGK.INFO.class});
            CMBSDKPGK msg = (CMBSDKPGK) xStream.fromXML(file);
            System.out.println(msg.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
