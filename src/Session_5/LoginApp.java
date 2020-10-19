package Session_5;

import Session_5.Exercise_LoginSystem.core.ModelFactory;
import Session_5.Exercise_LoginSystem.core.ViewHandler;
import Session_5.Exercise_LoginSystem.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class LoginApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
    viewHandler.start();
  }
}
