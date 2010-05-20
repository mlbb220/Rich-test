
package rich.net.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * Created by IntelliJ IDEA.
 * User: hongruixing
 * Date: 2008-3-31
 * Time: 14:49:59
 * To change this template use File | Settings | File Templates.
 */
public class Acceptor implements Reactor {
    public void react(SelectionKey key) throws IOException {
        ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
        SocketChannel sc = ssc.accept();
        if (sc != null) {

            sc.configureBlocking(false);
            sc.register(key.selector(), SelectionKey.OP_READ, new Reader(ByteBuffer.allocate(1024)));
        }
    }
}
