package server;

import server.cards.Deck;
import server.cards.MemoryDeck;
import server.dataaccess.InMemoryUsers;
import server.dataaccess.UserHome;
import server.model.GameModel;
import server.model.GameModelManager;
import server.networking.MemoryServer;

import java.io.IOException;

public class RunMemoryServer
{
  public static void main(String[] args)
  {
    UserHome userHome = new InMemoryUsers();
    Deck deck = new MemoryDeck();
    GameModel gameModel = new GameModelManager(userHome, deck);
    MemoryServer memoryServer = new MemoryServer(gameModel);
    try
    {
      memoryServer.startServer();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }
}
