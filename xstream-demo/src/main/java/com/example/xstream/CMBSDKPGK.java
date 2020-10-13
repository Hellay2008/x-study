package com.example.xstream;

import java.util.List;

public class CMBSDKPGK {

    private CMBSDKPGK.INFO INFO;
    private CMBSDKPGK.NTQACINFZ NTQACINFZ;

    public CMBSDKPGK.NTQACINFZ getNTQACINFZ() {
        return NTQACINFZ;
    }

    public void setNTQACINFZ(CMBSDKPGK.NTQACINFZ NTQACINFZ) {
        this.NTQACINFZ = NTQACINFZ;
    }

    public CMBSDKPGK.INFO getINFO() {
        return INFO;
    }

    public void setINFO(CMBSDKPGK.INFO INFO) {
        this.INFO = INFO;
    }

    @Override
    public String toString() {
        return "CMBSDKPGK{" +
                "INFO=" + INFO +
                '}';
    }

    class INFO{
        private String DATTYP;
        private String ERRMSG;
        private String FUNNAM;
        private String LGNNAM;
        private Integer RETCOD;

        public String getDATTYP() {
            return DATTYP;
        }

        public void setDATTYP(String DATTYP) {
            this.DATTYP = DATTYP;
        }

        public String getERRMSG() {
            return ERRMSG;
        }

        public void setERRMSG(String ERRMSG) {
            this.ERRMSG = ERRMSG;
        }

        public String getFUNNAM() {
            return FUNNAM;
        }

        public void setFUNNAM(String FUNNAM) {
            this.FUNNAM = FUNNAM;
        }

        public String getLGNNAM() {
            return LGNNAM;
        }

        public void setLGNNAM(String LGNNAM) {
            this.LGNNAM = LGNNAM;
        }

        public Integer getRETCOD() {
            return RETCOD;
        }

        @Override
        public String toString() {
            return "INFO{" +
                    "DATTYP='" + DATTYP + '\'' +
                    ", ERRMSG='" + ERRMSG + '\'' +
                    ", FUNNAM='" + FUNNAM + '\'' +
                    ", LGNNAM='" + LGNNAM + '\'' +
                    ", RETCOD=" + RETCOD +
                    '}';
        }

        public void setRETCOD(Integer RETCOD) {
            this.RETCOD = RETCOD;
        }
    }

    class NTQACINFZ {
        /**
         * <ACCBLV>99109.39</ACCBLV>
         *         <ACCITM>20122</ACCITM>
         *         <ACCNAM>世纪天骄集团</ACCNAM>
         *         <ACCNBR>769900003510901</ACCNBR>
         *         <AVLBLV>9995964542.25</AVLBLV>
         *         <BBKNBR>69</BBKNBR>
         *         <CCYNBR>10</CCYNBR>
         *         <C_CCYNBR>人民币</C_CCYNBR>
         *         <C_INTRAT>1.0100000%</C_INTRAT>
         *         <DPSTXT>在岸挂牌对</DPSTXT>
         *         <HLDBLV>0.00</HLDBLV>
         *         <INTCOD>S</INTCOD>
         *         <LMTOVR>0.00</LMTOVR>
         *         <ONLBLV>9996017036.45</ONLBLV>
         *         <OPNDAT>20010101</OPNDAT>
         *         <STSCOD>A</STSCOD>
         */

        private String ACCBLV;
        private String ACCITM;
        private String ACCNAM;
        private String ACCNBR;
        private String AVLBLV;
        private String BBKNBR;
        private String CCYNBR;
        private String C_CCYNBR;
        private String C_INTRAT;
        private String DPSTXT;
        private String HLDBLV;
        private String INTCOD;
        private String LMTOVR;
        private String ONLBLV;
        private String OPNDAT;
        private String STSCOD;

        public String getACCBLV() {
            return ACCBLV;
        }

        public void setACCBLV(String ACCBLV) {
            this.ACCBLV = ACCBLV;
        }

        public String getACCITM() {
            return ACCITM;
        }

        public void setACCITM(String ACCITM) {
            this.ACCITM = ACCITM;
        }

        public String getACCNAM() {
            return ACCNAM;
        }

        public void setACCNAM(String ACCNAM) {
            this.ACCNAM = ACCNAM;
        }

        public String getACCNBR() {
            return ACCNBR;
        }

        public void setACCNBR(String ACCNBR) {
            this.ACCNBR = ACCNBR;
        }

        public String getAVLBLV() {
            return AVLBLV;
        }

        public void setAVLBLV(String AVLBLV) {
            this.AVLBLV = AVLBLV;
        }

        public String getBBKNBR() {
            return BBKNBR;
        }

        public void setBBKNBR(String BBKNBR) {
            this.BBKNBR = BBKNBR;
        }

        public String getCCYNBR() {
            return CCYNBR;
        }

        public void setCCYNBR(String CCYNBR) {
            this.CCYNBR = CCYNBR;
        }

        public String getC_CCYNBR() {
            return C_CCYNBR;
        }

        public void setC_CCYNBR(String c_CCYNBR) {
            C_CCYNBR = c_CCYNBR;
        }

        public String getC_INTRAT() {
            return C_INTRAT;
        }

        public void setC_INTRAT(String c_INTRAT) {
            C_INTRAT = c_INTRAT;
        }

        public String getDPSTXT() {
            return DPSTXT;
        }

        public void setDPSTXT(String DPSTXT) {
            this.DPSTXT = DPSTXT;
        }

        public String getHLDBLV() {
            return HLDBLV;
        }

        public void setHLDBLV(String HLDBLV) {
            this.HLDBLV = HLDBLV;
        }

        public String getINTCOD() {
            return INTCOD;
        }

        public void setINTCOD(String INTCOD) {
            this.INTCOD = INTCOD;
        }

        public String getLMTOVR() {
            return LMTOVR;
        }

        public void setLMTOVR(String LMTOVR) {
            this.LMTOVR = LMTOVR;
        }

        public String getONLBLV() {
            return ONLBLV;
        }

        public void setONLBLV(String ONLBLV) {
            this.ONLBLV = ONLBLV;
        }

        public String getOPNDAT() {
            return OPNDAT;
        }

        public void setOPNDAT(String OPNDAT) {
            this.OPNDAT = OPNDAT;
        }

        public String getSTSCOD() {
            return STSCOD;
        }

        public void setSTSCOD(String STSCOD) {
            this.STSCOD = STSCOD;
        }

        @Override
        public String toString() {
            return "NTQACINFZ{" +
                    "ACCBLV='" + ACCBLV + '\'' +
                    ", ACCITM='" + ACCITM + '\'' +
                    ", ACCNAM='" + ACCNAM + '\'' +
                    ", ACCNBR='" + ACCNBR + '\'' +
                    ", AVLBLV='" + AVLBLV + '\'' +
                    ", BBKNBR='" + BBKNBR + '\'' +
                    ", CCYNBR='" + CCYNBR + '\'' +
                    ", C_CCYNBR='" + C_CCYNBR + '\'' +
                    ", C_INTRAT='" + C_INTRAT + '\'' +
                    ", DPSTXT='" + DPSTXT + '\'' +
                    ", HLDBLV='" + HLDBLV + '\'' +
                    ", INTCOD='" + INTCOD + '\'' +
                    ", LMTOVR='" + LMTOVR + '\'' +
                    ", ONLBLV='" + ONLBLV + '\'' +
                    ", OPNDAT='" + OPNDAT + '\'' +
                    ", STSCOD='" + STSCOD + '\'' +
                    '}';
        }
    }
}