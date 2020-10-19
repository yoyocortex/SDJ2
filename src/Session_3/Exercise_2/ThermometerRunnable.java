package Session_3.Exercise_2;

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
      System.out.println(thermometer.id + " " + thermometer.temperature(thermometer.t, 2, thermometer.d, 0, 6));
      try
      {
        Thread.sleep(6000);
      }
      catch (InterruptedException e) { }
    }
  }

  public static class ThermometerRun
  {
    public static void main(String[] args) {
      Thermometer thermometer = new Thermometer("Room 1", 25, 7);
      ThermometerRunnable thermometerRunnable = new ThermometerRunnable(thermometer);
      Thread thread = new Thread(thermometerRunnable);
      thread.start();
      Thermometer thermometer1 = new Thermometer("Room 2", 25, 1);
      ThermometerRunnable thermometerRunnable1 = new ThermometerRunnable(thermometer1);
      Thread thread1 = new Thread(thermometerRunnable1);
      thread1.start();
    }
  }
}
