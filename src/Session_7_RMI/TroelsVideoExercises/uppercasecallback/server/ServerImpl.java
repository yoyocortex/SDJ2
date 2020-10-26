package Session_7_RMI.TroelsVideoExercises.uppercasecallback.server;

import Session_7_RMI.TroelsVideoExercises.uppercasecallback.shared.UppercaseClient;
import Session_7_RMI.TroelsVideoExercises.uppercasecallback.shared.UppercaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements UppercaseServer
{
  public ServerImpl() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public void toUppercase(String str, UppercaseClient client)
  {
    String result = str.toUpperCase();
    //heavy calculation

    try
    {
      client.uppercaseResult(result);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }

    System.out.println("Server result> " + result);
  }
}
