package Session_5.Exercise_LoginSystem.views.loginResult;

import Session_5.Exercise_LoginSystem.core.ViewHandler;
import Session_5.Exercise_LoginSystem.core.ViewModelFactory;
import Session_5.Exercise_LoginSystem.views.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class LoginResultController implements ViewController
{

  @FXML
  void onExitButton(ActionEvent event) {
    System.exit(0);
  }

  @Override public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {

  }
}
