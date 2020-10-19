package Session_5.Exercise_LoginSystem.views.changePassword;

import Session_5.Exercise_LoginSystem.model.LoginModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;

public class ChangePasswordViewModel
{
  private LoginModel loginModel;
  private StringProperty username = new SimpleStringProperty();
  private StringProperty password = new SimpleStringProperty();
  private StringProperty newPassword = new SimpleStringProperty();
  private StringProperty newPasswordAgain = new SimpleStringProperty();
  private StringProperty changePasswordResult = new SimpleStringProperty();

  public ChangePasswordViewModel(LoginModel loginModel) {
    this.loginModel = loginModel;
    this.loginModel.addListener("ChangePasswordResult",this::onChangePassword);
  }

  public void onChangePassword(PropertyChangeEvent propertyChangeEvent) {
  changePasswordResult.setValue((String) propertyChangeEvent.getNewValue());
  }

  public void changePassword() {
    loginModel.changePassword(username.getValue(), password.getValue(), newPassword.getValue(), newPasswordAgain.getValue());
  }

  public void clearFields() {
    username.setValue("");
    password.setValue("");
    newPassword.setValue("");
    newPasswordAgain.setValue("");
    changePasswordResult.setValue("");
  }

  public StringProperty usernameProperty() {
    return username;
  }

  public StringProperty passwordProperty() {
    return password;
  }

  public StringProperty newPasswordProperty() {
    return newPassword;
  }

  public StringProperty newPasswordAgainProperty() {
    return newPasswordAgain;
  }

  public StringProperty changePasswordResultProperty() {
    return changePasswordResult;
  }
}