package Session_7_RMI.TroelsVideoExercises.uppercasebroadcast.server;

import Session_7_RMI.TroelsVideoExercises.uppercasebroadcast.shared.UppercaseClient;
import Session_7_RMI.TroelsVideoExercises.uppercasebroadcast.shared.UppercaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServerImpl implements UppercaseServer
{
  private List<UppercaseClient> clientList;

  public ServerImpl() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    clientList = new ArrayList<>();
  }

  @Override public String toUppercase(String str, UppercaseClient client)
  {
    String result = str.toUpperCase();
    //heavy calculation
    System.out.println("Server result> " + result);

    updateClients(result, client);

    return result;
  }

  private void updateClients(String result, UppercaseClient client)
  {
    for (UppercaseClient uppercaseClient : clientList)
    {
      if(uppercaseClient.equals(client)) continue;

      try
      {
        uppercaseClient.update(result);
      }
      catch (RemoteException e)
      {
        e.printStackTrace();
      }
    }
  }

  @Override public void registerClient(UppercaseClient clientToRegister)
  {
    clientList.add(clientToRegister);
  }
}
