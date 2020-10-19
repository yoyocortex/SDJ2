package Session_4.Exercise_3_TemperaturePresenter;

import Session_4.Exercise_3_TemperaturePresenter.core.ModelFactory;
import Session_4.Exercise_3_TemperaturePresenter.core.ViewHandler;
import Session_4.Exercise_3_TemperaturePresenter.core.ViewModelFactory;
import Session_4.Exercise_3_TemperaturePresenter.old.Thermometer;
import Session_4.Exercise_3_TemperaturePresenter.old.ThermometerRunnable;
import javafx.application.Application;
import javafx.stage.Stage;

public class TemperatureApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);

    Thermometer thermometer = new Thermometer(modelFactory.getTemperatureModel(), "Room 1", 25, 7);
    ThermometerRunnable thermometerRunnable = new ThermometerRunnable(thermometer);
    Thread thread = new Thread(thermometerRunnable);

    viewHandler.start();
    thread.start();
  }
}
