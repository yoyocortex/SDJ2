package server.networking;

import server.servermodel.login_register.Login_Register;
import server.servermodel.login_register.Login_RegisterManager;
import shared.networking.ClientCallBack;
import shared.networking.RMIServer;
import shared.util.Message;
import shared.util.User;

import java.rmi.ConnectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIRMIServer implements RMIServer
{
  private Login_Register loginRegister;

  public RMIRMIServer()
  {
    loginRegister = new Login_RegisterManager(this);

    try
    {
      UnicastRemoteObject.exportObject(this, 0);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void loginRequest(String username, String password, ClientCallBack rmiClient)
  {
    loginRegister.loginRequest(username, password, rmiClient);
  }

  @Override public void registerRequest(String username, String password, String repeatPassword, ClientCallBack rmiClient)
  {
    loginRegister.registerRequest(username, password, repeatPassword, rmiClient);
  }

  @Override public void onlineUsersRequest()
  {
    loginRegister.onlineUsersRequest();
  }

  @Override public void sendMessage(Message message)
  {
    loginRegister.sendMessage(message);
  }

  public void loginResult(String loginResult, ClientCallBack rmiClient)
  {
    try
    {
      rmiClient.loginResultServer(loginResult);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  public void registerResult(String result, ClientCallBack rmiClient)
  {
    try
    {
      rmiClient.registerResultServer(result);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  public void pingClient(ClientCallBack client)
  {
    try
    {
      client.pingClient();
    }
    catch (ConnectException e)
    {
      loginRegister.removeClient(client);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  public void sendUpdatedOnlineUserList(List<User> onlineUsers, List<ClientCallBack> clients)
  {
    for (ClientCallBack client : clients)
    {
      try
      {
        client.sendUpdatedOnlineUserList(onlineUsers);
      }
      catch (RemoteException e)
      {
        System.out.println("Disconnect this client!");
        loginRegister.removeClient(client);
        //e.printStackTrace();
      }
    }
  }

  public void messageBack(ClientCallBack fromClient, ClientCallBack toClient, Message message)
  {
    try
    {
      fromClient.messageBack(message);
      toClient.messageBack(message);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }
}
