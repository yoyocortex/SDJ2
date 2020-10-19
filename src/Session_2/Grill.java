package Session_2;

public class Grill
{
  private int maxBurgers = 50;
  private int readyBurgers;
  private int numOfMadeBurgers, numOfBoughtBurgers;

  public synchronized int getMaxBurgers()
  {
    return maxBurgers;
  }

  public synchronized void makeBurgers(int x)
  {
    readyBurgers += x;
    numOfMadeBurgers += x;
  }

  public synchronized int getReadyBurgers()
  {
    return readyBurgers;
  }

  public synchronized void buyBurgers(int x)
  {
    readyBurgers -= x;
    numOfBoughtBurgers += x;
  }

  public int getNumOfMadeBurgers()
  {
    return numOfMadeBurgers;
  }

  public int getNumOfBoughtBurgers()
  {
    return numOfBoughtBurgers;
  }

  public static void main(String[] args)
  {
    Grill grill = new Grill();

    GrillCooks grillCooks = new GrillCooks(grill);
    Thread grillCooksThreads = new Thread(grillCooks);
    grillCooksThreads.start();

    GrillCustomer grillCustomer = new GrillCustomer(grill);
    Thread grillCustomerThread = new Thread(grillCustomer);
    grillCustomerThread.start();
  }
}
