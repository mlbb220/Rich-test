package rich.jmx;

import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import junit.framework.TestCase;

public class TestHelloConnector extends TestCase {

	protected static final String DEFAULT_JNDI_PATH = "/jmxrmi";
	protected static final String OBJECT_NAME = "HelloAgent:name=helloWorld1";
	protected static final String OBJECT_FIELD = "Hello";

	JMXConnector connector;
	MBeanServerConnection serverConnection;

	public void testConnect() {
		String host = "127.0.0.1";
		JMXServiceURL address;
		String x;
		try {
			address = new JMXServiceURL("service:jmx:rmi://" //+ host
					+ "/jndi/rmi://" + host + ":" + HelloAgentDefault.PORT + "/"+HelloAgentDefault.DOMAIN);
			connector = JMXConnectorFactory.connect(address);
			serverConnection = connector.getMBeanServerConnection();
			String[] domains = serverConnection.getDomains();
			for (int i = 0; i < domains.length; i++) {
				System.out.println(domains[i]);
			}
			
			ObjectName name = new ObjectName(OBJECT_NAME);
			x = (String) serverConnection.getAttribute(name, OBJECT_FIELD);
			System.out.println("Connected to EPPIC on host server " + host);
			System.out.println("Live Database Server is " + x);
		} catch (Exception e) {
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
