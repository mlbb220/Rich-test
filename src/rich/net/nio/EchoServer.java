
package rich.net.nio;

import java.beans.PropertyChangeSupport;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;

import java.nio.channels.ClosedSelectorException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EchoServer implements Closeable, Runnable {
    private static final Map<Integer, String> operations = new HashMap<Integer, String>();
    private Logger logger = Logger.getLogger(this.getClass().getName());
    private ServerSocketChannel ssc;
    private Selector selector;

    /**
     * Creates a new instance of EchoServer.
     *
     * @param port Port number to listen at.
     */
    public EchoServer(int port) throws IOException {
        this.ssc = ServerSocketChannel.open();
        this.selector = Selector.open();
        ssc.socket().bind(new InetSocketAddress(port));
        ssc.configureBlocking(false);
        ssc.register(selector, SelectionKey.OP_ACCEPT, new Acceptor());
    }

    static {
        operations.put(SelectionKey.OP_ACCEPT, "OP_ACCEPT");
        operations.put(SelectionKey.OP_CONNECT, "OP_CONNECT");
        operations.put(SelectionKey.OP_READ, "OP_READ");
        operations.put(SelectionKey.OP_WRITE, "OP_WRITE");
    }

    static String getOperations(int ops) {
        String result = "";
        for (int i = 1; i < 32; i <<= 1) {
            if ((ops & i) == 0)
                continue;
            if (result.length() > 0)
                result += ",";
            result += operations.get(i);
        }
        return result;
    }

    public void close() throws IOException {
        ssc.close();
        selector.close();
    }

    public void run() {
        while (selector.isOpen()) {
            try {
                int nsel = selector.select(timeout);
                if (nsel == 0) {
                    // TODO: timeout
                    for (SelectionKey key : selector.keys()) {
                        logger.log(Level.INFO, "channel " + key.channel() + " waiting for " + getOperations(key.interestOps()));
                    }
                    continue;
                }
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while (it.hasNext()) {
                    SelectionKey key = it.next();
                    it.remove();
                    if (!key.isValid() || !key.channel().isOpen())
                        // e.g.OP_ACCEPT is triggered once when the channel is closed.
                        continue;
                    Reactor reactor = (Reactor) key.attachment();
                    try {
                        reactor.react(key);
                    }
                    catch (IOException exc) {
                        logger.log(Level.SEVERE, "calling Reactor.react()", exc);
                    }
                }
            }
            catch (ClosedSelectorException exc) {
                logger.log(Level.FINE, "select loop", exc);
            }
            catch (IOException exc) {
                logger.log(Level.SEVERE, "select loop", exc);
            }
        }
    }

    /**
     * Utility field used by bound properties.
     */
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);


    /**
     * Adds a PropertyChangeListener to the listener list.
     *
     * @param l The listener to add.
     */
    public void addPropertyChangeListener(java.beans.PropertyChangeListener l) {

        propertyChangeSupport.addPropertyChangeListener(l);
    }

    /**
     * Removes a PropertyChangeListener from the listener list.
     *
     * @param l The listener to remove.
     */
    public void removePropertyChangeListener(java.beans.PropertyChangeListener l) {

        propertyChangeSupport.removePropertyChangeListener(l);
    }

    /**
     * Holds value of property timeout.
     */
    private int timeout;

    /**
     * Getter for property timeout.
     *
     * @return Value of property timeout.
     */
    public int getTimeout() {
        return this.timeout;
    }

    /**
     * Setter for property timeout.
     *
     * @param timeout New value of property timeout.
     */
    public void setTimeout(int timeout) {
        int oldTimeout = this.timeout;
        this.timeout = timeout;
        propertyChangeSupport.firePropertyChange("timeout", new Integer(oldTimeout), new Integer(timeout));
    }

    /**
     * Main method, for testing.
     *
     * @param args Command line arguments.
     */
    public static void main(String[] args) throws IOException {
        int port =  8082;
        EchoServer server = new EchoServer(port);
        server.setTimeout(10 * 1000);
        new Thread(server).start();
        while (true) {
           
        }
    }
}