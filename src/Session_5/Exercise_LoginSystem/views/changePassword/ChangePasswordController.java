package Session_5.Exercise_LoginSystem.views.changePassword;

import Session_5.Exercise_LoginSystem.core.ViewHandler;
import Session_5.Exercise_LoginSystem.core.ViewModelFactory;
import Session_5.Exercise_LoginSystem.views.ViewController;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ChangePasswordController implements ViewController {

  @FXML
  private TextField usernameTextField;

  @FXML
  private TextField passwordTextField;

  @FXML
  private TextField newPasswordTextField;

  @FXML
  private TextField newPasswordAgainTextField;

  @FXML
  private Label resultLabel;

  private ViewHandler viewHandler;
  private ViewModelFactory viewModelFactory;
  private ChangePasswordViewModel changePasswordViewModel;

  @Override public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
    this.viewHandler = viewHandler;
    this.viewModelFactory = viewModelFactory;
    this.changePasswordViewModel = viewModelFactory.getChangePasswordViewModel();
    resultLabel.textProperty().bindBidirectional(changePasswordViewModel.changePasswordResultProperty());
    resultLabel.textProperty().addListener(this::onChangePassword);
    usernameTextField.textProperty().bindBidirectional(changePasswordViewModel.usernameProperty());
    passwordTextField.textProperty().bindBidirectional(changePasswordViewModel.passwordProperty());
    newPasswordTextField.textProperty().bindBidirectional(changePasswordViewModel.newPasswordProperty());
    newPasswordAgainTextField.textProperty().bindBidirectional(changePasswordViewModel.newPasswordAgainProperty());
  }

  private void onChangePassword(Observable observable, String old, String newVal) {
    //System.out.println(newVal);
    if("OK".equals(newVal)) {
      changePasswordViewModel.clearFields();
      viewHandler.openLoginView();
    }
  }

  @FXML
  void onCancelButton(ActionEvent event) {
    changePasswordViewModel.clearFields();
    viewHandler.openLoginView();
  }

  @FXML
  void onUpdateButton(ActionEvent event) {
    changePasswordViewModel.changePassword();
  }
}
