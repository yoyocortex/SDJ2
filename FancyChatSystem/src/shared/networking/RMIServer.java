package shared.networking;

import shared.util.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote
{
  void loginRequest(String username, String password, ClientCallBack rmiClient) throws RemoteException;
  void registerRequest(String username, String password, String repeatPassword, ClientCallBack rmiClient) throws RemoteException;
  void onlineUsersRequest() throws RemoteException;
  void sendMessage(Message message) throws RemoteException;
}
