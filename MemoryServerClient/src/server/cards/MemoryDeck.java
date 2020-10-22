package server.cards;

import java.util.Random;

public class MemoryDeck implements Deck
{
  private static String[] deck = {"1","2","3","4","5","6","6","5","4","3","2","1"};
  private String[] shuffledDeck = deck;

  public MemoryDeck() {
    shuffleDeck(shuffledDeck);
  }

  @Override public String[] getDeck()
  {
    return deck;
  }

  @Override public String[] getShuffledDeck()
  {
    return shuffledDeck;
  }

  @Override public void shuffleDeck()
  {
    shuffleDeck(shuffledDeck);
  }

  static void shuffleDeck(String[] deck)
  {
    Random random = new Random();
    for (int y = deck.length - 1; y > 0; y--)
    {
      int index = random.nextInt(y + 1);
      String a = deck[index];
      deck[index] = deck[y];
      deck[y] = a;
    }
  }
}
