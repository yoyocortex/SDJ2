package server.servermodel.login_register;

import client.networking.RMIClient;
import server.networking.RMIRMIServer;
import shared.networking.ClientCallBack;
import shared.util.User;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Login_RegisterManager implements Login_Register
{
  private List<User> registerdUsers;
  private List<User> onlineUsers;
  private List<ClientCallBack> clients;

  private RMIRMIServer server;

  public Login_RegisterManager(RMIRMIServer rmirmiServer)
  {
    server = rmirmiServer;

    clients = new ArrayList<>();

    registerdUsers = new ArrayList<>();
    registerdUsers.add(new User("Karlo", "Karlo123"));
    registerdUsers.add(new User("Gosia", "Gosia123"));

    onlineUsers = new ArrayList<>();

    Runnable runnable = () -> {
      while (true)
      {
        if (!clients.isEmpty())
        {
          try
          {
            for (ClientCallBack client : clients)
            {
              server.pingClient(client);
            }
          }
          catch (ConcurrentModificationException e)
          {
            break;
            //e.printStackTrace();
          }
        }
        try
        {
          Thread.sleep(1000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    };
    Thread thread = new Thread(runnable);
    thread.setDaemon(true);
    thread.start();
  }

  @Override public void loginRequest(String username, String password, ClientCallBack rmiClient)
  {
    //System.out.println("LoginRequest in server model > " + username + " " + password);

    String result = null;
    for (User onlineUser : onlineUsers)
    {
      if(onlineUser.getUsername().equals(username))
      {
        result = "User already logged in";
        server.loginResult(result, rmiClient);
      }
    }

    if(!"User already logged in".equals(result))
    {
      for (User user : registerdUsers)
      {
        if (!user.getUsername().equals(username))
          result = "User not found";
        else if (user.getPassword().equals(password))
        {
          result = "OK";
          onlineUsers.add(user);
          clients.add(rmiClient);
          System.out.println("Online users in server model > " + onlineUsers);
          break;
        }
        else
          result = "Incorrect password";
      }
      server.loginResult(result, rmiClient);
    }
  }

  @Override public void registerRequest(String username, String password, String repeatPassword, ClientCallBack rmiClient)
  {
    //System.out.println(username + " " + password + " " + repeatPassword + " " + rmiClient);
    String result = null;
    for (User registerdUser : registerdUsers)
    {
      if (registerdUser.getUsername().equals(username))
      {
        result = "Username already exists";
      }
      else
      {
        if (username.length() <= 3)
          result = "Username must be longer then 3 characters";
        else if (password.length() <= 5)
          result = "Password must be longer then 5 characters";
        else if (!password.equals(repeatPassword))
          result = "Password and repeat password must match";
        else
        {
          result = "OK";
          registerdUsers.add(new User(username, password));
          break;
        }
      }
    }
    //System.out.println("Server result to register > " + result);
    server.registerResult(result, rmiClient);
  }

  @Override public void removeClient(ClientCallBack client)
  {
    System.out.println(onlineUsers);
    for (int x = 0; x < clients.size(); x++)
    {
      if(clients.get(x).equals(client))
      {
        System.out.println("User disconnected > " + onlineUsers.get(x).getUsername());
        clients.remove(x);
        onlineUsers.remove(x);
        break;
      }
    }
    System.out.println(onlineUsers);
  }
}
