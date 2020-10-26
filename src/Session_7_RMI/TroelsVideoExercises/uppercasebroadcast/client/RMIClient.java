package Session_7_RMI.TroelsVideoExercises.uppercasebroadcast.client;

import Session_7_RMI.TroelsVideoExercises.uppercasebroadcast.shared.UppercaseClient;
import Session_7_RMI.TroelsVideoExercises.uppercasebroadcast.shared.UppercaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient implements UppercaseClient
{
  private UppercaseServer server;

  public RMIClient() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  public void startClient() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    server = (UppercaseServer)registry.lookup("Server");
    server.registerClient(this);
  }

  public String toUppercase(String string)
  {
    try
    {
      String result = server.toUppercase(string, this);
      return result;
    }
    catch (RemoteException e)
    {
      //e.printStackTrace();
      throw new RuntimeException("Could not contact server");
    }
  }

  @Override public void update(String result)
  {
    //fire an event here ig
    System.out.println("\nBroadcasted> " + result);
  }
}
