package client.networking;

import shared.networking.ClientCallBack;
import shared.networking.RMIServer;
import shared.util.Message;
import shared.util.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIClient implements ClientCallBack, Client
{
  private PropertyChangeSupport support;
  private RMIServer RMIServer;
  private User thisUser;

  public RMIClient()
  {
    support = new PropertyChangeSupport(this);
    try
    {
      UnicastRemoteObject.exportObject(this, 0);
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      RMIServer = (RMIServer) registry.lookup("Server");
    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void loginRequest(String username, String password)
  {
    thisUser = new User(username, password);
    try
    {
      RMIServer.loginRequest(username, password, this);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void registerRequest(String username, String password, String repeatPassword)
  {
    try
    {
      RMIServer.registerRequest(username, password, repeatPassword, this);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void onlineUsersRequest()
  {
    try
    {
      RMIServer.onlineUsersRequest();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void sendMessage(Message message)
  {
    try
    {
      RMIServer.sendMessage(message);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void loginResultServer(String loginResult)
  {
    if(!"OK".equals(loginResult)) thisUser = new User("", "");
    support.firePropertyChange("LoginResult", null, loginResult);
  }

  @Override public void registerResultServer(String registerResult)
  {
    support.firePropertyChange("RegisterResult", null, registerResult);
  }

  @Override public void pingClient()
  {
    //System.out.println("Ping has arrived!");
  }

  @Override public void sendUpdatedOnlineUserList(List<User> onlineUsers)
  {
    support.firePropertyChange("OnlineUsers", null, onlineUsers);
    support.firePropertyChange("LoggedInAs", null, thisUser);
  }

  @Override public void messageBack(Message message)
  {
    support.firePropertyChange("MessageBack", null, message);
  }

  @Override public void addListener(String name, PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void removeListener(String name, PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }
}
