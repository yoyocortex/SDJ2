package Session_7_RMI.TroelsVideoExercises.uppercasereturn.client;

import Session_7_RMI.TroelsVideoExercises.uppercasereturn.shared.UppercaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient
{
  private UppercaseServer server;

  public RMIClient()
  {

  }

  public void startClient() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    server = (UppercaseServer)registry.lookup("Server");
  }

  public String toUppercase(String string)
  {
    String result = null;
    try
    {
      result = server.toUppercase(string);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Could not contact server");
    }
    return result;
  }
}
