package Kingdom;

import java.util.ArrayList;
import java.util.List;

public class Catalogue
{
  private static List<String> queue;
  private static Catalogue catalogue;

  private Catalogue() {
    queue = new ArrayList<>();
  }

  public static synchronized Catalogue getCatalogue()
  {
    if(catalogue == null)
    {
      catalogue = new Catalogue();
    }
    return catalogue;
  }

  public synchronized void addToQueue(String logThis)
  {
    queue.add(logThis);
  }

  public synchronized List<String> getQueue()
  {
    return queue;
  }
}
