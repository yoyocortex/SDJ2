package Session_4.Exercise_4_TaskList;

import Session_4.Exercise_4_TaskList.core.ModelFactory;
import Session_4.Exercise_4_TaskList.core.ViewHandler;
import Session_4.Exercise_4_TaskList.core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class TaskApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
    viewHandler.start();
  }
}
