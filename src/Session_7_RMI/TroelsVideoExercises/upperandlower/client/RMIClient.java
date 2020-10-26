package Session_7_RMI.TroelsVideoExercises.upperandlower.client;

import Session_7_RMI.TroelsVideoExercises.upperandlower.shared.LowercaseServer;
import Session_7_RMI.TroelsVideoExercises.upperandlower.shared.Server;
import Session_7_RMI.TroelsVideoExercises.upperandlower.shared.UppercaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient
{
  private Server server;
  private UppercaseServer uppercaseServer;
  private LowercaseServer lowercaseServer;

  public RMIClient()
  {
  }

  public void startClient() throws RemoteException, NotBoundException
  {
    Registry registry = LocateRegistry.getRegistry("localhost", 1099);
    server = (Server) registry.lookup("Server");
    uppercaseServer = server.getUppercaseServer();
    lowercaseServer = server.getLowercaseServer();
  }

  public String toUppercase(String string)
  {
    try
    {
      return uppercaseServer.toUppercase(string);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Could not contact server");
    }
  }

  public String toLowercase(String string)
  {
    try
    {
      return lowercaseServer.toLowercase(string);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
      throw new RuntimeException("Could not contact server");
    }
  }
}
