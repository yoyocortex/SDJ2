package Session_7_RMI.TroelsVideoExercises.upperandlower.server.uppercase;

import Session_7_RMI.TroelsVideoExercises.upperandlower.shared.UppercaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UppercaseServerImpl implements UppercaseServer
{

  public UppercaseServerImpl() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public String toUppercase(String str)
  {
    return str.toUpperCase();
  }
}
