package server.dataaccess;

import sharedClasses.transferObject.User;

import java.util.ArrayList;
import java.util.List;

public class InMemoryUsers implements UserHome
{
  private List<User> registerUsers;
  private List<User> loggedInUsers;

  public InMemoryUsers()
  {
    loggedInUsers = new ArrayList<>();
    registerUsers = new ArrayList<>();
    registerUsers.add(new User("Karlo", "Karlo123"));
    registerUsers.add(new User("Gosia", "Gosia123"));
    registerUsers.add(new User("Lukas", "Lukas123"));
    registerUsers.add(new User("Piotr", "Piotr123"));
  }

  @Override public String validateUser(User user)
  {
    String result = "";
    boolean userFound = false;
    for (User u : registerUsers)
    {
      if(u.getUsername().equals(user.getUsername()))
      {
        if (u.getPassword().equals(user.getPassword()))
        {
          result = "OK";
          loggedInUsers.add(u);
        }
        else
          result = "Incorrect password";
        userFound = true;
      }
      if(!userFound)
        result = "User not found";
    }
    return result;
  }

  public User findUser(String username)
  {
    for (User u : registerUsers)
    {
      if(u.getUsername().equals(username))
        return u;
    }
    return null;
  }

  @Override public String registerUser(User user)
  {
    registerUsers.add(user);
    //System.out.println(users);
    return "OK";
  }

  @Override public List<User> getAllOnlineUsers()
  {
    //System.out.println(users);
    return loggedInUsers;
  }

  @Override public void removeOnlineUser(User user)
  {
    //System.out.println(loggedInUsers);
    for(int i = 0; i < loggedInUsers.size(); i++)
    {
      if(loggedInUsers.get(i).getUsername().equals(user.getUsername()))
        loggedInUsers.remove(i);
      //break;
    }
    //System.out.println(loggedInUsers);
  }
}
