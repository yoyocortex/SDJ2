package Session_1;

public class ThreadOneClock implements Runnable
{
  volatile RealClock realClock;
  public ThreadOneClock(RealClock realClock)
  {
    this.realClock = realClock;
  }
    @Override public void run()
  {
    System.out.println("Start time; " + realClock.toString());
    for(int x = 0; x < 100; x++)
    {
      realClock.tic();
      //tic();
      //System.out.println(realClock.toString());
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e){}
    }
  }
}
