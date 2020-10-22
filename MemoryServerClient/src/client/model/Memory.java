package client.model;

import sharedClasses.transferObject.User;
import sharedClasses.util.Subject;

public interface Memory extends Subject{
  void register(String username, String password, String repeatPassword);
  void login(String s, String s1);
  void getOnlinePlayers();

  void requestDuel(String selectedItem);
  void openGameView(String enemy, String host);
  void getShuffledDeck(User user);
  void getFirstTurn();
  void openedCard(User thisUser, String card);

  void reset();
}
