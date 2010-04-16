package rich.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class TestInterfaceRemoteImpl extends UnicastRemoteObject implements
    TestInterfactRemote
{
  public TestInterfaceRemoteImpl() throws RemoteException
  {
    super();
  }

  public String add(String a, String b) throws RemoteException
  {
    return a + b;
  }

  public String add() throws RemoteException
  {
    return "Hello Word";
  }

}
