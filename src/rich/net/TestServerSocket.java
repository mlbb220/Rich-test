package rich.net;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import junit.framework.TestCase;

public class TestServerSocket extends TestCase {

	ServerSocket ss;

	public void setUp() {

	}

	public void testReceiveMessage() {
		Socket socket;
		try {
			ss = new ServerSocket(5678);
			System.out.println("receiving.....");
			socket = ss.accept();
			System.out.println("received.....");
			BufferedInputStream bis = new BufferedInputStream(socket
					.getInputStream());
			BufferedReader br = new BufferedReader(new InputStreamReader(bis));
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				ss.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
