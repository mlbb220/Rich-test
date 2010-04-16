package rich.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TestInterfactRemote extends Remote
{

  public String add(String a, String b) throws RemoteException;

  public String add() throws RemoteException;

}
