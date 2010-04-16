package rich.jmx;

import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.ObjectName;

import mx4j.tools.adaptor.http.HttpAdaptor;

public class HelloAgentHtml {
	private MBeanServer mbs = null;
	public static String DOMAIN = "HelloAgent";
	public static int PORT = 57460;

	public HelloAgentHtml() {
		// create a MBeanServer
		mbs = MBeanServerFactory.createMBeanServer("HelloAgent");
//		 mbs = ManagementFactory.getPlatformMBeanServer();

		ObjectName adapterName = null;
		ObjectName helloWorldName = null;

		try {
			HttpAdaptor adapter = new HttpAdaptor();
			ObjectName xslBeanName = new ObjectName("EPPIC:name=XSLTProcessor");
			mx4j.tools.adaptor.http.XSLTProcessor xsltAdaptor = new mx4j.tools.adaptor.http.XSLTProcessor();
			// String beanClassName = "mx4j.tools.adaptor.http.XSLTProcessor";
			// AttributeList attrs = new AttributeList();
			// attrs.add(new Attribute("UseCache", new Boolean(false)));
			// makeMBean(xslBeanName, beanClassName, attrs);
			mbs.registerMBean(xsltAdaptor, xslBeanName);

			adapterName = new ObjectName("EPPIC:name=HttpAdaptor");

			// regisetr the adapter to the MBeanServer
			mbs.registerMBean(adapter, adapterName);
			// declare the port which the adapter user
			adapter.setPort(9092);
			// according to docs, this will open http adaptor to all interfaces
			adapter.setHost("0.0.0.0");
			adapter.setProcessorName(xslBeanName);

			adapter.start();

			HelloWorld hw = new HelloWorld("hello boys!");
			helloWorldName = new ObjectName("HelloAgent:name=helloWorld1");
			mbs.registerMBean(hw, helloWorldName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String args[]) {
		// declare the agent and start the adapter
		HelloAgentHtml agent = new HelloAgentHtml();

	}

}
