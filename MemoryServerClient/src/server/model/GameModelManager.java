package server.model;

import server.cards.Deck;
import server.dataaccess.UserHome;
import sharedClasses.transferObject.User;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameModelManager implements GameModel
{
  private UserHome userHome;
  private Deck memoryDeck;
  private List<String> bothPlayers;
  private List<String> firstPlayerOpenedCards;
  private List<String> secondPlayerOpenedCards;
  private List<String> firstPlayerPairedCards;
  private List<String> secondPlayerPairedCards;
  private List<String> allPairedCards;
  private int firstPlayerScore = 0, secondPlayerScore = 0;

  public GameModelManager(UserHome userHome, Deck deck)
  {
    this.userHome = userHome;
    this.memoryDeck = deck;

    bothPlayers = new ArrayList<>();
    firstPlayerOpenedCards = new ArrayList<>();
    secondPlayerOpenedCards = new ArrayList<>();
    firstPlayerPairedCards = new ArrayList<>();
    secondPlayerPairedCards = new ArrayList<>();
    allPairedCards = new ArrayList<>();
  }

  @Override public List<String> getBothPlayers()
  {
    return bothPlayers;
  }

  @Override public void setBothPlayers(String player)
  {
    bothPlayers.add(player);
  }

  @Override public List<String> getFirstPlayerOpenedCards()
  {
    return firstPlayerOpenedCards;
  }

  @Override public void setFirstPlayerOpenedCards(String card)
  {
    firstPlayerOpenedCards.add(card);
  }

  @Override public List<String> getSecondPlayerOpenedCards()
  {
    return secondPlayerOpenedCards;
  }

  @Override public void setSecondPlayerOpenedCards(String card)
  {
    secondPlayerOpenedCards.add(card);
  }

  @Override public List<String> getFirstPlayerPairedCards()
  {
    return firstPlayerPairedCards;
  }

  @Override public void setFirstPlayerPairedCards(String card)
  {
    firstPlayerPairedCards.add(card);
  }

  @Override public List<String> getSecondPlayerPairedCards()
  {
    return secondPlayerPairedCards;
  }

  @Override public void setSecondPlayerPairedCards(String card)
  {
    secondPlayerPairedCards.add(card);
  }

  @Override public List<String> getAllPairedCards()
  {
    return allPairedCards;
  }

  @Override public void setAllPairedCards(String card)
  {
    allPairedCards.add(card);
  }

  @Override public void resetAllLists()
  {
    firstPlayerOpenedCards = new ArrayList<>();
    secondPlayerOpenedCards = new ArrayList<>();
    firstPlayerPairedCards = new ArrayList<>();
    secondPlayerPairedCards = new ArrayList<>();
    allPairedCards = new ArrayList<>();
    firstPlayerScore = 0; secondPlayerScore = 0;
  }

  @Override public void shuffleDeck()
  {
    memoryDeck.shuffleDeck();
  }

  @Override public void removeLoggedInUser(User clientUser)
  {
    userHome.removeOnlineUser(clientUser);
  }

  @Override public String validateUser(User user)
  {
    return userHome.validateUser(user);
  }

  @Override public String registerUser(User user)
  {
    User foundUser = userHome.findUser(user.getUsername());

    if(foundUser != null)
    {
      return "Username already exists";
    }
    if(user.getUsername().length() <= 3)
    {
      return "Username must be longer then 3 characters";
    }
    if(user.getPassword().length() <= 5)
    {
      return "Password must be longer then 5 characters";
    }

    String result = userHome.registerUser(user);

    return result;
  }

  @Override public List<User> getAllOnlineUsers()
  {
    return userHome.getAllOnlineUsers();
  }

  @Override public List<String> getShuffeldDeck()
  {
    return Arrays.asList(memoryDeck.getShuffledDeck());
  }

  @Override public void plusFirstPlayerScore()
  {
    firstPlayerScore++;
  }

  @Override public void plusSecondPlayerScore()
  {
    secondPlayerScore++;
  }

  @Override public int getFirstPlayerScore()
  {
    return firstPlayerScore;
  }

  @Override public int getSecondPlayerScore()
  {
    return secondPlayerScore;
  }

}
