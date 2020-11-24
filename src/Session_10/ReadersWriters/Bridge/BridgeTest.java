package Session_10.ReadersWriters.Bridge;

public class BridgeTest
{
  public static void main(String[] args)
  {
    Bridge bridge = new Bridge();

    for (int i = 0; i < 3; i++)
    {
      Runnable runnable = () -> {
          bridge.enterFromTheLeft();
          bridge.exitToTheRight();
      };
      Thread thread = new Thread(runnable);
      thread.start();
    }

    for (int i = 0; i < 3; i++)
    {
      Runnable runnable = () -> {
        bridge.enterFromTheRight();
        bridge.exitToTheLeft();
      };
      Thread thread = new Thread(runnable);
      thread.start();
    }
  }
}
