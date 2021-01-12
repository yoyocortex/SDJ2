package Kingdom;

import Kingdom.Collection.BlockingQueue;
import Kingdom.Collection.GemDeposit;
import Kingdom.GemMining.GemMineWorker;
import Kingdom.GemMining.GemTransporter;
import Kingdom.King;
import Kingdom.TreasureRoom.Accountant;
import Kingdom.TreasureRoom.TreasureRoomDoor;
import Kingdom.TreasureRoom.TreasureRoomGuardsman;

public class Main
{
  public static void main(String[] args)
  {
    GemDeposit gemDeposit = new BlockingQueue(100);
    TreasureRoomDoor treasureRoomDoor = new TreasureRoomGuardsman();
    GemMineWorker gemMineWorker1 = new GemMineWorker(gemDeposit);
    GemMineWorker gemMineWorker2 = new GemMineWorker(gemDeposit);
    GemMineWorker gemMineWorker3 = new GemMineWorker(gemDeposit);
    GemMineWorker gemMineWorker4 = new GemMineWorker(gemDeposit);

    GemTransporter gemTransporter1 = new GemTransporter(gemDeposit, treasureRoomDoor);
    Accountant accountant = new Accountant(treasureRoomDoor);

    Kingdom.King king = new King(treasureRoomDoor);

    Thread t1 = new Thread(gemMineWorker1);
    Thread t2 = new Thread(gemMineWorker2);
    Thread t3 = new Thread(gemMineWorker3);
    Thread t4 = new Thread(gemMineWorker4);
    Thread t5 = new Thread(gemTransporter1);
    Thread t6 = new Thread(accountant);
    Thread t7 = new Thread(king);

    t1.start();
    t2.start();
    t3.start();
    t4.start();
    t5.start();
    t6.start();
    t7.start();
  }
}
