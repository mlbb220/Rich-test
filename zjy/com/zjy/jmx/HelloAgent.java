package com.zjy.jmx;

import java.lang.management.ManagementFactory;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServer;
import javax.management.MBeanServerFactory;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;

//import com.sun.jdmk.comm.HtmlAdaptorServer;

public class HelloAgent {
	
	private MBeanServer mbs = null;
	private HelloWorld jmxComponent = null;
	private ClientProcess client = null;
	
	public HelloAgent(String value) {
		jmxComponent = new HelloWorld(value);
		mbs = ManagementFactory.getPlatformMBeanServer();
	}
	
	public void registerComponent() {
//        HtmlAdaptorServer adapter = new HtmlAdaptorServer();
		
		ObjectName adapterName = null;
		ObjectName helloWorldName = null;
		
		try {
		    helloWorldName = new ObjectName("HelloAgent:name=jmxComponent");
		    mbs.registerMBean(jmxComponent, helloWorldName );
		    adapterName = new ObjectName("HelloAgent:name=htmladapter,port=9092" );
//		    adapter.setPort(9092);
//		    mbs.registerMBean(adapter, adapterName);
//		    adapter.start();
		    
			System.out.println("ms @HelloAgent is ::"+mbs);
			
			String[] doms = mbs.getDomains();
			for(int i = 0; i < doms.length; i++) {
				System.out.println(doms[i]);
			}
			
			
			
		  }
		  catch( Exception e ) {
		    e.printStackTrace();
		  }
	}
	
	public void startFunc() {
		registerComponent();
		startClient();
	}
	
	public void startClient() {
		client = new ClientProcess();
		Thread threadC = new Thread(client, "clientprocess");
		threadC.start();
	}
	
	public MBeanServer getMbs() {
		return mbs;
	}
	
	public void setMbs(MBeanServer mbs) {
		this.mbs = mbs;
	}

	public static void main( String args[] ) {
		
	  System.out.println( "HelloAgent is running" );
	  HelloAgent agent = new HelloAgent("my jmx component!");
	  agent.startFunc();
	  
	}
}
