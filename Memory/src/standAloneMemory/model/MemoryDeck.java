package standAloneMemory.model;

import java.util.Random;

public class MemoryDeck
{
  private static String[] deck = {"1","2","3","4","5","6","6","5","4","3","2","1"};
  private String[] shuffledDeck = deck;
  private Memory memoryModel;

  public MemoryDeck(Memory memoryModel) {
    this.memoryModel = memoryModel;
    shuffleDeck(shuffledDeck);
  }

  public String[] getDeck()
  {
    return deck;
  }

  public String[] getShuffledDeck() {
    /*for (int i = 0; i < shuffledDeck.length; i++)
      System.out.print(shuffledDeck[i]);
    */
    memoryModel.setShuffledDeck(shuffledDeck);
    return shuffledDeck;
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
