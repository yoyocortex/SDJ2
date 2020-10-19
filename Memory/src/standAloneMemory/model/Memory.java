package standAloneMemory.model;

import standAloneMemory.util.Subject;

public interface Memory extends Subject {
  String openedCard(String id, String card);
  boolean getIsItAPair(String id);
  String[] setShuffledDeck(String[] shuffledDeck);
  String[] getShuffledDeck();
  void shuffleDeckAgain();
}
