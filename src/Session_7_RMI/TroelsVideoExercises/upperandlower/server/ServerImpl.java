package Session_7_RMI.TroelsVideoExercises.upperandlower.server;

import Session_7_RMI.TroelsVideoExercises.upperandlower.server.lowercase.LowercaseServerImpl;
import Session_7_RMI.TroelsVideoExercises.upperandlower.server.uppercase.UppercaseServerImpl;
import Session_7_RMI.TroelsVideoExercises.upperandlower.shared.LowercaseServer;
import Session_7_RMI.TroelsVideoExercises.upperandlower.shared.Server;
import Session_7_RMI.TroelsVideoExercises.upperandlower.shared.UppercaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements Server
{
  public ServerImpl() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public UppercaseServer getUppercaseServer() throws RemoteException
  {
    return new UppercaseServerImpl();
  }

  @Override public LowercaseServer getLowercaseServer() throws RemoteException
  {
    return new LowercaseServerImpl();
  }
}
