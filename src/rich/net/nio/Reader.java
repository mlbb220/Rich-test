
package rich.net.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * Created by IntelliJ IDEA.
 * User: hongruixing
 * Date: 2008-3-31
 * Time: 14:50:39
 * To change this template use File | Settings | File Templates.
 */
public class Reader implements Reactor {
    ByteBuffer buffer;

    /**
     * Constructs a Reader.
     *
     * @param buffer ByteBuffer for I/O.
     */
    public Reader(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    public void react(SelectionKey key) throws IOException {
        SocketChannel sc = (SocketChannel) key.channel();
        int count;
        while ((count = sc.read(buffer)) > 0 || buffer.position() > 0) {

            try {
                buffer.flip();
                count = sc.write(buffer);

                System.out.println("count is :"+count);
                
                if (count == 0) {
                    // Stop reading this channel and wait for an OP_WRITE
                    sc.register(key.selector(), SelectionKey.OP_WRITE, new Writer(buffer));
                    return;
                }
            }
            finally {
                buffer.compact();
            }
        }
        if (count < 0) {

            sc.close();
        }
    }
}