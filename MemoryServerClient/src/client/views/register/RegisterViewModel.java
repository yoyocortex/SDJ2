package client.views.register;

import client.model.Memory;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import sharedClasses.transferObject.EventType;

import java.beans.PropertyChangeEvent;

public class RegisterViewModel
{
  private Memory model;
  private SimpleStringProperty username, password, repeatPassword, registerResponse;

  public RegisterViewModel(Memory model)
  {
    this.model = model;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    repeatPassword = new SimpleStringProperty();
    registerResponse = new SimpleStringProperty();
    this.model.addListener(EventType.REGISTER_RESULT.toString(),
        this::onRegisterResponse);
  }

  private void onRegisterResponse(PropertyChangeEvent event)
  {
    String result = (String) event.getNewValue();
    System.out.println("RegisterVM result; " + result);
    Platform.runLater(() -> registerResponse.set(result));
  }

  public void register()
  {
    //System.out.println(username.get() + " " + password.get() + " " + repeatPassword.get());
    if (username.get() == null || username.get().equals(""))
    {
      registerResponse.set("Username can not be empty.");
      return;
    }
    if (password.get() == null || password.get().equals(""))
    {
      registerResponse.set("Password can not be null");
      return;
    }
    String passwordS = password.get();
    if (!passwordS.equals(repeatPassword.get()))
    {
      registerResponse.set("Passwords do not match.");
      return;
    }
    model.register(username.get(), password.get(), repeatPassword.get());
  }

  public SimpleStringProperty usernameProperty()
  {
    return username;
  }

  public SimpleStringProperty passwordProperty()
  {
    return password;
  }

  public SimpleStringProperty repeatPasswordProperty()
  {
    return repeatPassword;
  }

  public SimpleStringProperty registerResponseProperty()
  {
    return registerResponse;
  }

  public void clear()
  {
    username.set("");
    password.set("");
    repeatPassword.set("");
    registerResponse.set("");
  }
}
