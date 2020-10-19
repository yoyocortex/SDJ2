package Session_5.Exercise_LoginSystem.views.createUser;

import Session_5.Exercise_LoginSystem.core.ViewHandler;
import Session_5.Exercise_LoginSystem.core.ViewModelFactory;
import Session_5.Exercise_LoginSystem.views.ViewController;
import Session_5.Exercise_LoginSystem.views.loginView.LoginViewModel;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CreateUserController implements ViewController {

  @FXML
  private TextField usernameTextField;

  @FXML
  private TextField passwordTextField;

  @FXML
  private TextField passwordAgainTextFiled;

  @FXML
  private Label createResultLabel;

  private ViewHandler viewHandler;
  private ViewModelFactory viewModelFactory;
  private CreateUserViewModel createUserViewModel;

  @FXML
  void onCancelButton(ActionEvent event) {
    createUserViewModel.clearFields();
    viewHandler.openLoginView();
  }

  @FXML
  void onCreateButton(ActionEvent event) {
    System.out.println("createButton");
    createUserViewModel.attemptCreateUser();
  }

  @Override public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
    this.viewHandler = viewHandler;
    this.viewModelFactory = viewModelFactory;
    createUserViewModel = this.viewModelFactory.getCreateUserViewModel();
    createResultLabel.textProperty().bindBidirectional(createUserViewModel.createUserResultProperty());
    createResultLabel.textProperty().addListener(this::onCreateUser);
    usernameTextField.textProperty().bindBidirectional(createUserViewModel.userNameProperty());
    passwordTextField.textProperty().bindBidirectional(createUserViewModel.passwordProperty());
    passwordAgainTextFiled.textProperty().bindBidirectional(createUserViewModel.passwordAgainProperty());
  }

  private void onCreateUser(Observable observable, String old, String newVal) {
    //System.out.println(newVal);
    if("OK".equals(newVal)) {
      createUserViewModel.clearFields();
      viewHandler.openLoginView();
    }
  }
}
