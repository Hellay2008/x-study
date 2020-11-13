
import java.io.File;
import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 *
 * @author shutu008
 *selectSingleNode的使用
 */
public class Test{
    public static void main(String[] args) throws Exception{
        //读取XML文件，获得document对象
        SAXReader saxReader = new SAXReader();
        Document doc = saxReader.read(new File("./src/contact.xml"));

        //使用xpath获取某个节点
        String xpath = "";

        //对contact元素 id="001"的节点，操作
        xpath = "//contact[@id = '001']";
        Element contactElem =    (Element)doc.selectSingleNode(xpath);

        //设置这个节点的属性值
        contactElem.addAttribute("name", "001");

        //输出这个节点的所有属性值
        for(Iterator it = contactElem.attributeIterator();it.hasNext();){
            Attribute conAttr = (Attribute)it.next();
            String conTxt = conAttr.getValue();
            String conAttrName = conAttr.getName();
            System.out.println(conAttrName+" = "+conTxt);
        }

    }
}