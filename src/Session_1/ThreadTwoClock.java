package Session_1;

public class ThreadTwoClock implements Runnable
{
  private RealClock realClock;
  private ThreadOneClock threadOneClock;
  private int seconds;
  //private boolean printSwitch = false;
  public ThreadTwoClock(RealClock realClock, ThreadOneClock threadOneClock)
  {
    this.realClock = realClock;
    this.threadOneClock = threadOneClock;
    seconds = this.realClock.getSeconds();
  }

  @Override public void run()
  {
    while(true)
    {
      if(threadOneClock.realClock.getSeconds() == seconds + 10)
      {
        //realClock.tic(10);
        System.out.println(realClock.toString());
        //printSwitch = true;
        seconds += 10;
      }
      /*
        if(printSwitch)
        {
          System.out.print(seconds + ".............................");
          printSwitch = false;
        }
      */
      //System.out.println(printSwitch);
      //System.out.println(seconds);
      //System.out.println(seconds);
      //System.out.println(threadOneClock.realClock.getSeconds());
    }
    /*
        try
        {
          Thread.sleep(10000);
        }
        catch (InterruptedException e){}
    */
  }
}
