package client.views.register;

import client.clientmodel.login_register.Login_Register;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class RegisterViewModel
{
  private Login_Register loginRegisterModel;
  private StringProperty username, password, repeatPassword, result;

  public RegisterViewModel(Login_Register loginRegisterModel)
  {
    this.loginRegisterModel = loginRegisterModel;

    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    repeatPassword = new SimpleStringProperty();
    result = new SimpleStringProperty();

    loginRegisterModel.addListener("RegisterResult", this::registerResult);
  }

  private void registerResult(PropertyChangeEvent event)
  {
    Platform.runLater(() -> result.set((String) event.getNewValue()));
  }

  public StringProperty usernameProperty()
  {
    return username;
  }

  public StringProperty passwordProperty()
  {
    return password;
  }

  public StringProperty repeatPasswordProperty()
  {
    return repeatPassword;
  }

  public StringProperty resultProperty()
  {
    return result;
  }

  public void registerRequest()
  {
    loginRegisterModel.registerRequest(username.get(), password.get(), repeatPassword.get());
  }
}
