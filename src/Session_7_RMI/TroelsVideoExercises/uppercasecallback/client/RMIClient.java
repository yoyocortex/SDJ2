package Session_7_RMI.TroelsVideoExercises.uppercasecallback.client;

import Session_7_RMI.TroelsVideoExercises.uppercasecallback.shared.UppercaseClient;
import Session_7_RMI.TroelsVideoExercises.uppercasecallback.shared.UppercaseServer;

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
  }

  public void toUppercase(String string)
  {
    try
    {
      server.toUppercase(string, this);
    }
    catch (RemoteException e)
    {
      //e.printStackTrace();
      throw new RuntimeException("Could not contact server");
    }
  }

  @Override public void uppercaseResult(String result)
  {
    //fire an event here ig
    System.out.println("Result> " + result);
  }
}
