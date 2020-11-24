package Kingdom.Collection;

import Kingdom.Valuable.Valuable;

public class BlockingQueue implements GemDeposit
{
  private ListADT<Valuable> queue;

  public BlockingQueue (int capacity)
  {
    queue = new ArrayList<>();
  }

  @Override public synchronized void addToGemDeposit(Valuable valuable)
  {
    while(queue.isFull())
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        System.out.println(e.getMessage());
      }
    }
    queue.add(valuable);
    notifyAll();
    System.out.println(queue.size());
  }

  @Override public synchronized Valuable takeFromGemDeposit(int index)
  {
    while(queue.isEmpty())
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        System.out.println(e.getMessage());
      }
    }
    Valuable removedValuable = queue.remove(index);
    notifyAll();
    return removedValuable;
  }

  @Override public synchronized Valuable takeFromGemDeposit(Valuable Valuable)
  {
    while(queue.isEmpty())
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        System.out.println(e.getMessage());
      }
    }
    Valuable removedValuable = queue.remove(Valuable);
    notifyAll();
    System.out.println(queue.size());
    //System.out.println(queue.toString());
    return removedValuable;
  }

  @Override public synchronized int getSize()
  {
    return queue.size();
  }

  @Override public synchronized String toString()
  {
    return "BlockingQueue{" + queue.toString() + "}";
  }
}
