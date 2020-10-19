import client.core.ModelFactory;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import external.Thermometer;
import external.ThermometerRunnable;
import javafx.application.Application;
import javafx.stage.Stage;

public class TempApp extends Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    Thermometer thermometer = new Thermometer(modelFactory.getTemperatureModel(), "Thermometer 1", 15, 1);
    ThermometerRunnable thermometerRunnable = new ThermometerRunnable(thermometer);
    Thread thread = new Thread(thermometerRunnable);

    Thermometer thermometer1 = new Thermometer(modelFactory.getTemperatureModel(), "Thermometer 2", 15, 7);
    ThermometerRunnable thermometerRunnable1 = new ThermometerRunnable(thermometer1);
    Thread thread1 = new Thread(thermometerRunnable1);

    Thermometer thermometer2 = new Thermometer(modelFactory.getTemperatureModel(), "Outdoor");
    ThermometerRunnable thermometerRunnable2 = new ThermometerRunnable(thermometer2);
    Thread thread2 = new Thread(thermometerRunnable2);

    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);

    viewHandler.Start();
    //thread.setDaemon(true);
    //thread1.setDaemon(true);
    //thread2.setDaemon(true);
    thread.start();
    thread1.start();
    thread2.start();
  }
}
