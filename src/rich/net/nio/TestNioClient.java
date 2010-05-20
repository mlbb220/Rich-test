package rich.net.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;

import rich.util.TestUtil;
import sun.net.InetAddressCachePolicy;

public class TestNioClient {

	SocketChannel socketChannel;
	int serverPort = 9876;
	Selector selector;
	ByteBuffer buffer;
	int capacity = 100;

	public TestNioClient(String name) {
		try {
			selector = Selector.open();
			socketChannel = SocketChannel.open();
			socketChannel.connect(new InetSocketAddress(serverPort));
			socketChannel.configureBlocking(false);

			buffer = ByteBuffer.allocate(capacity);
			socketChannel.write(buffer.put(("name:" + name).getBytes()));

			receiveMessage();
			sendMessage();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	private void sendMessage() throws IOException {
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		String msg;
		while (!(msg = bReader.readLine()).equals("quit")) {
			TestUtil.printLog("Will send message :" + msg);
			socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
		}
		socketChannel.close();

	}

	private void receiveMessage() throws IOException {
		new Thread(new ReceieveMessageThread(), "ReceieveMessageThread").start();

	}

	public class ReceieveMessageThread implements Runnable {

		@Override
		public void run() {
			try {
				TestUtil.printLog("start to read message...");
				int result;
				while (true) {
					while ((result = socketChannel.read(buffer)) > 0 && buffer.position() > 0) {
						buffer.flip();
						CharBuffer ch = Charset.forName("utf-8").newDecoder().decode(buffer);
						String readFrom = ch.toString();

						TestUtil.printLog("Read data from socket is :" + readFrom);

						buffer.compact();
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

		}

	}

	public static void main(String[] args) {

		new TestNioClient("Rich");
	}
}
