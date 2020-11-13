public class Test1 {
    public static void main(String[] args) {
        String filed61 = "";
        String filed86 = "";
        String result = "";
//        String filed86 = "ACH CONCENTRATION CREDIT CASH CONCENTRATION BEST BUY-PAYMENT";
//        print("------f2------");
//        String result = f2(filed61, filed86);
//        print(result);
//        filed86 = "ACH CONCENTRATION CREDIT CASH CONCENTRATION BEST BUY,PAYMENT";
//        result = f2(filed61, filed86);
//        print(result);
//        filed86 = "ACH CONCENTRATION CREDIT CASH CONCENTRATION BEST BUY:PAYMENT";
//        result = f2(filed61, filed86);
//        print(result);
//
//        print("------f3------");
//        filed86 = "ACH CONCENTRATION CREDIT CASH CONCENTRATION BRAINTREE-FUNDING";
//        result = f3(filed61, filed86);
//        print(result);
//        filed86 = "ACH CONCENTRATION CREDIT CASH CONCENTRATION BRAINTREE,FUNDING";
//        result = f3(filed61, filed86);
//        print(result);
//        filed86 = "ACH CONCENTRATION CREDIT CASH CONCENTRATION BRAINTREE:FUNDING";
//        result = f3(filed61, filed86);
//        print(result);
//
//        filed86 = "FOREIGN REMITTANCE CREDIT 33RECD CHIP WELLS FARGO BANK, SAN FRANCISCO, CA ORG AMAZON.COM SERVICES LLC, XXX,XX";
//        result = f4(filed61, filed86);
//
//        filed86 = "FOREIGN REMITTANCE CREDIT 33RECD CHIP WELLS FARGORG BANK, SAN FRANCISCO, CA ORG AMAZON.COM SERVICES LLC, XXX,XX";
//        result = f4(filed61, filed86);
//        print(result);

//        filed86 = "FOREIGN REMITTANCE CREDIT 33RECD CHIP WELLS FARGORG BANK, SAN FRANCISCO, CA ORG:AMAZON.COM SERVICES LLC, XXX,XX";
//        result = f4_6(filed61, filed86);
//        print(result);

//        filed86 = "ACH CONCENTRATION CREDIT CASH CONCENTRATION MAVERICK DRONE-ACH Maverick ach DJI";
//        result = f2(filed61, filed86);
//        print(result);

//        filed86 = "INCOMING MONEY TRANSFER 53RECD FED JPMORGAN CHASE BANK, N.A. ORG:ZVENTURES-INC. DBA CARR OTINK.COM &,CHATSWORTH CA 91311- BNF:DJI INDUSTRIAL INC,-2349 US OBI:50 PER CENT PAYMENT FOR EC202008205543N ";
//        result = f13(filed61, filed86);
//        print(result);

//        filed86 = "/ORDP/深圳市大疆百旺有限公司\n南京分公司\n/REMI/往来款";
//        result = f14(filed61, filed86);
//        print(result);

        filed86 = "/ORDP/深圳市大疆百旺有限公司\n南京分公司\n/REMI/往来款";
        result = f15(filed61, filed86);
        print(result);
    }

    static String f15(String filed61,String filed86){

        if(filed86.contains("/ORDP/") && filed86.contains("/REMI/")){
            int start_index = filed86.indexOf("/ORDP/")+6;
            int end_index = filed86.indexOf("/", 6);
            return filed86.substring(start_index, end_index);
        }
        return null;
    }

    static String f14(String filed61,String filed86){

        if(filed86.contains("/ORDP/") && filed86.contains("/REMI/")){
            int start_index = filed86.indexOf("/ORDP/")+6;
            int end_index = filed86.indexOf("/REMI/");
            return filed86.substring(start_index, end_index);
        }
        return null;
    }

    static String f13(String filed61,String filed86){
        if(filed86.startsWith("INCOMING MONEY TRANSFER ")) {
            if(filed86.contains(" ORG ")){
                int org_index = filed86.indexOf(" ORG ");
                int comma_index = filed86.indexOf(",", org_index);
                return filed86.substring(org_index+5, comma_index);
            }
            else if(filed86.contains(" ORG:")){
                int org_index = filed86.indexOf(" ORG:");
                int comma_index = filed86.indexOf(",", org_index);
                return filed86.substring(org_index+5, comma_index);
            }
        }
        return null;
    }



    static String f7(String filed61,String filed86){
        if(filed86.startsWith("ACH CREDIT DEPOSIT FROM ")) {
           int from_index = "ACH CREDIT DEPOSIT FROM ".length();
           int paypal_index = filed86.indexOf("PAYPAL");
           return filed86.substring(from_index, paypal_index) + "PAYPAL";
        }
        return null;
    }


    static String f4_6(String filed61,String filed86){
        if(filed86.startsWith("FOREIGN REMITTANCE CREDIT ")) {
            if(filed86.contains(" ORG ")){
                int org_index = filed86.indexOf(" ORG ");
                int comma_index = filed86.indexOf(",", org_index);
                return filed86.substring(org_index+5, comma_index);
            }
            else if(filed86.contains(" ORG:")){
                int org_index = filed86.indexOf(" ORG:");
                int comma_index = filed86.indexOf(",", org_index);
                return filed86.substring(org_index+5, comma_index);
            }
        }
        return null;
    }



    static String f3(String filed61,String filed86){
        int prefix_length = "ACH CONCENTRATION CREDIT CASH CONCENTRATION ".length();
        if(filed86.startsWith("ACH CONCENTRATION CREDIT CASH CONCENTRATION ")) {
            if(filed86.contains("-")){
                int end = filed86.indexOf("-");
                return filed86.substring(prefix_length, end);
            }
            else if(filed86.contains(",")){
                int end = filed86.indexOf(",");
                return filed86.substring(prefix_length, end);
            }
            else if(filed86.contains(":")){
                int end = filed86.indexOf(":");
                return filed86.substring(prefix_length, end);
            }
        }
        return null;
    }


    static String f2(String filed61,String filed86){
        int prefix_length = "ACH CONCENTRATION CREDIT CASH CONCENTRATION ".length();
        if(filed86.startsWith("ACH CONCENTRATION CREDIT CASH CONCENTRATION ")) {
            if(filed86.contains("-")){
                int end = filed86.indexOf("-");
                return filed86.substring(prefix_length, end);
            }
            else if(filed86.contains(",")){
                int end = filed86.indexOf(",");
                return filed86.substring(prefix_length, end);
            }
            else if(filed86.contains(":")){
                int end = filed86.indexOf(":");
                return filed86.substring(prefix_length, end);
            }
        }
        return null;
    }

    static void print(String x){
        System.out.println(x);
    }
}
