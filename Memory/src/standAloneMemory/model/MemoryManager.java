package standAloneMemory.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class MemoryManager implements Memory
{

  private PropertyChangeSupport support = new PropertyChangeSupport(this);;
  private String[] memoryDeck;
  private List<String> openedCards;
  private List<String[]> pairedCards, notPairdCards;
  private MemoryDeck memoryDeckObj;

  public MemoryManager() {
    //MemoryRunnable memoryRunnable = new MemoryRunnable();
    memoryDeckObj = new MemoryDeck(this); //
    openedCards = new ArrayList<>();
    pairedCards = new ArrayList<>();
    notPairdCards = new ArrayList<>();
    //notPairdCards.add(new String[] {"0", "0"});
  }

  @Override public String openedCard(String id, String card)
  {
    //System.out.println("here");
    for (int i = 0; i < memoryDeck.length; i++)
    {
      if(card.equals(memoryDeck[i]))
      {
        openedCards.add(card);
        //System.out.println(openedCards);
        getIsItAPair(id);
        return card;
      }
    }
    return null;
  }

  @Override public boolean getIsItAPair(String id)
  {
    if(openedCards.size() % 2 == 0)
    {
      String lastOpenedCard = openedCards.get(openedCards.size()-1);
      String oneBeforeLastOpenedCard = openedCards.get(openedCards.size()-2);
      String[] pair = {lastOpenedCard, oneBeforeLastOpenedCard};
      if(lastOpenedCard.equals(oneBeforeLastOpenedCard)) {
        pairedCards.add(pair);
        support.firePropertyChange("Pair", pairedCards, pair);
        //System.out.println("ITS A PAIR");
        return true;
      }
      notPairdCards.add(pair); // pair = not pair actually
      support.firePropertyChange("CloseCards", null, notPairdCards);
    }
    return false;
  }

  @Override public String[] setShuffledDeck(String[] shuffledDeck)
  {
    memoryDeck = shuffledDeck;
    support.firePropertyChange("ShuffledDeck", null, memoryDeck);
    return memoryDeck;
  }

  @Override public String[] getShuffledDeck()
  {
    memoryDeck = memoryDeckObj.getShuffledDeck();
    support.firePropertyChange("ShuffledDeck", null, memoryDeck);
    return memoryDeck;
  }

  @Override public void shuffleDeckAgain()
  {
    /*openedCards.clear();
    notPairdCards.clear();
    notPairdCards.add(new String[] {"0", "0"});*/
    pairedCards.clear();
    memoryDeckObj = new MemoryDeck(this);
    memoryDeck = memoryDeckObj.getShuffledDeck();
  }

  @Override public void addListener(String name, PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void removeListener(String name, PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(name, listener);
  }
}
