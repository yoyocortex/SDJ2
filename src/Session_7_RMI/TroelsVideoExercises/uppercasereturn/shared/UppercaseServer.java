package Session_7_RMI.TroelsVideoExercises.uppercasereturn.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UppercaseServer extends Remote
{
  String toUppercase(String str) throws RemoteException;
}
