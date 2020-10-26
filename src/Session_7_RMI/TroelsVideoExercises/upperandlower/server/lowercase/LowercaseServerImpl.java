package Session_7_RMI.TroelsVideoExercises.upperandlower.server.lowercase;

import Session_7_RMI.TroelsVideoExercises.upperandlower.shared.LowercaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LowercaseServerImpl implements LowercaseServer
{

  public LowercaseServerImpl() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public String toLowercase(String arg) throws RemoteException
  {
    return arg.toLowerCase();
  }
}
