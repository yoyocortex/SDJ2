package client.networking;

import sharedClasses.transferObject.EventType;
import sharedClasses.transferObject.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class DummyClient implements Client
{
  private List<User> users;
  private PropertyChangeSupport support;

  public DummyClient()
  {
    support = new PropertyChangeSupport(this);
    users = new ArrayList<>();
    users.add(new User("Karlo", "Karlo123"));
    users.add(new User("Gosia", "Gosia123"));
  }

  @Override public void login(User user)
  {
    System.out.println(user);
    String result = "";
    boolean userFound = false;
    for (User u : users)
    {
      if(u.getUsername().equals(user.getUsername()))
      {
        if (u.getPassword().equals(user.getPassword()))
        {
          result = "OK";
        }
        else
          result = "Incorrect password";
        userFound = true;
      }
      if(!userFound)
        result = "User not found";
    }
    support.firePropertyChange(EventType.LOGIN_RESULT.toString(), null, result);
  }

  @Override public void registerUser(User userToCreate)
  {

  }

  @Override public void requestOnlinePlayers()
  {

  }

  @Override public void requestDuel(String selectedItem)
  {

  }

  @Override public void openGameView(String enemy, String host)
  {

  }

  @Override public void getShuffledDeck(User user)
  {

  }

  @Override public void getFirstTurn()
  {

  }

  @Override public void openedCard(User thisUser, String card)
  {

  }

  @Override public void reset()
  {

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
