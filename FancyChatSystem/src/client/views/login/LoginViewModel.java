package client.views.login;

import client.clientmodel.login_register.Login_Register;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class LoginViewModel
{
  private Login_Register loginRegister;
  private StringProperty username, password, loginResult;

  public LoginViewModel(Login_Register loginRegister)
  {
      this.loginRegister = loginRegister;

      username = new SimpleStringProperty();
      password = new SimpleStringProperty();
      loginResult = new SimpleStringProperty();

    this.loginRegister.addListener("LoginResult", this::onLoginResult);
  }

  private void onLoginResult(PropertyChangeEvent event)
  {
    Platform.runLater(() -> loginResult.setValue((String) event.getNewValue()));
  }

  public StringProperty usernameProperty()
  {
    return username;
  }

  public StringProperty passwordProperty()
  {
    return password;
  }

  public StringProperty loginResultProperty()
  {
    return loginResult;
  }

  public void loginRequest()
  {
    loginRegister.loginRequest(username.get(), password.get());
  }
}
