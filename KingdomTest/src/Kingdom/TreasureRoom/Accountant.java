package Kingdom.TreasureRoom;

import Kingdom.TreasureRoom.TreasureRoomDoor;

public class Accountant implements Runnable
{
  private TreasureRoomDoor treasureRoomDoor;

  public Accountant(TreasureRoomDoor treasureRoomDoor)
  {
    this.treasureRoomDoor = treasureRoomDoor;
  }

  @Override public void run()
  {
    while(true)
    {
      try
      {
        Thread.sleep(30000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }

      treasureRoomDoor.acquireReadAccess("Accountant");
      treasureRoomDoor.lookAtAllGems();
      treasureRoomDoor.releaseReadAccess("Accountant");
    }
  }
}
