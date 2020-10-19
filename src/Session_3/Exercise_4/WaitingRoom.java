package Session_3.Exercise_4;

import java.util.ArrayList;
import java.util.List;

public class WaitingRoom implements Runnable, Subject
{
  private List<Listener> listeners;

  public WaitingRoom()
  {
    listeners = new ArrayList<>();
  }

  public void updateListeners(int arg)
  {
    for(Listener listener : listeners)
      listener.update(arg);
  }

  @Override public void addListener(Listener listener)
  {
    listeners.add(listener);
  }

  @Override public void removeListener(Listener listener)
  {
    listeners.remove(listener);
  }

  public void run()
  {
    for(int x = 0; x < 15; x++)
    {
      System.out.println("Bing! " + "New number is; " + x);
      updateListeners(x);
      try
      {
        Thread.sleep(5000);
      }
      catch (InterruptedException e) { }
    }
  }
}
