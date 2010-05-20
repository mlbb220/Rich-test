
package rich.net.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * Created by IntelliJ IDEA.
 * User: hongruixing
 * Date: 2008-3-31
 * Time: 14:51:18
 * To change this template use File | Settings | File Templates.
 */
public class Writer implements Reactor {
    ByteBuffer buffer;

    /**
     * Constructs a Writer.
     *
     * @param buffer ByteBuffer for I/O.
     */
    public Writer(ByteBuffer buffer) {
        this.buffer = buffer;
    }

    public void react(SelectionKey key) throws IOException {
        try {
            SocketChannel sc = (SocketChannel) key.channel();
            buffer.flip();
            int count = sc.write(buffer);

            if (!buffer.hasRemaining())
                // Nothing left to write: OK to start reading again
                sc.register(key.selector(), SelectionKey.OP_READ, new Reader(buffer));
        }
        finally {
            buffer.compact();
        }
    }
}