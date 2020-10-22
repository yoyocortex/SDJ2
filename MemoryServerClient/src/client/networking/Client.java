package client.networking;

import sharedClasses.transferObject.User;
import sharedClasses.util.Subject;

public interface Client extends Subject
{
  void login(User user);
  void registerUser(User userToCreate);
  void requestOnlinePlayers();

  void requestDuel(String selectedItem);
  void openGameView(String enemy, String host);
  void getShuffledDeck(User user);
  void getFirstTurn();
  void openedCard(User thisUser, String card);

  void reset();
}
