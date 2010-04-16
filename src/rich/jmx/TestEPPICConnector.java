package rich.jmx;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import junit.framework.TestCase;

public class TestEPPICConnector extends TestCase {

	protected static final String DEFAULT_JNDI_PATH = "/jmxrmi";
	protected static final String EppicPersistenceManager = "sms:name=test";
	protected static final String PrimaryDBSet = "00PrimaryDBSet";

	JMXConnector connector;
	MBeanServerConnection serverConnection;

	public void testConnect() {
		int port = 64460;
		String host = "127.0.0.1";
		JMXServiceURL address;
		String x;
		try {
			address = new JMXServiceURL("service:jmx:rmi://" //+ host
					+ "/jndi/rmi://" + host + ":" + port + DEFAULT_JNDI_PATH);
			connector = JMXConnectorFactory.connect(address);
			serverConnection = connector.getMBeanServerConnection();
			x = (String) serverConnection.getAttribute(new ObjectName(
					(String) EppicPersistenceManager), PrimaryDBSet);
			System.out.println("Connected on host server " + host);
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
