package standAloneMemory.views.game;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import standAloneMemory.model.Memory;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

public class GameViewModel
{
  private Memory memoryManager;
  private StringProperty card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12;
  private boolean cardB1 = false, cardB2 = false, cardB3 = false, cardB4 = false, cardB5 = false, cardB6 = false, cardB7 = false
      , cardB8 = false, cardB9 = false, cardB10 = false, cardB11 = false, cardB12 = false;
  private StringProperty pair;
  private boolean closeCards = false;
  public List<String[]> notPairdCards;
  public List<String[]> pairedCards;

  public GameViewModel(Memory memoryManager)
  {
    this.memoryManager = memoryManager;
    card1 = new SimpleStringProperty(); card2 = new SimpleStringProperty();
    card3 = new SimpleStringProperty(); card4 = new SimpleStringProperty();
    card5 = new SimpleStringProperty(); card6 = new SimpleStringProperty();
    card7 = new SimpleStringProperty(); card8 = new SimpleStringProperty();
    card9 = new SimpleStringProperty(); card10 = new SimpleStringProperty();
    card11 = new SimpleStringProperty(); card12 = new SimpleStringProperty();
    pair = new SimpleStringProperty(); notPairdCards = new ArrayList<>();
    notPairdCards.add(new String[] {"0", "0"});
    this.memoryManager.addListener("ShuffledDeck", event -> assignCards(event));
    this.memoryManager.getShuffledDeck();
    this.memoryManager.addListener("Pair", event -> itsAPair(event));
    this.memoryManager.addListener("CloseCards", event -> closeCards(event));
    //assignCards();
  }

  private void closeCards(PropertyChangeEvent event)
  {
    notPairdCards = (List<String[]>) event.getNewValue();
    //System.out.println(Arrays.toString(notPairdCards.get(notPairdCards.size()-1)));
  }

  private void itsAPair(PropertyChangeEvent event)
  {
    String[] pairCards = (String[]) event.getNewValue();
    pair.setValue("Paired; " + pairCards[0] + ", " + pairCards[1]);
    pairedCards = (List<String[]>) event.getOldValue();
    if(pairedCards.size() == 6) {
      pair.setValue("You have paired all cards! Victory!");
    }
  }

  private void assignCards(PropertyChangeEvent event)
  {
    String[] shuffledMemoryDeck = (String[]) event.getNewValue();
    //System.out.println(shuffledMemoryDeck);
    card1.setValue(shuffledMemoryDeck[0]); card2.setValue(shuffledMemoryDeck[1]);
    card3.setValue(shuffledMemoryDeck[2]); card4.setValue(shuffledMemoryDeck[3]);
    card5.setValue(shuffledMemoryDeck[4]); card6.setValue(shuffledMemoryDeck[5]);
    card7.setValue(shuffledMemoryDeck[6]); card8.setValue(shuffledMemoryDeck[7]);
    card9.setValue(shuffledMemoryDeck[8]); card10.setValue(shuffledMemoryDeck[9]);
    card11.setValue(shuffledMemoryDeck[10]); card12.setValue(shuffledMemoryDeck[11]);
  }

  public String getPair()
  {
    return pair.get();
  }

  public StringProperty pairProperty()
  {
    return pair;
  }

  public boolean isCardB1()
  {
    return cardB1;
  }

  public void setCardB1(boolean cardB1)
  {
    if(cardB1) {
      memoryManager.openedCard("", card1.get());
    }
    this.cardB1 = cardB1;
  }

  public boolean isCardB2()
  {
    return cardB2;
  }

  public void setCardB2(boolean cardB2)
  {
    if(cardB2) {
    memoryManager.openedCard("", card2.get());
  }
    this.cardB2 = cardB2;
  }

  public boolean isCardB3()
  {
    return cardB3;
  }

  public void setCardB3(boolean cardB3)
  {
    if(cardB3) {
      memoryManager.openedCard("", card3.get());
    }
    this.cardB3 = cardB3;
  }

  public boolean isCardB4()
  {
    return cardB4;
  }

  public void setCardB4(boolean cardB4)
  {
    if(cardB4) {
      memoryManager.openedCard("", card4.get());
    }
    this.cardB4 = cardB4;
  }

  public boolean isCardB5()
  {
    return cardB5;
  }

  public void setCardB5(boolean cardB5)
  {
    if(cardB5) {
      memoryManager.openedCard("", card5.get());
    }
    this.cardB5 = cardB5;
  }

  public boolean isCardB6()
  {
    return cardB6;
  }

  public void setCardB6(boolean cardB6)
  {
    if(cardB6) {
      memoryManager.openedCard("", card6.get());
    }
    this.cardB6 = cardB6;
  }

  public boolean isCardB7()
  {
    return cardB7;
  }

  public void setCardB7(boolean cardB7)
  {
    if(cardB7) {
      memoryManager.openedCard("", card7.get());
    }
    this.cardB7 = cardB7;
  }

  public boolean isCardB8()
  {
    return cardB8;
  }

  public void setCardB8(boolean cardB8)
  {
    if(cardB8) {
      memoryManager.openedCard("", card8.get());
    }
    this.cardB8 = cardB8;
  }

  public boolean isCardB9()
  {
    return cardB9;
  }

  public void setCardB9(boolean cardB9)
  {
    if(cardB9) {
      memoryManager.openedCard("", card9.get());
    }
    this.cardB9 = cardB9;
  }

  public boolean isCardB10()
  {
    return cardB10;
  }

  public void setCardB10(boolean cardB10)
  {
    if(cardB10) {
      memoryManager.openedCard("", card10.get());
    }
    this.cardB10 = cardB10;
  }

  public boolean isCardB11()
  {
    return cardB11;
  }

  public void setCardB11(boolean cardB11)
  {
    if(cardB11) {
      memoryManager.openedCard("", card11.get());
    }
    this.cardB11 = cardB11;
  }

  public boolean isCardB12()
  {
    return cardB12;
  }

  public void setCardB12(boolean cardB12)
  {
    if(cardB12) {
      memoryManager.openedCard("", card12.get());
    }
    this.cardB12 = cardB12;
  }

  public void shuffleDeckAgain() {
    memoryManager.shuffleDeckAgain();
  }

  public String getCard1()
  {
    return card1.get();
  }

  public StringProperty card1Property()
  {
    return card1;
  }

  public String getCard2()
  {
    return card2.get();
  }

  public StringProperty card2Property()
  {
    return card2;
  }

  public String getCard3()
  {
    return card3.get();
  }

  public StringProperty card3Property()
  {
    return card3;
  }

  public String getCard4()
  {
    return card4.get();
  }

  public StringProperty card4Property()
  {
    return card4;
  }

  public String getCard5()
  {
    return card5.get();
  }

  public StringProperty card5Property()
  {
    return card5;
  }

  public String getCard6()
  {
    return card6.get();
  }

  public StringProperty card6Property()
  {
    return card6;
  }

  public String getCard7()
  {
    return card7.get();
  }

  public StringProperty card7Property()
  {
    return card7;
  }

  public String getCard8()
  {
    return card8.get();
  }

  public StringProperty card8Property()
  {
    return card8;
  }

  public String getCard9()
  {
    return card9.get();
  }

  public StringProperty card9Property()
  {
    return card9;
  }

  public String getCard10()
  {
    return card10.get();
  }

  public StringProperty card10Property()
  {
    return card10;
  }

  public String getCard11()
  {
    return card11.get();
  }

  public StringProperty card11Property()
  {
    return card11;
  }

  public String getCard12()
  {
    return card12.get();
  }

  public StringProperty card12Property()
  {
    return card12;
  }
}
