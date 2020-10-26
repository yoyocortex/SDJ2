package Session_7_RMI.TroelsVideoExercises.uppercasebroadcast.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UppercaseServer extends Remote
{
  String toUppercase(String str, UppercaseClient client) throws RemoteException;
  void registerClient(UppercaseClient clientToRegister) throws  RemoteException;
}
