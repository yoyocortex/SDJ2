package client.views.game;

import client.model.Memory;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import sharedClasses.transferObject.EventType;
import sharedClasses.transferObject.User;

import java.beans.PropertyChangeEvent;
import java.util.ArrayList;
import java.util.List;

public class GameViewModel
{
  private Memory model;
  private StringProperty card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12;
  private List<String> shuffledMemoryDeck;
  private SimpleStringProperty firstPlayerTurn;
  private List<String> allPairedCards;

  public GameViewModel(Memory model)
  {
    this.model = model;
    this.model.addListener(EventType.SHUFFED_DECK_RESULT.toString(), this::assignCards);
    this.model.addListener(EventType.GET_FIRST_TURN_RESULT.toString(), this::firstTurn);
    this.model.addListener(EventType.KEEP_OPEN.toString(), this::keepOpen);

    shuffledMemoryDeck = new ArrayList<>();
    allPairedCards = new ArrayList<>();
    //allPairedCards.add("0");
    //allPairedCards.add("0");
    card1 = new SimpleStringProperty(); card2 = new SimpleStringProperty();
    card3 = new SimpleStringProperty(); card4 = new SimpleStringProperty();
    card5 = new SimpleStringProperty(); card6 = new SimpleStringProperty();
    card7 = new SimpleStringProperty(); card8 = new SimpleStringProperty();
    card9 = new SimpleStringProperty(); card10 = new SimpleStringProperty();
    card11 = new SimpleStringProperty(); card12 = new SimpleStringProperty();
    firstPlayerTurn = new SimpleStringProperty("bullshit");
  }

  private void keepOpen(PropertyChangeEvent event)
  {
    allPairedCards = (List<String>) event.getNewValue();
    /*if(allPairedCards.isEmpty())
    {
      allPairedCards.add("0");
      allPairedCards.add("0");
    }*/
    System.out.println("AllPairedCards in GVM> " + allPairedCards);
  }

  private void firstTurn(PropertyChangeEvent event)
  {
    String firstUser = (String) event.getNewValue();
    //Platform.runLater(() -> firstPlayerTurn.set(firstUser));
    Platform.runLater(() -> firstPlayerTurn.set(firstUser));
    //System.out.println("First user should be> "  + firstPlayerTurn.get());
  }

  private void assignCards(PropertyChangeEvent event)
  {
    //System.out.println("Does it even come to here?");
    shuffledMemoryDeck = (List<String>) event.getNewValue();
    System.out.println("GameViewModel, shuffled cards> " + shuffledMemoryDeck);
    Platform.runLater(() -> assign());
  }

  private void assign()
  {
    card1.setValue(shuffledMemoryDeck.get(0)); card2.setValue(shuffledMemoryDeck.get(1));
    card3.setValue(shuffledMemoryDeck.get(2)); card4.setValue(shuffledMemoryDeck.get(3));
    card5.setValue(shuffledMemoryDeck.get(4)); card6.setValue(shuffledMemoryDeck.get(5));
    card7.setValue(shuffledMemoryDeck.get(6)); card8.setValue(shuffledMemoryDeck.get(7));
    card9.setValue(shuffledMemoryDeck.get(8)); card10.setValue(shuffledMemoryDeck.get(9));
    card11.setValue(shuffledMemoryDeck.get(10)); card12.setValue(shuffledMemoryDeck.get(11));
  }

  public List<String> getAllPairedCards()
  {
    return allPairedCards;
  }

  public String getFirstPlayerTurn()
  {
    return firstPlayerTurn.get();
  }

  public SimpleStringProperty firstPlayerTurnProperty() {
    return firstPlayerTurn;
  }

  public void getShuffledDeck(User user)
  {
    model.getShuffledDeck(user);
  }

  public void getFirstTurn()
  {
    model.getFirstTurn();
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

  public void openedCard(User thisUser, String card)
  {
    model.openedCard(thisUser, card);
  }
}
