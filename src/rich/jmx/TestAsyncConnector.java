package rich.jmx;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import junit.framework.TestCase;

public class TestAsyncConnector extends TestCase {

	protected static final String DEFAULT_JNDI_PATH = "/jmxrmi";
	protected static final String EppicPersistenceManager = "EPPIC.SMS:type=AsyncCatchupRunner,name=AsyncCatchupRunner";
	protected static final String PrimaryDBSet = "data";

	JMXConnector connector;
	MBeanServerConnection serverConnection;

	public void testConnectAsync() {
		int port = 63970;
		String host = "10.237.81.214";
		JMXServiceURL address;
		String x;
		try {
			address = new JMXServiceURL("service:jmx:rmi://" //+ host
					+ "/jndi/rmi://" + host + ":" + port + DEFAULT_JNDI_PATH);
			connector = JMXConnectorFactory.connect(address);
			serverConnection = connector.getMBeanServerConnection();
			x = (String) serverConnection.getAttribute(new ObjectName(
					(String) EppicPersistenceManager), PrimaryDBSet);
			System.out.println("Connected to EPPIC on host server " + host);
			System.out.println("Live Database Server is " + x);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			assertNull(e);
		}

	}

	
	public void disconnect() throws Exception {
		if (connector != null) {
			connector.close();
			connector = null;
		}
		serverConnection = null;
	}
}
