package rich.rmi.server;

import java.rmi.Naming;

import rich.rmi.TestInterfaceRemoteImpl;
import rich.rmi.TestInterfactRemote;

public class Server
{

  public Server()
  {
    try
    {
      TestInterfactRemote testInterfactRemote = new TestInterfaceRemoteImpl();
      Naming.rebind("server", testInterfactRemote);
      System.out.println("binding successfully");
    } catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  public static void main(String args[])
  {
    new Server();
  }
}
