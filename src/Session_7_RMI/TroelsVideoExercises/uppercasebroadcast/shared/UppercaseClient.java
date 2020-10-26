package Session_7_RMI.TroelsVideoExercises.uppercasebroadcast.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UppercaseClient extends Remote
{
  void update(String result) throws RemoteException;
}
