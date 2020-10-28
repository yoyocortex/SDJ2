package server.networking;

import client.networking.RMIClient;
import server.servermodel.login_register.Login_Register;
import server.servermodel.login_register.Login_RegisterManager;
import shared.networking.ClientCallBack;
import shared.networking.RMIServer;

import java.rmi.ConnectException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
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
      //e.printStackTrace();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }
}
