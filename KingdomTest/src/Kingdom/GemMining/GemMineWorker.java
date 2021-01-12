package Kingdom.GemMining;

import Kingdom.Catalogue;
import Kingdom.Collection.GemDeposit;
import Kingdom.GemMining.GemMine;

import java.util.Random;

public class GemMineWorker implements Runnable
{
  GemDeposit gemDeposit;

  public GemMineWorker(GemDeposit gemDeposit)
  {
    this.gemDeposit = gemDeposit;
  }

  @Override public void run()
  {
    Random random = new Random();
    while(true)
    {
      //System.out.println("");
      switch (random.nextInt(5)) {
        case 0:
            gemDeposit.addToGemDeposit(Kingdom.GemMining.GemMine.getValuable("Diamond"));
            try
            {
              Thread.sleep(2000);
            }
            catch (InterruptedException e)
            {
              e.printStackTrace();
            }
            Catalogue.getCatalogue().addToQueue("Adding Diamond to Gem Deposit");
            System.out.println("Adding Diamond to Gem Deposit");
            break;
          case 1:
            gemDeposit.addToGemDeposit(Kingdom.GemMining.GemMine.getValuable("Gold Nugget"));
            try
            {
              Thread.sleep(1500);
            }
            catch (InterruptedException e)
            {
              e.printStackTrace();
            }
            Catalogue.getCatalogue().addToQueue("Adding Gold Nugget to Gem Deposit");
            System.out.println("Adding Gold Nugget to Gem Deposit");
            break;
          case 2:
            gemDeposit.addToGemDeposit(Kingdom.GemMining.GemMine.getValuable("Jewel"));
            try
            {
              Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
              e.printStackTrace();
            }
            Catalogue.getCatalogue().addToQueue("Adding Jewel to Gem Deposit");
            System.out.println("Adding Jewel to Gem Deposit");
            break;
          case 3:
            gemDeposit.addToGemDeposit(Kingdom.GemMining.GemMine.getValuable("Ruby"));
            try
            {
              Thread.sleep(500);
            }
            catch (InterruptedException e)
            {
              e.printStackTrace();
            }

            Catalogue.getCatalogue().addToQueue("Adding Ruby to Gem Deposit");
            System.out.println("Adding Ruby to Gem Deposit");
            break;
          case 4:
            gemDeposit.addToGemDeposit(GemMine.getValuable("Wooden Coin"));
            try
            {
              Thread.sleep(100);
            }
            catch (InterruptedException e)
            {
              e.printStackTrace();
            }
            Catalogue.getCatalogue().addToQueue("Adding Wooden Coin to Gem Deposit");
            System.out.println("Adding Wooden Coin to Gem Deposit");
            break;
      }
      try
      {
        Thread.sleep(7000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }
}
