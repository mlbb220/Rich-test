package rich.net;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class SelectorServer {
	private static int DEFAULT_SERVERPORT = 6018;// 默认端口
	private static int DEFAULT_BUFFERSIZE = 1024;// 默认缓冲区大小为1024字节
	private ServerSocketChannel channel;
	private LinkedList<SocketChannel> clients;
	private Selector readSelector;
	private ByteBuffer buffer;// 字节缓冲区
	private int port;

	public SelectorServer(int port) throws IOException {
		this.port = port;
		this.clients = new LinkedList<SocketChannel>();
		this.channel = null;
		this.readSelector = Selector.open();// 打开选择器
		this.buffer = ByteBuffer.allocate(DEFAULT_BUFFERSIZE);
	}

	// 服务器程序在服务循环中调用sericeClients()方法为已接受的客户服务
	public void serviceClients() throws IOException {
		Set keys;
		Iterator it;
		SelectionKey key;
		SocketChannel client;
		// 在readSelector上调用select()方法，参数1代表如果调用select的时候 那么阻塞最多1秒钟等待可用的客户端连接
		if (readSelector.select(1) > 0) {
			keys = readSelector.selectedKeys(); // 取得代表端通道的键集合
			it = keys.iterator();
			// 遍历，为每一个客户服务
			while (it.hasNext()) {
				key = (SelectionKey) it.next();
				if (key.isReadable()) { // 如果通道可读，那么读此通道到buffer中
					int bytes;
					client = (SocketChannel) key.channel();// 取得键对应的通道
					buffer.clear(); // 清空缓冲区中的内容，设置好position,limit，准备接受数据
					bytes = client.read(buffer); // 从通道中读数据到缓冲中，返回读取得字节数
					if (bytes >= 0) {
						buffer.flip(); // 准备将缓冲中的数据写回到通道中
						client.write(buffer); // 数据写回到通道中
					} else if (bytes < 0) { // 如果返回小于零的值代表读到了流的末尾
						clients.remove(client);
						// 通道关闭时，选择键也被取消
						client.close();
					}
				}
			}
		}
	}

	public void registerClient(SocketChannel client) throws IOException {// 配置和注册代表客户连接的通道对象
		client.configureBlocking(false); // 设置此通道使用非阻塞模式
		client.register(readSelector, SelectionKey.OP_READ); // 将这个通道注册到选择器上
		clients.add(client); // 保存这个通道对象
	}

	public void listen() throws IOException { // 服务器开始监听端口，提供服务
		ServerSocket socket;
		SocketChannel client;
		channel = ServerSocketChannel.open(); // 打开通道
		socket = channel.socket(); // 得到与通到相关的socket对象
		socket.bind(new InetSocketAddress(port), 10); // 将scoket榜定在制定的端口上
		// 配置通到使用非阻塞模式，在非阻塞模式下，可以编写多道程序同时避免使用复杂的多线程
		channel.configureBlocking(false);
		try {
			while (true) {// 与通常的程序不同，这里使用channel.accpet()接受客户端连接请求，而不是在socket对象上调用accept(),这里在调用accept()方法时如果通道配置为非阻塞模式,那么accept()方法立即返回null，并不阻塞
				client = channel.accept();
				if (client != null) {
					registerClient(client); // 注册客户信息
				}
				serviceClients(); // 为以连接的客户服务
			}
		} finally {
			socket.close(); // 关闭socket，关闭socket会同时关闭与此socket关联的通道
		}
	}

	public static void main(String[] args) throws IOException {
		System.out.println("服务器启动");
		SelectorServer server = new SelectorServer(
				SelectorServer.DEFAULT_SERVERPORT);
		server.listen(); // 服务器开始监听端口，提供服务

	}

}
