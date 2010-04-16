package rich.net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.UnknownHostException;

import junit.framework.TestCase;

public class TestClient extends TestCase {

	public void testConnectServer() {
		Socket s = null;
		try {
			s = new Socket("127.0.0.1", 6018);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					System.in));
			String input = "";
			while (!(input = br.readLine()).equals("quit")) {
				System.out.println("please input:...");
				s.getOutputStream().write(input.getBytes());
				s.getOutputStream().flush();
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				s.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
