package Session_7_RMI.TroelsVideoExercises.uppercasecallback.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UppercaseClient extends Remote
{
  void uppercaseResult(String result) throws RemoteException;
}
