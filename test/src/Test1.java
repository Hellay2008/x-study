public class Test1 {



    public static void main(String[] args) {
        //getReqFilePath("/CMB-BPFlog/200918/200918/09/QBA/res/", "3000049918036_res_src_002123101.res");
        System.out.println(getInnerErrorMsg("<ERRMSG>", "</ERRMSG>", "   <ERRMSG>NCB6143: -资源未登记，企业银行:P0040443类型:CUS,要素值:595919028967</ERRMSG>  "));
        System.out.println(getInnerErrorMsg("<ERRMSG>", "</ERRMSG>", "<ERRMSG>NCB6143: -资源未登记，企业银行:P0040443类型:CUS,要素值:595919028967</ERRMSG>  "));
        System.out.println(getInnerErrorMsg("<ERRMSG>", "</ERRMSG>", "  <ERRMSG>NCB6143: -资源未登记，企业银行:P0040443类型:CUS,要素值:595919028967</ERRMSG>"));
        System.out.println(getInnerErrorMsg("<ERRMSG>", "</ERRMSG>", "<ERRMSG>NCB6143: -资源未登记，企业银行:P0040443类型:CUS,要素值:595919028967</ERRMSG>"));
    }

    public static void getReqFilePath(String resPath, String resFileName) {
        int resDirIndex = resPath.indexOf("/res/");
        String resFilePrefix = resFileName.split("_")[0];
        String reqFilePrefix = resPath.substring(0, resDirIndex) + "/req/" + resFilePrefix;
        System.out.println(reqFilePrefix);
    }

    public static String getInnerErrorMsg(String prefix, String suffix, String line){
        try {
            int startIndex = line.indexOf(prefix);
            int endIndex = line.indexOf(suffix);
            line = line.substring(startIndex+prefix.length(), endIndex);
        }catch (Exception e){
            e.printStackTrace();
        }
        return line;
    }
}
