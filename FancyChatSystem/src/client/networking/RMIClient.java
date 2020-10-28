package client.networking;

import shared.networking.ClientCallBack;
import shared.networking.RMIServer;
import shared.util.Subject;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIClient implements ClientCallBack, Client
{
  private PropertyChangeSupport support;
  private RMIServer RMIServer;

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
    //System.out.println("Client before server > " + username + " " + password);

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

  @Override public void loginResultServer(String loginResult)
  {
    System.out.println("Login result in client after server > " + loginResult);
    support.firePropertyChange("LoginResult", null, loginResult);
  }

  @Override public void registerResultServer(String registerResult)
  {
    System.out.println("Register result in client after server > " + registerResult);
    support.firePropertyChange("RegisterResult", null, registerResult);
  }

  @Override public void pingClient()
  {
    System.out.println("Ping has arrived!");
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
