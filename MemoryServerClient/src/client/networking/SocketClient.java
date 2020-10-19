package client.networking;

import sharedClasses.transferObject.EventType;
import sharedClasses.transferObject.Request;
import sharedClasses.transferObject.User;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class SocketClient implements Client
{
  private PropertyChangeSupport support;
  private Socket socket;
  private ObjectInputStream inFromServer;
  private ObjectOutputStream outToServer;

  public SocketClient()
  {
    support = new PropertyChangeSupport(this);
    start();
  }

  public void start()
  {
    try
    {
      socket = new Socket("localhost", 2910);
      Thread thread = new Thread(this::listenToServer);
      thread.setDaemon(true);
      thread.start();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
  }

  private void listenToServer()
  {
    try
    {
      inFromServer = new ObjectInputStream(socket.getInputStream());
      outToServer = new ObjectOutputStream(socket.getOutputStream());
      //inFromServer.reset();
      //outToServer.reset();

      while (true)
      {
        Request request = (Request) inFromServer.readObject();
        support.firePropertyChange(request.type.toString(), null, request.arg);

        /*if(request.type.toString().equals(EventType.DUEL_RESULT.toString()))
        {
          User arg = (User) request.arg;
          System.out.println("SocketClient> " + arg);
        }*/

        /*if(request.type.toString().equals(EventType.USERSLIST_RESULT.toString()))
        {
          List<User> arg = (List<User>) request.arg;
          System.out.println("SocketClient> " + arg);
        }*/

        /*if (request.type == EventType.LOGIN_REQUEST)
        {
          support.firePropertyChange(EventType.LOGIN_RESULT.toString(), null, request.arg);
        }*/
      }
    }
    catch (IOException | ClassNotFoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void login(User user)
  {
    Request request = new Request(EventType.LOGIN_REQUEST, user);
    sendToServer(request, EventType.LOGIN_RESULT);
  }

  @Override public void registerUser(User userToCreate)
  {
    Request request = new Request(EventType.REGISTER_REQUEST, userToCreate);
    sendToServer(request, EventType.REGISTER_RESULT);
  }

  @Override public void requestOnlinePlayers()
  {
    Request request = new Request(EventType.USERSLIST_REQUEST, null);
    sendToServer(request, EventType.USERSLIST_REQUEST);
  }

  @Override public void requestDuel(String selectedItem)
  {
    //System.out.println("SocketClient, requestDuel");
    Request request = new Request(EventType.DUEL_REQUEST, selectedItem);
    sendToServer(request, EventType.DUEL_REQUEST);
  }

  @Override public void openGameView(String enemy, String host)
  {
    List<String> twoInOne = new ArrayList<>();
    twoInOne.add(enemy); twoInOne.add(host);
    Request request = new Request(EventType.OPEN_GAME_VIEW_REQUEST, twoInOne);
    sendToServer(request, EventType.OPEN_GAME_VIEW_REQUEST);
  }

  @Override public void getShuffledDeck(User user)
  {
    Request request = new Request(EventType.SHUFFED_DECK_REQUEST, user);
    sendToServer(request, EventType.SHUFFED_DECK_REQUEST);
  }

  @Override public void getFirstTurn()
  {
    Request request = new Request(EventType.GET_FIRST_TURN_REQUEST, null);
    sendToServer(request, EventType.GET_FIRST_TURN_REQUEST);
  }

  @Override public void openedCard(User thisUser, String card)
  {
    Request request = new Request(EventType.SET_OPENED_CARD_TWO_ARG, thisUser, card);
    sendToServer(request, EventType.SET_OPENED_CARD_TWO_ARG);
  }

  private void sendToServer(Request request, EventType registerResult)
  {
    try
    {
      outToServer.writeObject(request);
    }
    catch (IOException e)
    {
      support.firePropertyChange(registerResult.toString(), null, "Connection lost, restart program!");
    }
  }

  @Override public void addListener(String name,
      PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void removeListener(String name,
      PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }
}
