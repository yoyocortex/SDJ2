package shared.networking;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallBack extends Remote
{
  void loginResultServer(String loginResult) throws RemoteException;
  void registerResultServer(String registerResult) throws RemoteException;
  void pingClient() throws RemoteException;
}
