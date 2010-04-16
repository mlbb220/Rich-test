package com.zjy.jmx;

import java.lang.management.ManagementFactory;

import javax.management.MBeanServer;
import javax.management.ObjectName;

public class ClientProcess implements Runnable {
	
	public void run() {
		System.out.println(Thread.currentThread().getName() + " in run");
		
		ObjectName mBeanName;
		String services;
		MBeanServer ms = ManagementFactory.getPlatformMBeanServer();
		
		try {
			mBeanName = new ObjectName("HelloAgent:name=jmxComponent");
			while(true) {
				
				System.out.println("ms @ClientProcess is ::"+ms);
				
				String[] doms = ms.getDomains();
				for(int i = 0; i < doms.length; i++) {
					System.out.println(doms[i]);
				}
				
				
				System.out.println(Thread.currentThread().getName() + " in sleep");
				Thread.sleep(15000);
				System.out.println(Thread.currentThread().getName() + " call jmx");
				services = (String)ms.getAttribute(mBeanName, "Greeting");
				System.out.println("print value " + services);
				System.out.println(Thread.currentThread().getName() + " call jmx end");
				

			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
