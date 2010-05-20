package rich.net.nio;

import java.io.IOException;
import java.nio.channels.SelectionKey;

/**
 * Created by IntelliJ IDEA.
 * User: hongruixing
 * Date: 2008-3-31
 * Time: 14:49:31
 * To change this template use File | Settings | File Templates.
 */
public interface Reactor {
    /**
     * React to an NIO event.
     *
     * @param key SelectionKey which has a ready operation.
     */
    void react(SelectionKey key) throws IOException;
}
