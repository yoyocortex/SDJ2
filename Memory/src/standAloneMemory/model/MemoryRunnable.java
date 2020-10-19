package standAloneMemory.model;

import standAloneMemory.model.MemoryDeck;

public class MemoryRunnable implements Runnable
{
  private MemoryDeck memoryDeck;
  private MemoryManager memoryManager;

  public MemoryRunnable(MemoryDeck memoryDeck) {
    this.memoryDeck = memoryDeck;
    //this.memoryManager = memoryManager;
  }

  @Override public void run()
  {
    while(true)
    {
      System.out.print("MemoryRunnable ; ");
      for (int i = 0; i < memoryDeck.getShuffledDeck().length; i++)
      {
        System.out.print(memoryDeck.getShuffledDeck()[i]);
      }
      System.out.println("");
      try {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
