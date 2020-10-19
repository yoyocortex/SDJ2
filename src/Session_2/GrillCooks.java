package Session_2;

import java.util.Random;

public class GrillCooks implements Runnable
{
  private int numOfCooks = 3;
  private Grill grill;
  private Random random = new Random();
  private int nextBatch;
  public GrillCooks(Grill grill)
  {
    this.grill = grill;
  }
  @Override public void run()
  {
    System.out.println("Number of cooks; " + numOfCooks);
    System.out.println("Ready burgers; " + grill.getReadyBurgers() + "/" + grill.getMaxBurgers());
    while(true)
    {
      if (grill.getMaxBurgers() == grill.getReadyBurgers());
      else
      {
        nextBatch = random.nextInt(3) + 1;
        if (grill.getMaxBurgers() >= grill.getReadyBurgers() + nextBatch)
        {
          grill.makeBurgers(nextBatch);
          System.out.println("Ready burgers; " + grill.getReadyBurgers() + "/" + grill.getMaxBurgers() +
              " , Total number of burgers made; " + grill.getNumOfMadeBurgers());
          try
          {
            Thread.sleep(random.nextInt(15000));
          }
          catch (InterruptedException e){}
        }
        else
        {
          grill.makeBurgers(grill.getMaxBurgers() - grill.getReadyBurgers());
          System.out.println("Ready burgers; " + grill.getReadyBurgers() + "/" + grill.getMaxBurgers()  +
              " , Total number of burgers made; " + grill.getNumOfMadeBurgers());
          try
          {
            Thread.sleep(random.nextInt(15000));
          }
          catch (InterruptedException e)
          {
          }
        }
      }
    }
  }
}
