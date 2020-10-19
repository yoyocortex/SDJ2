package client.views.login;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class LoginController
{
  @FXML
  private TextField usernameLabel;

  @FXML
  private TextField passwordLabel;

  @FXML
  private Label errorLabel;

  private LoginViewModel loginViewModel;
  private ViewHandler viewHandler;

  public void init(LoginViewModel loginViewModel, ViewHandler viewHandler) {
    this.loginViewModel = loginViewModel;
    this.viewHandler = viewHandler;
    usernameLabel.textProperty().bindBidirectional(this.loginViewModel.usernameProperty());
    passwordLabel.textProperty().bindBidirectional(this.loginViewModel.passwordProperty());
    errorLabel.textProperty().bind(this.loginViewModel.loginResultProperty());
    this.loginViewModel.loginResultProperty().addListener((observableValue, s, t1) -> onLoginResult(t1));
  }

  private void onLoginResult(String t1)
  {
    if(t1.equals("OK"))
    {
      errorLabel.setTextFill(Color.GREEN);
      viewHandler.openStartMenuView();
      //System.out.println("Swap to lobby view");
    }
    errorLabel.setTextFill(Color.RED);
  }

  @FXML
  void onLoginButton(ActionEvent event) {
    //System.out.println("Log in pressed");
    loginViewModel.login();
  }

  @FXML
  void onRegisterButton(ActionEvent event) {
    //System.out.println("Register pressed");
    viewHandler.openRegisterView();
  }
}
