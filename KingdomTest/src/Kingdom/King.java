package Kingdom;

import Kingdom.Catalogue;
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
    int randomNo = 0;
    int worth = 0;
    List<Valuable> kingTook = new ArrayList<>();
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

      treasureRoomDoor.acquireReadAccess("King");
      List<Valuable> valuableList = treasureRoomDoor.lookAtAllGems();
      treasureRoomDoor.releaseReadAccess("King");

      treasureRoomDoor.acquireWriteAccess("King");
      for(int i = 0; i < valuableList.size(); i++)
      {
         kingTook.add(treasureRoomDoor.retrieveValuable());
         worth += kingTook.get(i).getValue();

         if(worth >= randomNo)
         {
           Catalogue.getCatalogue().addToQueue("Party is starting tonight!!!");
           System.out.println("Party is starting tonight!!!");

           break;
         }
      }
      treasureRoomDoor.releaseWriteAccess("King");

      if(worth < randomNo)
      {
        Catalogue.getCatalogue().addToQueue(
            "Not enough gems to hold a party! :(" + worth + "/" + randomNo);
        System.out.println(
            "Not enough gems to hold a party! :( " + worth + "/" + randomNo);

        treasureRoomDoor.acquireWriteAccess("King");
        for (int i = 0; i < kingTook.size(); i++)
        {
          treasureRoomDoor.addValuable(kingTook.get(i));
        }
        treasureRoomDoor.releaseWriteAccess("King");

      }

      worth = 0;
      kingTook.clear();
    }
  }
}
