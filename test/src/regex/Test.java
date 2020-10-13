package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {




        String regEx = "count(\\d+)(df)";
        String s = "count000dfdfsdffaaaa1";
        Pattern pat = Pattern.compile(regEx);
        Matcher mat = pat.matcher(s);
        if(mat.find()){
            System.out.println(mat.group());
            System.out.println(mat.group(1));
            System.out.println(mat.group(2));
        }
        String regEx1 = "PacketId=(\\d+)";
        String xx = "-1:开始构建报文[PacketId=3000044120758]\",\"2020-04-28T17:39:08,111[ INFO][BPT.KXTX-2 ]-97@OutBoundProcessor[PacketId=3000044120758]";

        Pattern pat1 = Pattern.compile(regEx1);
        Matcher mat1 = pat1.matcher(xx);

        if(mat1.find()){
            System.out.println(mat1.group());
            System.out.println(mat1.group(1));
        }
    }
}
