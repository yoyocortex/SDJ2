package server.cards;

public interface Deck
{
  String[] getDeck();
  String[] getShuffledDeck();
  void shuffleDeck();
}
