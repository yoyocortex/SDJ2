package Session_4.Exercise_3_TemperaturePresenter.old;

public class ThermometerRunnable implements Runnable
{
  private Thermometer thermometer;

  public ThermometerRunnable(Thermometer thermometer)
  {
    this.thermometer = thermometer;
  }

  @Override public void run()
  {
    while(true)
    {
      //System.out.println(thermometer.id + " " + thermometer.temperature(thermometer.t, 2, thermometer.d, 0, 6));
      thermometer.temperature(thermometer.t, 2, thermometer.d, 0, 6);
      try
      {
        Thread.sleep(4000);
      }
      catch (InterruptedException e) { }
    }
  }
}
