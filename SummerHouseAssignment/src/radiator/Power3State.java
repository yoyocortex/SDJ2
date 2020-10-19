package radiator;

import javafx.application.Platform;

public class Power3State implements RadiatorState
{
  private static int POWER = 3;

  public Power3State(Radiator radiator) {
    Runnable runnable = () -> {
      try
      {
        System.out.println("10s and counting");
        Thread.sleep(10000);
        radiator.setPowerState(new Power2State());
        if (Thread.interrupted()) {
          System.out.println("Thread interrupted");
          throw new InterruptedException();
        }
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    };
    Thread t = new Thread(runnable);
    t.setDaemon(true);
    t.start();
  }

  @Override public void turnUp(Radiator radiator)
  {

  }

  @Override public void turnDown(Radiator radiator)
  {
    Thread.interrupted();
    radiator.setPowerState(new Power2State());
  }

  @Override public int getPower()
  {
    return POWER;
  }
}
