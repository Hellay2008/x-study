package replace;

public class Test {
    public static void main(String[] args) {
        String string = "原始报文信息=[\"2020-04-28T17:39:08,095[ INFO][BPT.KXTX-2 ]- 97@OutBoundProcessor -1:开始构建报文[PacketId=3000044120758]\",\"2020-04-28T17:39:08,111[ INFO][BPT.KXTX-2 ]- 97@OutBoundProcessor -2:开始发送报文[PacketId=3000044120758]\",\"2020-04-28T17:39:19,065[ INFO][BPT.KXTX-2 ]- 97@HSBCPacketSender -原始报文：D:\\\\BP3\\\\data\\\\bpt\\\\log\\\\hsbc\\\\out\\\\3000044120758.txt\",\"2020-04-28T17:39:19,065[ INFO][BPT.KXTX-2 ]- 97@PGP -Begin EncryptAndSign.....\",\"2020-04-28T17:39:19,378[ INFO][BPT.KXTX-2 ]- 97@PGP -EncryptAndSign success.\",\"2020-04-28T17:39:19,378[ INFO][BPT.KXTX-2 ]- 97@HSBCPacketSender -已对请求报文进行加密\",\"2020-04-28T17:39:19,378[ INFO][BPT.KXTX-2 ]- 97@HSBCPacketSender -开始连接远程ftp，ecom-sftp.fguk.hsbc.com10022\",\"2020-04-28T17:39:19,378[ INFO][BPT.KXTX-2 ]- 174@NstcSftpClient -设置客户端类型clientType=sshtools\",\"2020-04-28T17:39:19,378[ INFO][BPT.KXTX-2 ]- 97@HSBCPacketSender -连接成功\",\"2020-04-28T17:39:19,378[ INFO][BPT.KXTX-2 ]- 97@HSBCPacketSender -开始上传文件\",\"2020-04-28T17:39:19,378[ INFO][BPT.KXTX-2 ]- 715@NstcSftpClient -NstcSftpClient客户端信息:\",\"2020-04-28T17:39:32,895[ERROR][BPT.KXTX-2 ]- 849@NstcSftpClient -连接并登录sftp服务时异常:Connection refused: connect\",\"2020-04-28T17:39:32,926[ERROR][BPT.KXTX-2 ]- 246@NstcSftpClient -上传sftp文件时异常:连接并登录sftp服务时异常.\",\"2020-04-28T17:39:32,942[ INFO][BPT.KXTX-2 ]- 97@HSBCPacketSender -文件上传成功\",\"2020-04-28T17:39:32,942[ INFO][BPT.KXTX-2 ]- 735@NstcSftpClient -断开与sftp服务的连接...\",\"2020-04-28T17:39:32,958[ INFO][BPT.KXTX-2 ]- 97@OutBoundProcessor -3:开始解析报文[PacketId=3000044120758]\",\"2020-04-28T17:39:32,958[ INFO][BPT.KXTX-2 ]- 97@OutBoundProcessor -4:解析报文结束[PacketId=3000044120758]\"]";
        string = string.replaceAll("@OutBoundProcessor", "@OutBoundProcessor<br>");
        string = string.replaceAll("@HSBCPacketSender", "@HSBCPacketSender<br>");
        string = string.replaceAll("@PGP", "@PGP<br>");
        string = string.replaceAll("@NstcSftpClient", "@NstcSftpClient<br>");
        System.out.println(string);
    }
}
