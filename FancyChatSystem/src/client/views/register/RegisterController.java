package client.views.register;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
   this.viewHandler = viewHandler;
   this.registerViewModel = registerViewModel;

   usernameField.textProperty().bindBidirectional(this.registerViewModel.usernameProperty());
   passwordField.textProperty().bindBidirectional(this.registerViewModel.passwordProperty());
   repeatPasswordField.textProperty().bindBidirectional(this.registerViewModel.repeatPasswordProperty());
   resultLabel.textProperty().bindBidirectional(this.registerViewModel.resultProperty());

   this.registerViewModel.resultProperty().addListener((observableValue, oldValue, newValue) -> onRegisterResult(newValue));
  }

  private void onRegisterResult(String newValue)
  {
    if(newValue.equals("OK"))
    {
      usernameField.clear();
      passwordField.clear();
      repeatPasswordField.clear();
      resultLabel.setText("");
      viewHandler.openLoginView();
    }
  }

  @FXML
  void onBackButton(ActionEvent event) {
    usernameField.clear();
    passwordField.clear();
    repeatPasswordField.clear();
    resultLabel.setText("");
    viewHandler.openLoginView();
  }

  @FXML
  void onRegisterButton(ActionEvent event) {
    System.out.println("On register button.");
    registerViewModel.registerRequest();
  }
}
