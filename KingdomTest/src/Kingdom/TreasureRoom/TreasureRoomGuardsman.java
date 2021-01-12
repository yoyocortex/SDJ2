package Kingdom.TreasureRoom;

import Kingdom.TreasureRoom.TreasureRoom;
import Kingdom.TreasureRoom.TreasureRoomDoor;
import Kingdom.Valuable.Valuable;

import java.util.List;

//I choose to do the writer preference because writers should get the information first
// about how many gems there is currently so they can request more or act accordingly

public class TreasureRoomGuardsman implements TreasureRoomDoor
{
  Kingdom.TreasureRoom.TreasureRoom treasureRoom = new TreasureRoom();
  private boolean activeWriters;
  private int activeReaders;
  private int waitingReaders;

  @Override public synchronized void acquireReadAccess(String actorName)
  {
    treasureRoom.acquireReadAccess(actorName);
    waitingReaders++;
    while (activeWriters)
    {
      try
      {
        wait();
      }
      catch (InterruptedException ignored) {}
    }
    waitingReaders--;
    activeReaders++;
  }

  @Override public synchronized void acquireWriteAccess(String actorName)
  {
    treasureRoom.acquireWriteAccess(actorName);
    while(activeWriters || activeReaders > 0 || waitingReaders > 0)
    {
      try
      {
        wait();
      }
      catch (InterruptedException ignored) {}
      }
    activeWriters = true;
  }

  @Override public synchronized void releaseReadAccess(String actorName)
  {
    treasureRoom.releaseReadAccess(actorName);
    activeReaders--;
    if(activeReaders == 0)
    {
      notifyAll();
    }
  }

  @Override public synchronized void releaseWriteAccess(String actorName)
  {
    treasureRoom.releaseWriteAccess(actorName);
    activeWriters = false;
    notifyAll();
  }

  @Override public Valuable retrieveValuable()
  {
    return treasureRoom.retrieveValuable();
  }

  @Override public void addValuable(Valuable v)
  {
    treasureRoom.addValuable(v);
  }

  @Override public List<Valuable> lookAtAllGems()
  {
    return treasureRoom.lookAtAllGems();
  }
}
