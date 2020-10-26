package Session_7_RMI.TroelsVideoExercises.uppercasecallback.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UppercaseServer extends Remote
{
  void toUppercase(String str, UppercaseClient client) throws RemoteException;
}
