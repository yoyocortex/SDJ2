package Session_2;

import java.util.Random;

public class GrillCustomer implements Runnable
{
  private Random random = new Random();
  private Grill grill;
  private int boughtBugers;
  public GrillCustomer(Grill grill)
  {
    this.grill = grill;
  }
  @Override public void run()
  {
    while(true)
    {
      boughtBugers = random.nextInt(3) + 1;
      if (grill.getReadyBurgers() - boughtBugers >= 0)
      {
        grill.buyBurgers(boughtBugers);
        System.out.println("Bought burgers; " + boughtBugers + " , Burgers left; " + grill.getReadyBurgers() + "/"
            + grill.getMaxBurgers()  + " , Total number of burgers sold; " + grill.getNumOfBoughtBurgers());
        try
        {
          Thread.sleep(random.nextInt(25000));
        }
        catch(InterruptedException e){}
      }
    }
  }
}
