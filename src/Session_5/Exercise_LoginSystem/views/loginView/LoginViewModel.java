package Session_5.Exercise_LoginSystem.views.loginView;

import Session_5.Exercise_LoginSystem.model.LoginModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class LoginViewModel
{
  private LoginModel loginModel;
  private StringProperty loginResult = new SimpleStringProperty(), userName = new SimpleStringProperty(), password = new SimpleStringProperty();

  public LoginViewModel(LoginModel loginModel) {
    this.loginModel = loginModel;
    loginModel.addListener("LoginResult", this::onLoginResult);
  }

  private void onLoginResult(PropertyChangeEvent propertyChangeEvent) {
    String result = (String)propertyChangeEvent.getNewValue();
    if("OK".equals(result)) {
      clearFields();
    }
    loginResult.setValue(result);
    //System.out.println("loginResult " + result);
  }

  public void clearFields() {
    userName.setValue("");
    password.setValue("");
  }

  public void validateLogin() {
    System.out.println("validateLoginMethod");
    loginModel.validateLogin(userName.getValue(), password.getValue());
  }

  public StringProperty loginResultProperty() {
    return loginResult;
  }

  public StringProperty userNameProperty() {
    return userName;
  }

  public StringProperty passwordProperty() {
    return password;
  }
}
