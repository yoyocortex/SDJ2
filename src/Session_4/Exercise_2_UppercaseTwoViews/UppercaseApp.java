package Session_4.Exercise_2_UppercaseTwoViews;

import Session_4.Exercise_2_UppercaseTwoViews.core.ModelFactory;
import Session_4.Exercise_2_UppercaseTwoViews.core.ViewHandler;
import Session_4.Exercise_2_UppercaseTwoViews.core.ViewModelFactory;
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
