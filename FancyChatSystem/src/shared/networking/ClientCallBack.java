package shared.networking;

import shared.util.Message;
import shared.util.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ClientCallBack extends Remote
{
  void loginResultServer(String loginResult) throws RemoteException;
  void registerResultServer(String registerResult) throws RemoteException;
  void pingClient() throws RemoteException;
  void sendUpdatedOnlineUserList(List<User> onlineUsers) throws RemoteException;
  void messageBack(Message message) throws RemoteException;
}
