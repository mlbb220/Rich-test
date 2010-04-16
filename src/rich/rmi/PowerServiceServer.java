package rich.rmi;

import java.io.IOException;
import java.math.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;
import java.util.StringTokenizer;

//
// PowerServiceServer
//
// Server for a RMI service that calculates powers
//
public class PowerServiceServer extends UnicastRemoteObject implements
		PowerService, Runnable {
	public PowerServiceServer() throws RemoteException {
		super();
	}

	// Calculate the square of a number
	public BigInteger square(int number) throws RemoteException {
		String numrep = String.valueOf(number);
		BigInteger bi = new BigInteger(numrep);

		// Square the number
		bi.multiply(bi);

		return (bi);
	}

	// Calculate the power of a number
	public BigInteger power(int num1, int num2) throws RemoteException {
		String numrep = String.valueOf(num1);
		BigInteger bi = new BigInteger(numrep);

		bi = bi.pow(num2);

		return bi;
	}

	public static void main(String args[]) throws Exception {
		// Assign a security manager, in the event that dynamic
		// classes are loaded
		// if (System.getSecurityManager() == null)
		// System.setSecurityManager(new RMISecurityManager());

		// Create an instance of our power service server ...
		PowerServiceServer svr = new PowerServiceServer();
//		Thread t = new Thread(svr, "PowerService");
//		t.start();


		LocateRegistry.createRegistry(1099);

		String rmiUrl = "rmi://" + "localhost" + ":" + "1099" + "/"
				+ "PowerService";
		// ... and bind it with the RMI Registry
		Naming.rebind(rmiUrl, svr);

		System.out.println("Service bound....");
	}

	/**
	 * Generates the stubs necessary so that the passed in class can be started
	 * as RMI server
	 * 
	 * @throws IOException
	 */
	private static void generateStubs(Class rmiServer, String classpath,
			String pathSeparator) throws IOException {
		String dir = getClassesDir(classpath, pathSeparator);
		Runtime.getRuntime().exec(
				"rmic " + rmiServer.getName() + "  -classpath " + classpath
						+ " -d " + dir);
	}

	/**
	 * gets the first directory (non jar file) from the classpath
	 * 
	 * @param classpath
	 * @return
	 */
	private static String getClassesDir(String classpath, String pathSeparator) {
		StringTokenizer st = new StringTokenizer(classpath, pathSeparator);
		while (st.hasMoreTokens()) {
			String token = st.nextToken();
			if (token.indexOf(".jar") < 0) {
				return token;
			}
		}
		return null;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {

			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}