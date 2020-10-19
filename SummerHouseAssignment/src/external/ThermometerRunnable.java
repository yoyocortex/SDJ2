package external;

public class ThermometerRunnable implements Runnable
{
  private Thermometer thermometer;

  public ThermometerRunnable(Thermometer thermometer) {
    this.thermometer = thermometer;
  }

  @Override public void run()
  {
    while(true)
    {
      if(thermometer.getId().equals("Outdoor"))
      {
        System.out.println(thermometer.getId() + " " + thermometer.getT0());
        thermometer.externalTemperature(thermometer.getT0(), -10, 25);
      }
      else
      {
        System.out.println("ID : " + thermometer.getId() + " Temp :" + thermometer.getT() + " Toutside :" + thermometer.getT0()
            + " Rpower" + thermometer.getRadiator().getPower());
        thermometer.temperature(thermometer.getT(), 2, thermometer.getD(), 0, 6);
      }
      try
      {
        Thread.sleep(6000);
      }
      catch (InterruptedException e) { }
    }
  }
}
