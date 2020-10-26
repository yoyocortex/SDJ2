package Session_7_RMI.TroelsVideoExercises.upperandlower.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LowercaseServer extends Remote
{
  String toLowercase(String arg) throws RemoteException;
}
