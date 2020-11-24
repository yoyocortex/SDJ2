package Kingdom.GemMining;

import Kingdom.Catalogue;
import Kingdom.Collection.GemDeposit;
import Kingdom.TreasureRoom.TreasureRoomDoor;
import Kingdom.TreasureRoom.TreasureRoomGuardsman;
import Kingdom.Valuable.Valuable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GemTransporter implements Runnable
{
  GemDeposit gemDeposit;
  TreasureRoomDoor treasureRoomDoor;

  public GemTransporter(GemDeposit gemDeposit,
      TreasureRoomDoor treasureRoomDoor)
  {
    this.gemDeposit = gemDeposit;
    this.treasureRoomDoor = treasureRoomDoor;
  }

  @Override public void run()
  {
    List<Valuable> valuableListToTransport = new ArrayList<>();
    Random random = new Random();
    int worth = 0, randomNo = 0;
    while (true)
    {
      if (randomNo == 0)
        randomNo = random.nextInt(151) + 50;

      if (gemDeposit.getSize() > 0)
      {
        Valuable takeFromGemDeposit = gemDeposit.takeFromGemDeposit(gemDeposit.getSize() - 1);
        worth += takeFromGemDeposit.getValue();
        System.out.println("Worth - " + worth + "/" + randomNo);
        if (worth >= randomNo)
        {
          Catalogue.getCatalogue().addToQueue("Leaving the Gem Deposit with a full worth! - " + worth);
          System.out.println("Leaving the Gem Deposit with a full worth! - " + worth);

          for (Valuable valuable : valuableListToTransport)
          {
            treasureRoomDoor.acquireWriteAccess("Gem Transporter");
            treasureRoomDoor.addValuable(valuable);
            treasureRoomDoor.releaseWriteAccess("Gem Transporter");
          }

          valuableListToTransport.clear();
          worth = 0;
          randomNo = 0;

          try
          {
            Thread.sleep(15000);
          }
          catch (InterruptedException e)
          {
            e.printStackTrace();
          }
        }
        else
          valuableListToTransport.add(takeFromGemDeposit);
      }
    }
  }
}
