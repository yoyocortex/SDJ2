package server.model;

import sharedClasses.transferObject.User;

import java.util.List;

public interface GameModel
{
  void shuffleDeck();

  String validateUser(User user);
  String registerUser(User user);
  void removeLoggedInUser(User clientUser);
  List<User> getAllOnlineUsers();

  List<String> getShuffeldDeck();

  void plusFirstPlayerScore();
  void plusSecondPlayerScore();
  int getFirstPlayerScore();
  int getSecondPlayerScore();

  List<String> getBothPlayers();
  void setBothPlayers(String player);
  List<String> getFirstPlayerOpenedCards();
  void setFirstPlayerOpenedCards(String player);
  List<String> getSecondPlayerOpenedCards();
  void setSecondPlayerOpenedCards(String player);
  List<String> getFirstPlayerPairedCards();
  void setFirstPlayerPairedCards(String card);
  List<String> getSecondPlayerPairedCards();
  void setSecondPlayerPairedCards(String card);
  List<String> getAllPairedCards();
  void setAllPairedCards(String card);

  void resetAllLists();
}
