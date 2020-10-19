package Session_4.Exercise_1_Uppercase;

import Session_4.Exercise_1_Uppercase.core.ModelFactory;
import Session_4.Exercise_1_Uppercase.core.ViewHandler;
import Session_4.Exercise_1_Uppercase.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class UppercaseApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
    viewHandler.start();
  }
}
