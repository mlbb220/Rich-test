package rich.jmx;

import java.lang.management.ManagementFactory;
import java.rmi.registry.LocateRegistry;

import javax.management.MBeanServer;
import javax.management.ObjectName;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;


/**
 * must start rmiregistry
 * 			---start rmiregistry 57460
 *   OR
 *   		LocateRegistry.createRegistry(57460);
 * 
 * @author 30063513
 *
 */
public class HelloAgentDefault {
	private MBeanServer mbs = null;
	public static String DOMAIN = "HelloAgent";
	public static int PORT = 57460;

	public HelloAgentDefault() {
		// create a MBeanServer
//		mbs = MBeanServerFactory.createMBeanServer("HelloAgent");
		 mbs = ManagementFactory.getPlatformMBeanServer();

		ObjectName helloWorldName = null;

		try {

			HelloWorld hw = new HelloWorld("hello boys!");
			helloWorldName = new ObjectName("HelloAgent:name=helloWorld1");
			mbs.registerMBean(hw, helloWorldName);

			JMXServiceURL serviceURL = new JMXServiceURL(
					"service:jmx:rmi:///jndi/rmi://localhost:" + PORT
							+ "/" + DOMAIN);
			JMXConnectorServer connectorServer = JMXConnectorServerFactory
					.newJMXConnectorServer(serviceURL, null, mbs);
			mbs.registerMBean(connectorServer, new ObjectName("connector:name=rmi"));
			LocateRegistry.createRegistry(PORT);
			connectorServer.start();
			System.out.print("startup....");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		// declare the agent and start the adapter
		HelloAgentDefault agent = new HelloAgentDefault();

	}

}
