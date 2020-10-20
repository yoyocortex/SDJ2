package server.networking;

import server.model.GameModel;
import sharedClasses.transferObject.EventType;
import sharedClasses.transferObject.Request;
import sharedClasses.transferObject.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ServerSocketHandler implements Runnable
{
  private GameModel gameModel;
  private Socket socket;
  private ObjectOutputStream outToClient;
  private ObjectInputStream inFromClient;
  private ConnectionPool connectionPool;
  private User clientUser;

  public ServerSocketHandler(GameModel gameModel, Socket socket,
      ConnectionPool connectionPool) throws IOException
  {
    this.gameModel = gameModel;
    this.socket = socket;
    this.connectionPool = connectionPool;
    connectionPool.addConnection(this);

    outToClient = new ObjectOutputStream(socket.getOutputStream());
    inFromClient = new ObjectInputStream(socket.getInputStream());
    System.out.println(connectionPool.getConns());
  }

  @Override public void run()
  {
    try
    {
      while (true)
      {
        Request request = (Request) inFromClient.readObject();
        //System.out.println(request);
        if (request.type == EventType.LOGIN_REQUEST)
        {
          User user = (User) request.arg;
          String result = gameModel.validateUser(user);

          if (result.equals("OK"))
            clientUser = user;

          Request response = new Request(EventType.LOGIN_RESULT, result);
          outToClient.writeObject(response);
          //System.out.println("This is log in result from ssh> " + result);
        }
        else if (request.type == EventType.REGISTER_REQUEST)
        {
          User user = (User) request.arg;
          String registerResult = gameModel.registerUser(user);
          Request response = new Request(EventType.REGISTER_RESULT,
              registerResult);
          outToClient.writeObject(response);
        }
        else if (request.type == EventType.USERSLIST_REQUEST)
        {
          List<User> onlineUsers = gameModel.getAllOnlineUsers();
          Request response = new Request(EventType.USERSLIST_RESULT,
              onlineUsers);
          connectionPool.broadcast(response);
          //outToClient.reset();
          //outToClient.writeObject(response);
          //System.out.println(onlineUsers);
        }
        else if (request.type == EventType.DUEL_REQUEST)
        {
          //System.out.println("it came to here at least " + request.arg);
          List<User> onlineUsers = gameModel.getAllOnlineUsers();
          User enemy = null;
          for (User u : onlineUsers)
          {
            if (u.getUsername().equals(request.arg.toString()))
            {
              enemy = u;
              //System.out.println("Enemy user; " + enemy.getUsername());
            }
          }
          //System.out.println("My name is; " + clientUser.getUsername());
          List<ServerSocketHandler> conns = connectionPool.getConns();
          for (ServerSocketHandler ssh : conns)
          {
            //System.out.println(ssh.clientUser.getUsername() + " " + ssh);
            if (ssh.getClientUser().getUsername().equals(enemy.getUsername()))
            {
              ssh.requestToOpenEnemyPopup(clientUser);
              //System.out.println("Im sending from server request for duel!");
            }
          }
        }
        else if (request.type == EventType.OPEN_GAME_VIEW_REQUEST)
        {
          List<String> twoInOne = (List<String>) request.arg;
          //System.out.println("List of enemy and host; " + twoInOne);
          List<User> onlineUsers = gameModel.getAllOnlineUsers();
          int count = 0;
          User enemy = null;
          User host = null;

          for (User u : onlineUsers)
          {
            if (u.getUsername().equals(twoInOne.get(count)))
            {
              enemy = u;
              gameModel.setBothPlayers(enemy.getUsername());
              //System.out.println("Enemy> " + enemy.getUsername());
              //bothPlayers.set(0,enemy.getUsername());
            }
          }

          for (User u : onlineUsers)
          {
            if (("You are logged in with; " + u.getUsername())
                .equals(twoInOne.get(count + 1)))
            {
              host = u;
              gameModel.setBothPlayers(host.getUsername());
              //System.out.println("Host> " + host.getUsername());
              //bothPlayers.set(1,host.getUsername());
            }
          }

          List<ServerSocketHandler> conns = connectionPool.getConns();
          for (ServerSocketHandler ssh : conns)
          {
            if (ssh.getClientUser().getUsername().equals(enemy.getUsername()))
            {
              ssh.requestToOpenGameForClient(enemy);
            }
          }

          for (ServerSocketHandler ssh : conns)
          {
            if (ssh.getClientUser().getUsername().equals(host.getUsername()))
            {
              ssh.requestToOpenGameForClient(host);
            }
          }
        }
        else if (request.type == EventType.SHUFFED_DECK_REQUEST)
        {
          User user = (User) request.arg;
          //System.out.println(user.getUsername());
          List<String> shuffeldDeck = gameModel.getShuffeldDeck();
          List<ServerSocketHandler> conns = connectionPool.getConns();
          for (ServerSocketHandler ssh : conns)
          {
            if (ssh.getClientUser().getUsername().equals(user.getUsername()))
            {
              ssh.sendSuffedDeck(shuffeldDeck);
              System.out.println("Shuffled deck> " + shuffeldDeck);
            }
          }
        }
        else if (request.type == EventType.GET_FIRST_TURN_REQUEST)
        {
          List<String> bothPlayers = gameModel.getBothPlayers();
          System.out.println(gameModel.getBothPlayers());

          String selectedUser = bothPlayers.get(0);

          sendSelectedFirstUser(selectedUser);

          List<ServerSocketHandler> conns = connectionPool.getConns();
          for (ServerSocketHandler ssh : conns)
          {
            ssh.sendScoreNumber("first", gameModel.getFirstPlayerScore());
            ssh.sendScoreNumber("second", gameModel.getSecondPlayerScore());
          }
        }
        else if (request.type == EventType.SET_OPENED_CARD_TWO_ARG)
        {
          User user = (User) request.arg;
          String card = (String) request.secondsArg;
          System.out.println(card);

          if (user.getUsername().equals(gameModel.getBothPlayers().get(0)))
          {
            gameModel.setFirstPlayerOpenedCards(card);
            if (gameModel.getFirstPlayerOpenedCards().size() % 2 == 0)
            {
              if (gameModel.getFirstPlayerOpenedCards().get(gameModel.getFirstPlayerOpenedCards().size() - 1).equals(
                      gameModel.getFirstPlayerOpenedCards().get(gameModel.getFirstPlayerOpenedCards().size() - 2)))
              {
                gameModel.setFirstPlayerPairedCards(
                    gameModel.getFirstPlayerOpenedCards()
                        .get(gameModel.getFirstPlayerOpenedCards().size() - 1));
                gameModel.setFirstPlayerPairedCards(
                    gameModel.getFirstPlayerOpenedCards()
                        .get(gameModel.getFirstPlayerOpenedCards().size() - 2));

                gameModel.plusFirstPlayerScore();
                List<ServerSocketHandler> conns = connectionPool.getConns();
                for (ServerSocketHandler ssh : conns)
                {
                  ssh.sendScoreNumber("first", gameModel.getFirstPlayerScore());
                  ssh.sendScoreNumber("second", gameModel.getSecondPlayerScore());

                  if(!ssh.getClientUser().getUsername().equals(gameModel.getBothPlayers().get(0)))
                    ssh.sendPairNotification(gameModel.getBothPlayers().get(0) + " has paired> " +
                        gameModel.getFirstPlayerPairedCards().get(gameModel.getFirstPlayerPairedCards().size() - 1) + "-" +
                        gameModel.getFirstPlayerPairedCards().get(gameModel.getFirstPlayerPairedCards().size() - 2));
                }

                gameModel.setAllPairedCards(
                    gameModel.getFirstPlayerOpenedCards()
                        .get(gameModel.getFirstPlayerOpenedCards().size() - 1));
                gameModel.setAllPairedCards(
                    gameModel.getFirstPlayerOpenedCards()
                        .get(gameModel.getFirstPlayerOpenedCards().size() - 2));
              }

              List<ServerSocketHandler> conns = connectionPool.getConns();
              for (ServerSocketHandler ssh : conns) {
                ssh.keepOpen(gameModel.getAllPairedCards());
              }

              if (gameModel.getFirstPlayerPairedCards().size() + gameModel.getSecondPlayerPairedCards().size() == 12)
              {
                for (ServerSocketHandler ssh : conns) {
                  if(gameModel.getFirstPlayerPairedCards().size() < gameModel.getSecondPlayerPairedCards().size())
                  ssh.sendPairNotification(gameModel.getBothPlayers().get(0) + " has won the game!");
                  else if(gameModel.getFirstPlayerPairedCards().size() > gameModel.getSecondPlayerPairedCards().size())
                    ssh.sendPairNotification(gameModel.getBothPlayers().get(1) + " has won the game!");
                  else
                    ssh.sendPairNotification("Game has ended tie");
                }
              }

              for (ServerSocketHandler ssh : conns)
              {
                if (ssh.getClientUser().getUsername()
                    .equals(gameModel.getBothPlayers().get(0)))
                {
                  ssh.sendSelectedFirstUser(gameModel.getBothPlayers().get(1));
                }
                else if (ssh.getClientUser().getUsername()
                    .equals(gameModel.getBothPlayers().get(1)))
                {
                  ssh.sendSelectedFirstUser(gameModel.getBothPlayers().get(1));
                }
              }
            }
          }
          else
          {
            gameModel.setSecondPlayerOpenedCards(card);
            if (gameModel.getSecondPlayerOpenedCards().size() % 2 == 0)
            {
              if (gameModel.getSecondPlayerOpenedCards()
                  .get(gameModel.getSecondPlayerOpenedCards().size() - 1)
                  .equals(gameModel.getSecondPlayerOpenedCards()
                      .get(gameModel.getSecondPlayerOpenedCards().size() - 2)))
              {

                gameModel.setSecondPlayerPairedCards(
                    gameModel.getSecondPlayerOpenedCards().get(
                        gameModel.getSecondPlayerOpenedCards().size() - 1));
                gameModel.setSecondPlayerPairedCards(
                    gameModel.getSecondPlayerOpenedCards().get(
                        gameModel.getSecondPlayerOpenedCards().size() - 2));

                gameModel.plusSecondPlayerScore();
                List<ServerSocketHandler> conns = connectionPool.getConns();
                for (ServerSocketHandler ssh : conns)
                {
                  ssh.sendScoreNumber("first", gameModel.getFirstPlayerScore());
                  ssh.sendScoreNumber("second", gameModel.getSecondPlayerScore());

                  if(!ssh.getClientUser().getUsername().equals(gameModel.getBothPlayers().get(1)))
                    ssh.sendPairNotification(gameModel.getBothPlayers().get(1) + " has paired> " +
                        gameModel.getSecondPlayerPairedCards().get(gameModel.getSecondPlayerPairedCards().size() - 1) + "-" +
                        gameModel.getSecondPlayerPairedCards().get(gameModel.getSecondPlayerPairedCards().size() - 2));
                }

                gameModel.setAllPairedCards(
                    gameModel.getSecondPlayerOpenedCards().get(
                        gameModel.getSecondPlayerOpenedCards().size() - 1));
                gameModel.setAllPairedCards(
                    gameModel.getSecondPlayerOpenedCards().get(
                        gameModel.getSecondPlayerOpenedCards().size() - 2));
              }

              List<ServerSocketHandler> conns = connectionPool.getConns();
              for (ServerSocketHandler ssh : conns) {
                ssh.keepOpen(gameModel.getAllPairedCards());
              }

              if (gameModel.getFirstPlayerPairedCards().size() + gameModel.getSecondPlayerPairedCards().size() == 12)
              {
                for (ServerSocketHandler ssh : conns) {
                  if(gameModel.getFirstPlayerPairedCards().size() < gameModel.getSecondPlayerPairedCards().size())
                    ssh.sendPairNotification(gameModel.getBothPlayers().get(0) + " has won the game!");
                  else if(gameModel.getFirstPlayerPairedCards().size() > gameModel.getSecondPlayerPairedCards().size())
                    ssh.sendPairNotification(gameModel.getBothPlayers().get(1) + " has won the game!");
                  else
                    ssh.sendPairNotification("Game has ended tie");
                }
              }

              for (ServerSocketHandler ssh : conns)
              {
                if (ssh.getClientUser().getUsername()
                    .equals(gameModel.getBothPlayers().get(0)))
                {
                  ssh.sendSelectedFirstUser(gameModel.getBothPlayers().get(0));
                }
                else if (ssh.getClientUser().getUsername()
                    .equals(gameModel.getBothPlayers().get(1)))
                {
                  ssh.sendSelectedFirstUser(gameModel.getBothPlayers().get(0));
                }
              }
            }
          }
          //System.out.println("First player paired cards> " + gameModel.getFirstPlayerPairedCards());
          //System.out.println("Second player paired cards> " + gameModel.getSecondPlayerPairedCards());
          //System.out.println("First player cards> " + gameModel.getFirstPlayerOpenedCards());
          //System.out.println("Second player cards> " + gameModel.getSecondPlayerOpenedCards());
        }
        else if(request.type == EventType.RESET)
        {
          gameModel.resetAllLists();
        }
      }
    }
    catch (SocketException e)
    {
      try
      {
        gameModel.removeLoggedInUser(clientUser);
        connectionPool.removeConnection(this);
        socket.close();
      }
      catch (IOException ioException)
      {
        ioException.printStackTrace();
      }
      System.out.println(e.getMessage());
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  private void sendPairNotification(String s)
  {
    Request request = new Request(EventType.SEND_PAIR_NOTIFICATION, s);
    try
    {
      outToClient.reset();
      outToClient.writeObject(request);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void sendScoreNumber(String player, int playerScore)
  {
    Request request = null;
    if(player.equals("first"))
    {
      request = new Request(EventType.FIRST_PLAYER_SCORE, playerScore);
    }
    else if(player.equals("second"))
    {
      request = new Request(EventType.SECOND_PLAYER_SCORE, playerScore);
    }
    try
    {
      outToClient.reset();
      outToClient.writeObject(request);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void keepOpen(List<String> allPairedCards)
  {
    Request request = new Request(EventType.KEEP_OPEN, allPairedCards);
    try
    {
      outToClient.reset();
      outToClient.writeObject(request);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void sendSelectedFirstUser(String selectedUser)
  {
    Request request = new Request(EventType.GET_FIRST_TURN_RESULT,
        selectedUser);
    try
    {
      outToClient.reset();
      outToClient.writeObject(request);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void sendSuffedDeck(List<String> shuffeldDeck)
  {
    Request request = new Request(EventType.SHUFFED_DECK_RESULT, shuffeldDeck);
    try
    {
      outToClient.reset();
      outToClient.writeObject(request);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void requestToOpenGameForClient(User user)
  {
    Request request = new Request(EventType.OPEN_GAME_VIEW_RESULT, user);
    try
    {
      outToClient.reset();
      outToClient.writeObject(request);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void sendUserList(Request obj)
  {
    try
    {
      outToClient.reset();
      outToClient.writeObject(obj);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public void requestToOpenEnemyPopup(User user)
  {
    Request request = new Request(EventType.DUEL_RESULT, user);
    try
    {
      outToClient.reset();
      outToClient.writeObject(request);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  public User getClientUser()
  {
    return clientUser;
  }
}
