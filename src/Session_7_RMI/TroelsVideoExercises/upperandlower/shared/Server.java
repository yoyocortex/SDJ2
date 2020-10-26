package Session_7_RMI.TroelsVideoExercises.upperandlower.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote
{
  UppercaseServer getUppercaseServer() throws RemoteException;
  LowercaseServer getLowercaseServer() throws RemoteException;
}
