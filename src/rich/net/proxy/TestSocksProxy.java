/**
 * 
 */
package rich.net.proxy;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author rli
 *
 */
public class TestSocksProxy {

	/**
	 * 
	 * @param args
	 * @throws IOException
	 * 
	 * 中文版SOCK4协议地址：http://zh.wikipedia.org/wiki/SOCKS
	 * 英文版SOCK5协议地址：http://www.ietf.org/rfc/rfc1928.txt
	 * 要想穿越代理服务器，必须要与代理服务器进行TCP连接，并实现一次或者多次握手过程。
	 * 拿SOCK4协议举例（本人代理环境为SOCK4，经测试已成功穿越）。
	 * 仔细阅读SOCK4协议，客户端要想穿越SOCK4协议与外网相连，需有一次握手过程，即客户端需向代理服务器发送一个字节序列，根据协议规范，我发送的字节序列为：
	 * {0x04,0x01,0x1f,(byte)0x41,(byte)0xd3,(byte)0x8a,(byte)0xe0,0x35,0x00}
	 * 其中：
	 * 0X04：协议版本
	 * 0X01：CONNECT请求（0X02时为BIND请求）
	 * 0X1F 0X41：访问的外网端口（8001）
	 * 0XD3 0X8A 0XE0 0X35：访问的外网IP地址（211.138.224.53）
	 * 0X00：（相当于结束位的标志）
	 * 
 代理服务器而后发送回应包（以字节为单位）：
+——+——+——+——+——+——+——+——+
| VN | CD | DSTPORT |      DSTIP        |
+——+——+——+——+——+——+——+——+
   1    1      2              4
VN是回应码的版本，应该是0；
CD是代理服务器答复，有几种可能：
90，请求得到允许；
91，请求被拒绝或失败；
92，由于SOCKS服务器无法连接到客户端的identd（一个验证身份的进程），请求被拒绝；
93，由于客户端程序与identd报告的用户身份不同，连接被拒绝。
DSTPORT与DSTIP与请求包中的内容相同，但被忽略。
如果请求被拒绝，SOCKS服务器马上与客户端断开连接；如果请求被允许，代理服务器就充当客户端与目的主机之间进行双向传递，对客户端而言，就如同直接在与目的主机相连。

	 */
	public static void main(String[] args) throws IOException{
		Socket socket = new Socket("10.104.151.188",7070);//代理服务器地址和端口   
		byte[] datas = {0x04,0x01,0x1f,(byte)0x41,(byte)0xd3,(byte)0x8a,(byte)0xe0,0x35,0x00};//发送的握手字节序列   
		OutputStream os = socket.getOutputStream();   
		os.write(datas);   
		byte[] receive = new byte[8]; //服务端返回的字节   
		InputStream is = socket.getInputStream();   
		int count = 0;   
		if((count = is.read(receive)) > 0) { //一定要先读服务器返回的字节序列   
		    System.out.println("count is : "+count);   
		    for(byte b : receive) {   
		        System.out.println(Integer.toHexString((int)b));   
		    }   
		}   
		os.write("GET http://api.twitter.com/1/statuses/friends_timeline.json?include_entities=false&include_rts=true HTTP/1.1".getBytes());//按照常规方式读写数据吧   
		receive = new byte[140];   
		os.close();   
		socket.close();
	}
}
