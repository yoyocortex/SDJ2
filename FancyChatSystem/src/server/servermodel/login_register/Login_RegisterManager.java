package server.servermodel.login_register;

import server.networking.RMIRMIServer;
import shared.networking.ClientCallBack;
import shared.util.Message;
import shared.util.User;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

public class Login_RegisterManager implements Login_Register
{
  private List<User> registerdUsers;
  private List<User> onlineUsers;
  private List<ClientCallBack> clients;
  private List<String> messageList;

  private RMIRMIServer server;
  private String previusToClient = "";
  private String previusFromClient = "";

  public Login_RegisterManager(RMIRMIServer rmirmiServer)
  {
    server = rmirmiServer;

    clients = new ArrayList<>();

    registerdUsers = new ArrayList<>();
    registerdUsers.add(new User("Karlo", "Karlo123"));
    registerdUsers.add(new User("Gosia", "Gosia123"));
    registerdUsers.add(new User("Lukas", "Lukas123"));

    onlineUsers = new ArrayList<>();
    messageList = new ArrayList<>();

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
          }
        }
        try
        {
          Thread.sleep(100);
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

          sendUpdatedOnlineUserList(onlineUsers, clients);
          break;
        }
        else
          result = "Incorrect password";
      }
      server.loginResult(result, rmiClient);
    }
  }

  private void sendUpdatedOnlineUserList(List<User> onlineUsers, List<ClientCallBack> clients)
  {
    server.sendUpdatedOnlineUserList(onlineUsers, clients);
  }

  @Override public void registerRequest(String username, String password, String repeatPassword, ClientCallBack rmiClient)
  {
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
    server.registerResult(result, rmiClient);
  }

  @Override public void removeClient(ClientCallBack client)
  {
    for (int x = 0; x < clients.size(); x++)
    {
      if(clients.get(x).equals(client))
      {
        System.out.println("User disconnected > " + onlineUsers.get(x).getUsername());
        clients.remove(x);
        onlineUsers.remove(x);
        sendUpdatedOnlineUserList(onlineUsers, clients);
        break;
      }
    }
  }

  @Override public void onlineUsersRequest()
  {
    sendUpdatedOnlineUserList(onlineUsers, clients);
  }

  @Override public void sendMessage(Message message)
  {
    if(previusFromClient.equals(message.getFromUser()) && previusToClient.equals(message.getToUser()) ||
        previusToClient.equals(message.getFromUser()) && previusFromClient.equals(message.getToUser()))
    {
      messageList.add(message.getFromUser());
      messageList.add(message.getToUser());
      messageList.add(message.getText());
      messageList.add(message.getDate_time());

      ClientCallBack fromClient = null;
      ClientCallBack toClient = null;

      for (int x = 0; x < onlineUsers.size(); x++)
      {
        if (message.getFromUser().equals(onlineUsers.get(x).getUsername()))
        {
          fromClient = clients.get(x);
        }
        else if (message.getToUser().equals(onlineUsers.get(x).getUsername()))
        {
          toClient = clients.get(x);
        }
      }

      server.messageBack(fromClient, toClient, message);

      messageList = new ArrayList<>();
      previusFromClient = message.getFromUser();
      previusToClient = message.getToUser();
    }
    else
    {
      ClientCallBack fromClient = null;
      ClientCallBack toClient = null;

      for (int x = 0; x < onlineUsers.size(); x++)
      {
        if (message.getFromUser().equals(onlineUsers.get(x).getUsername()))
        {
          fromClient = clients.get(x);
        }
        else if (message.getToUser().equals(onlineUsers.get(x).getUsername()))
        {
          toClient = clients.get(x);
        }
      }

      messageList = new ArrayList<>();
      server.messageBack(fromClient, toClient, new Message("", "", "", ""));

      messageList.add(message.getFromUser());
      messageList.add(message.getToUser());
      messageList.add(message.getText());
      messageList.add(message.getDate_time());


      server.messageBack(fromClient, toClient, message);

      messageList = new ArrayList<>();
      previusFromClient = message.getFromUser();
      previusToClient = message.getToUser();
    }
  }
}
