package client.views.login;

import client.core.ViewHandler;
import javafx.application.Platform;
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

    @FXML
    void onLoginButton(ActionEvent event) {
      System.out.println("Login button.");
      //Platform.exit();
      loginViewModel.loginRequest();
    }

    @FXML
    void onRegisterButton(ActionEvent event) {
      System.out.println("Register button.");
      usernameLabel.clear();
      passwordLabel.clear();
      errorLabel.setText("");
      viewHandler.openRegisterView();
    }

  private LoginViewModel loginViewModel;
  private ViewHandler viewHandler;

  public void init(LoginViewModel loginViewModel, ViewHandler viewHandler)
  {
    this.loginViewModel = loginViewModel;
    this.viewHandler = viewHandler;

    usernameLabel.textProperty().bindBidirectional(this.loginViewModel.usernameProperty());
    passwordLabel.textProperty().bindBidirectional(this.loginViewModel.passwordProperty());
    errorLabel.textProperty().bindBidirectional(this.loginViewModel.loginResultProperty());

    this.loginViewModel.loginResultProperty().addListener((observableValue, oldValue, newValue) -> onLoginResult(newValue));
  }

  private void onLoginResult(String newValue)
  {
    if(newValue.equals("OK"))
    {
      usernameLabel.clear();
      passwordLabel.clear();
      errorLabel.setText("");

      viewHandler.openChatView();
    }
  }
}
