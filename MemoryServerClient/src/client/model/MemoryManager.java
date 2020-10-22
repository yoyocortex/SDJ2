package client.model;

import client.networking.Client;
import sharedClasses.transferObject.EventType;
import sharedClasses.transferObject.User;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class MemoryManager implements Memory{

  private Client client;
  private User loggedInUser;
  private PropertyChangeSupport support;

  public MemoryManager(Client client)
  {
    support = new PropertyChangeSupport(this);
    this.client = client;
    this.client.addListener(EventType.LOGIN_RESULT.toString(), this::onLoginResult);
    this.client.addListener(EventType.REGISTER_RESULT.toString(), evt -> support.firePropertyChange(evt));
    this.client.addListener(EventType.USERSLIST_RESULT.toString(), this::onAllUsers);
    this.client.addListener(EventType.DUEL_RESULT.toString(), evt -> support.firePropertyChange(evt));
    this.client.addListener(EventType.OPEN_GAME_VIEW_RESULT.toString(), evt -> support.firePropertyChange(evt));
    this.client.addListener(EventType.SHUFFED_DECK_RESULT.toString(), evt -> support.firePropertyChange(evt));
    this.client.addListener(EventType.GET_FIRST_TURN_RESULT.toString(), evt -> support.firePropertyChange(evt));
    this.client.addListener(EventType.KEEP_OPEN.toString(), evt -> support.firePropertyChange(evt));
    this.client.addListener(EventType.FIRST_PLAYER_SCORE.toString(), evt -> support.firePropertyChange(evt));
    this.client.addListener(EventType.SECOND_PLAYER_SCORE.toString(), evt -> support.firePropertyChange(evt));
    this.client.addListener(EventType.SEND_PAIR_NOTIFICATION.toString(), evt -> support.firePropertyChange(evt));
    this.client.addListener(EventType.RESET_RESULT.toString(), evt -> support.firePropertyChange(evt));
  }

  private void onAllUsers(PropertyChangeEvent event)
  {
    List<User> newValue = (List<User>) event.getNewValue();
    support.firePropertyChange(EventType.USERSLIST_RESULT.toString(), null, newValue);
  }

  @Override public void getOnlinePlayers()
  {
    client.requestOnlinePlayers();
    support.firePropertyChange("LoggedInUser", null, loggedInUser);
  }

  @Override public void requestDuel(String selectedItem)
  {
    client.requestDuel(selectedItem);
  }

  @Override public void openGameView(String enemy, String host)
  {
    client.openGameView(enemy, host);
  }

  @Override public void getShuffledDeck(User user)
  {
    client.getShuffledDeck(user);
  }

  @Override public void getFirstTurn()
  {
    client.getFirstTurn();
  }

  @Override public void openedCard(User thisUser, String card)
  {
    client.openedCard(thisUser, card);
  }

  @Override public void reset()
  {
    client.reset();
  }

  private void onLoginResult(PropertyChangeEvent propertyChangeEvent)
  {
    String loginResult = (String) propertyChangeEvent.getNewValue();

    if(!loginResult.equals("OK"))
    {
      loggedInUser = null;
    }
    support.firePropertyChange(EventType.LOGIN_RESULT.toString(), null, loginResult);
  }

  @Override public void register(String username, String password, String repeatPassword)
  {
    User userToCreate = new User(username, password);
    client.registerUser(userToCreate);
  }

  @Override public void login(String username, String password)
  {
    loggedInUser = new User(username,password);
    client.login(loggedInUser);
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
