package com.example.demo;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import javax.xml.xpath.XPathConstants;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class HutoolDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void getPath(){
        String frontPath = "D:\\QRH_Files\\20201009\\300000785035646\\20201009142632_300000785035646_4.qrh";
        String path = getFilePath(frontPath);
        System.out.println(path);
    }

    private String syncThingPath="/data/opt/syncThing/";
    private String getFilePath(String frontPath){
        frontPath = frontPath.replaceAll(":", "");
        String[] dirs = frontPath.split("\\\\");
        StringBuilder pathBuilder = new StringBuilder(syncThingPath);
        pathBuilder.append("Wechat-data").append(File.separator);
        pathBuilder.append(dirs[0]).append("-").append(dirs[1]).append("-").append(dirs[2]);
        String x = dirs[0]+"-"+dirs[1]+"-"+dirs[2];
        for(int i=3; i<dirs.length; i++){
            pathBuilder.append(File.separator).append(dirs[i]);
        }
        return pathBuilder.toString();
    }

    @Test
    public void test(){
        String content = "<?xml  version=\"1.0\" encoding = \"GBK\"?><CMBSDKPGK><INFO><FUNNAM>GetAccInfo</FUNNAM><DATTYP>2</DATTYP><LGNNAM>NN-1</LGNNAM></INFO><SDKACINFX><BBKNBR>69</BBKNBR><ACCNBR>769900003510702</ACCNBR></SDKACINFX><SDKACINFX><BBKNBR>69</BBKNBR><ACCNBR>769900003510901</ACCNBR></SDKACINFX></CMBSDKPGK>";
        Document document = XmlUtil.parseXml(content);
        String RETURN_CODE_PATH = "//CMBSDKPGK/SDKACINFX/ACCNBR";
        Object obj = XmlUtil.getByXPath(RETURN_CODE_PATH, document, XPathConstants.STRING);
        System.out.println(obj);
        System.out.println("------------");

        Map<String, Object> map = XmlUtil.xmlToMap(content);
        System.out.println(map.toString());

    }



}
