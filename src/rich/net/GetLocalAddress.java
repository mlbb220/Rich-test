package rich.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.util.Enumeration;

public class GetLocalAddress {

	public static void main(String[] args) {
        InetAddress i;
        String host = "www.sina.com.cn";
		try {
			i = Inet4Address.getByName(host);
			System.out.println(i.getHostName());
	        host = i.getHostAddress();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			host = "unknow";
		}
		System.out.println("host is :" + host);

		System.out.println();
		getAllHostAddresses();
		
		getStreamViaProxy();

	}
	
	
	/*
	 * Get All the local ip addresses 
	 */
	private static void getAllHostAddresses(){
		Enumeration<NetworkInterface> netInterfaces = null;  
		try {  
		    netInterfaces = NetworkInterface.getNetworkInterfaces();  
		    while (netInterfaces.hasMoreElements()) {  
		        NetworkInterface ni = netInterfaces.nextElement();  
		        System.out.println("DisplayName:" + ni.getDisplayName());  
		        System.out.println("Name:" + ni.getName());  
		        Enumeration<InetAddress> ips = ni.getInetAddresses();  
		        while (ips.hasMoreElements()) {  
		            System.out.println("IP:"  
		            + ips.nextElement().getHostAddress());  
		        }  
		    }  
		} catch (Exception e) {  
		    e.printStackTrace();  
		} 
	}
	
	/*
	 * Get the URL stream via some HTTP proxy server
	 */
	private static void getStreamViaProxy(){
		String proxyServer = "";
		int proxyPort = 80;
		try {
			Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyServer, proxyPort));
			URLConnection con = new URL("http://www.sina.com.cn").openConnection(proxy);
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line = reader.readLine();
			while(line != null){
				System.out.println(line);
				line = reader.readLine();
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
