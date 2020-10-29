package client.clientmodel.login_register;

import client.networking.Client;
import shared.util.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Login_RegisterManager implements Login_Register
{
  private Client client;
  private PropertyChangeSupport support;

  public Login_RegisterManager(Client client)
  {
    this.client = client;
    support = new PropertyChangeSupport(this);

    this.client.addListener("LoginResult", evt -> support.firePropertyChange(evt));
    this.client.addListener("RegisterResult", evt -> support.firePropertyChange(evt));
    this.client.addListener("OnlineUsers", evt -> support.firePropertyChange(evt));
    this.client.addListener("LoggedInAs", evt -> support.firePropertyChange(evt ));
    this.client.addListener("MessageBack", evt -> support.firePropertyChange(evt));
  }

  @Override public void loginRequest(String username, String password)
  {
    client.loginRequest(username, password);
  }

  @Override public void registerRequest(String username, String password, String repeatPassword)
  {
    client.registerRequest(username, password, repeatPassword);
  }

  @Override public void onlineUsersRequest()
  {
    client.onlineUsersRequest();
  }

  @Override public void sendMessage(Message message)
  {
    client.sendMessage(message);
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
