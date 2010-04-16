package com.zjy.jmx;

import java.io.IOException;
import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.MBeanServerConnection;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXConnectorServer;
import javax.management.remote.JMXConnectorServerFactory;
import javax.management.remote.JMXServiceURL;

public class AccessJMX {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
			
//			System.setProperty("sun.net.client.defaultConnectTimeout", String   
//                    .valueOf(10000));
//            System.setProperty("sun.net.client.defaultReadTimeout", String   
//                    .valueOf(10000));
//            
//			JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://localhost:9092/jmxrmi");
//			JMXConnector jmxc = JMXConnectorFactory.connect(url, null);
//			MBeanServerConnection mbsc = jmxc.getMBeanServerConnection();
//			System.out.println("MBean count = " + mbsc.getMBeanCount());
			
			
			//ObjectName mBeanName = new ObjectName("HelloAgent:name=helloWorld1");
			MBeanServer _mBeanServer = ManagementFactory.getPlatformMBeanServer();
			String[] doms = _mBeanServer.getDomains();
			for(int i = 0; i < doms.length; i++) {
				System.out.println(doms[i]);
			}
			System.out.println("_mBeanServer is ::"+_mBeanServer);
			
			System.out.println(_mBeanServer.getMBeanCount().intValue());
			//String services = (String)_mBeanServer.getAttribute(mBeanName, "Greeting"); 
			//System.out.println(services);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
