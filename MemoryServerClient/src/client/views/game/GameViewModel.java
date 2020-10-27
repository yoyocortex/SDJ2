package client.views.game;

import client.clientmodel.Memory;
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
  private StringProperty card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12,
      firstPlayerScore, secondPlayerScore, pairNotification;
  private List<String> shuffledMemoryDeck;
  private SimpleStringProperty firstPlayerTurn;
  private List<String> allPairedCards;
  private String resetString = "smth";

  public GameViewModel(Memory model)
  {
    this.model = model;
    this.model.addListener(EventType.SHUFFED_DECK_RESULT.toString(), this::assignCards);
    this.model.addListener(EventType.GET_FIRST_TURN_RESULT.toString(), this::firstTurn);
    this.model.addListener(EventType.KEEP_OPEN.toString(), this::keepOpen);
    this.model.addListener(EventType.FIRST_PLAYER_SCORE.toString(), this::firstPlayerScore);
    this.model.addListener(EventType.SECOND_PLAYER_SCORE.toString(), this::secondPlayerScore);
    this.model.addListener(EventType.SEND_PAIR_NOTIFICATION.toString(), this::pairNotification);
    this.model.addListener(EventType.RESET_RESULT.toString(), this::reset);


    shuffledMemoryDeck = new ArrayList<>();
    allPairedCards = new ArrayList<>();
    card1 = new SimpleStringProperty(); card2 = new SimpleStringProperty();
    card3 = new SimpleStringProperty(); card4 = new SimpleStringProperty();
    card5 = new SimpleStringProperty(); card6 = new SimpleStringProperty();
    card7 = new SimpleStringProperty(); card8 = new SimpleStringProperty();
    card9 = new SimpleStringProperty(); card10 = new SimpleStringProperty();
    card11 = new SimpleStringProperty(); card12 = new SimpleStringProperty();
    firstPlayerScore = new SimpleStringProperty(""); secondPlayerScore = new SimpleStringProperty("");
    firstPlayerTurn = new SimpleStringProperty(""); pairNotification = new SimpleStringProperty("");
  }

  private void reset(PropertyChangeEvent event)
  {
    resetString = (String) event.getNewValue();
  }

  private void pairNotification(PropertyChangeEvent event)
  {
    String newValue = (String) event.getNewValue();
    Platform.runLater(() -> pairNotification.set(newValue));
  }

  private void secondPlayerScore(PropertyChangeEvent event)
  {
    Integer newValue = (Integer) event.getNewValue();
    Platform.runLater(() -> secondPlayerScore.set(String.valueOf(newValue)));
  }

  private void firstPlayerScore(PropertyChangeEvent event)
  {
    Integer newValue = (Integer) event.getNewValue();
    Platform.runLater(() -> firstPlayerScore.set(String.valueOf(newValue)));
  }

  private void keepOpen(PropertyChangeEvent event)
  {
    allPairedCards = (List<String>) event.getNewValue();
  }

  private void firstTurn(PropertyChangeEvent event)
  {
    String firstUser = (String) event.getNewValue();
    Platform.runLater(() -> firstPlayerTurn.set(firstUser));
  }

  private void assignCards(PropertyChangeEvent event)
  {
    shuffledMemoryDeck = (List<String>) event.getNewValue();
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

  public String getResetString()
  {
    return resetString;
  }

  public void setResetString(String resetString)
  {
    this.resetString = resetString;
  }

  public String getPairNotification()
  {
    return pairNotification.get();
  }

  public StringProperty pairNotificationProperty()
  {
    return pairNotification;
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

  public String getFirstPlayerScore()
  {
    return firstPlayerScore.get();
  }

  public StringProperty firstPlayerScoreProperty()
  {
    return firstPlayerScore;
  }

  public String getSecondPlayerScore()
  {
    return secondPlayerScore.get();
  }

  public StringProperty secondPlayerScoreProperty()
  {
    return secondPlayerScore;
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

  public void reset()
  {
    model.reset();
  }
}
