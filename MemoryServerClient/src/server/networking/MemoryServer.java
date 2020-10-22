package server.networking;

import server.model.GameModel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MemoryServer
{
  private GameModel gameModel;
  private ConnectionPool connectionPool;

  public MemoryServer(GameModel gameModel)
  {
    this.gameModel = gameModel;
    connectionPool = new ConnectionPool();
  }

  public void startServer() throws IOException
  {
    ServerSocket serverSocket = new ServerSocket(2910);
    System.out.println("Server started...");
    while(true)
    {
      try
      {
        System.out.println("Waiting for client...");
        Socket socket = serverSocket.accept();
        ServerSocketHandler ssh = new ServerSocketHandler(gameModel, socket, connectionPool);
        new Thread(ssh).start();
        System.out.println("Client connected.");
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
    }
  }
}
