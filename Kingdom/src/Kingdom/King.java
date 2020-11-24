package Kingdom;

import Kingdom.TreasureRoom.TreasureRoomDoor;
import Kingdom.Valuable.Valuable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class King implements Runnable
{
  private TreasureRoomDoor treasureRoomDoor;

  public King(TreasureRoomDoor treasureRoomDoor)
  {
    this.treasureRoomDoor = treasureRoomDoor;
  }

  @Override public void run()
  {
    Random random = new Random();
    List<Valuable> valuablesTaken = new ArrayList<>();
    int randomNo = 0;
    int worth = 0;
    int size = 1;
    while(true)
    {
      try
      {
        Thread.sleep(50000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }

      if (randomNo == 0)
        randomNo = random.nextInt(151) + 50;

      treasureRoomDoor.acquireWriteAccess("King");
      while(worth <= randomNo)
      {
        valuablesTaken.add(treasureRoomDoor.retrieveValuable());
        System.out.println("asdasdasdasda" + valuablesTaken.size());

        if(valuablesTaken.get(0) != null)
        {
          worth += valuablesTaken.get(valuablesTaken.size() - 1).getValue();
          System.out.println("Getting gems");
        }
      }
      treasureRoomDoor.releaseWriteAccess("King");
      System.out.println("Party is ON!");
      worth = 0;
      valuablesTaken.clear();
    }
  }
}
