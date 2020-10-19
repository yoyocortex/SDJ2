package client.views.login;

import client.model.Memory;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import sharedClasses.transferObject.EventType;

import java.beans.PropertyChangeEvent;

public class LoginViewModel
{
  private Memory model;
  private SimpleStringProperty username, password, loginResult;

  public LoginViewModel(Memory model)
  {
    this.model = model;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    loginResult = new SimpleStringProperty();
    this.model.addListener(EventType.LOGIN_RESULT.toString(), this::onLoginResult);
  }

  private void onLoginResult(PropertyChangeEvent event)
  {
    String result = (String) event.getNewValue();
    System.out.println("LoginVM result; " + result);
    Platform.runLater(() -> loginResult.set(result));
  }

  public void login() {
    //System.out.println(username.get() + " " + password.get());
    model.login(username.get(), password.get());
  }

  public SimpleStringProperty loginResultProperty()
  {
    return loginResult;
  }

  public SimpleStringProperty usernameProperty()
  {
    return username;
  }

  public SimpleStringProperty passwordProperty()
  {
    return password;
  }
}
