package shared.networking;

import client.networking.RMIClient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote
{
  void loginRequest(String username, String password, ClientCallBack rmiClient) throws RemoteException;
  void registerRequest(String username, String password, String repeatPassword, ClientCallBack rmiClient) throws RemoteException;
}
