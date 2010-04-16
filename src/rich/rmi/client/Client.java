package rich.rmi.client;

import java.rmi.Naming;

import rich.rmi.TestInterfactRemote;

public class Client
{
  public static void main(String args[])
  {
    try
    {
      TestInterfactRemote testInterfactRemote = (TestInterfactRemote) Naming
          .lookup("rmi://127.0.0.1/server");
      System.out.println(testInterfactRemote.add("rmi a ", "rmib"));
    } catch (Exception e)
    {
      e.printStackTrace();
    }
  }
}
