package Session_7_RMI.TroelsVideoExercises.uppercasereturn.server;

import Session_7_RMI.TroelsVideoExercises.uppercasereturn.shared.UppercaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements UppercaseServer
{
  public ServerImpl() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public String toUppercase(String str)
  {
    return str.toUpperCase();
  }
}
