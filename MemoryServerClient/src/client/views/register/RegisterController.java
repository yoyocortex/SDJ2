package client.views.register;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class RegisterController
{
  @FXML
  private TextField usernameField;

  @FXML
  private TextField passwordField;

  @FXML
  private TextField repeatPasswordField;

  @FXML
  private Label resultLabel;

  private RegisterViewModel registerViewModel;
  private ViewHandler viewHandler;

  public void init(RegisterViewModel registerViewModel, ViewHandler viewHandler) {
    this.registerViewModel = registerViewModel;
    this.viewHandler = viewHandler;
    usernameField.textProperty().bindBidirectional(this.registerViewModel.usernameProperty());
    passwordField.textProperty().bindBidirectional(this.registerViewModel.passwordProperty());
    repeatPasswordField.textProperty().bindBidirectional(this.registerViewModel.repeatPasswordProperty());
    resultLabel.textProperty().bind(this.registerViewModel.registerResponseProperty());
    this.registerViewModel.registerResponseProperty().addListener((observableValue, oldValue, newValue) -> onLoginResult(newValue));
  }

  private void onLoginResult(String newValue)
  {
    if(newValue.equals("OK"))
    {
      registerViewModel.clear();
      viewHandler.openLoginView();
    }
  }

  @FXML
  void onBackButton(ActionEvent event) {
    registerViewModel.clear();
    viewHandler.openLoginView();
  }

  @FXML
  void onRegisterButton(ActionEvent event) {
    registerViewModel.register();
  }
}
