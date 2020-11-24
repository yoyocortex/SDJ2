package Session_10.ReadersWriters.Bridge;

public class Bridge implements Lane
{
  private int carsOnLeft;
  private int carsOnRight;
  private boolean leftFirst;

  @Override public synchronized void enterFromTheLeft()
  {
    leftFirst = true;
    carsOnLeft++;
    System.out.println("Car " + carsOnLeft + "L has entered the bridge from the left side!");
    while(carsOnRight > 0)
    {
      try
      {
        System.out.println("Car " + carsOnLeft + "L is waiting for the right lane car on the bridge to pass!");
        wait();
      }
      catch (InterruptedException ignored) {}
    }
  }

  @Override public synchronized void exitToTheRight()
  {
    if(carsOnRight == 0)
    {
      System.out.println("Car " + carsOnLeft + "L from the left has left the bridge!");
      carsOnLeft--;
      if(carsOnLeft == 0) leftFirst = false;
      notifyAll();
    }
  }

  @Override public synchronized void exitToTheLeft()
  {
    if(carsOnLeft == 0 && !leftFirst)
    {
      System.out.println("Car " + carsOnRight + "R from the right has left the bridge!");
      carsOnRight--;
      notifyAll();
    }
  }

  @Override public synchronized void enterFromTheRight()
  {
    if(!leftFirst)
    {
      carsOnRight++;
      System.out.println("Car " + carsOnRight + "R has entered the bridge from the right side!");
      while (carsOnLeft > 0)
      {
        try
        {
          System.out.println("Car " + carsOnRight + "R is waiting for the left lane car on the bridge to pass!");
          wait();
        }
        catch (InterruptedException ignored)
        {
        }
      }
    }
  }
}
