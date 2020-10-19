package Session_5.Exercise_LoginSystem.views.loginView;

import Session_5.Exercise_LoginSystem.core.ViewHandler;
import Session_5.Exercise_LoginSystem.core.ViewModelFactory;
import Session_5.Exercise_LoginSystem.views.ViewController;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginController implements ViewController
{

  @FXML
  private TextField usernameTextField;

  @FXML
  private TextField passwordTextField;

  @FXML
  private Label loginResultLabel;

  private ViewHandler viewHandler;
  private ViewModelFactory viewModelFactory;
  private LoginViewModel loginViewModel;

  @FXML
  void onChangePasswordButton(ActionEvent event) {
    System.out.println("changePassButton");
    loginViewModel.clearFields();
    viewHandler.openChangePasswordView();
  }

  @FXML
  void onExitButton(ActionEvent event) {
    System.out.println("exitButton");
    System.exit(0);
  }

  @FXML
  void onLoginButton(ActionEvent event) {
    System.out.println("loginButton");
    loginViewModel.validateLogin();
  }

  @FXML
  void onRegisterButton(ActionEvent event) {
    System.out.println("registerButton");
    loginViewModel.clearFields();
    viewHandler.openCreateUserView();
  }

  @Override public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
    this.viewHandler = viewHandler;
    this.viewModelFactory = viewModelFactory;
    this.loginViewModel = viewModelFactory.getLoginViewModel();
    loginResultLabel.textProperty().bindBidirectional(loginViewModel.loginResultProperty());
    loginResultLabel.textProperty().addListener(this::onLoginResult);
    usernameTextField.textProperty().bindBidirectional(loginViewModel.userNameProperty());
    passwordTextField.textProperty().bindBidirectional(loginViewModel.passwordProperty());
  }

  private void onLoginResult(Observable observable, String old, String newVal) {
    if("OK".equals(newVal)) {
      viewHandler.openSuccessfulLoginView();
    }
  }
}
