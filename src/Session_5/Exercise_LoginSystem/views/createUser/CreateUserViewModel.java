package Session_5.Exercise_LoginSystem.views.createUser;

import Session_5.Exercise_LoginSystem.model.LoginModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class CreateUserViewModel
{
  private StringProperty username = new SimpleStringProperty();
  private StringProperty password = new SimpleStringProperty();
  private StringProperty passwordAgain = new SimpleStringProperty();
  private StringProperty createUserResult = new SimpleStringProperty();
  private LoginModel loginModel;

  public CreateUserViewModel(LoginModel loginModel) {
    this.loginModel = loginModel;
    this.loginModel.addListener("CreateUserResult", this::onCreateUser);
  }

  public void clearFields() {
    username.setValue("");
    password.setValue("");
    passwordAgain.setValue("");
    createUserResult.setValue("");
  }

  private void onCreateUser(PropertyChangeEvent propertyChangeEvent) {
    createUserResult.setValue((String) propertyChangeEvent.getNewValue());
  }

  public void attemptCreateUser() {
    loginModel.createUser(username.getValue(), password.getValue(), passwordAgain.getValue());
  }

  public StringProperty userNameProperty() {
    return username;
  }

  public StringProperty passwordProperty() {
    return password;
  }

  public StringProperty passwordAgainProperty() {
    return passwordAgain;
  }

  public StringProperty createUserResultProperty() {
    return createUserResult;
  }
}
