package client.views.game;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import sharedClasses.transferObject.User;

import java.util.ArrayList;
import java.util.List;

public class GameController
{
  @FXML
  private Group group1;

  @FXML
  private Label labelNo1;

  @FXML
  private Group group2;

  @FXML
  private Label labelNo2;

  @FXML
  private Group group3;

  @FXML
  private Label labelNo3;

  @FXML
  private Group group4;

  @FXML
  private Label labelNo4;

  @FXML
  private Group group5;

  @FXML
  private Label labelNo5;

  @FXML
  private Group group6;

  @FXML
  private Label labelNo6;

  @FXML
  private Group group7;

  @FXML
  private Label labelNo7;

  @FXML
  private Group group8;

  @FXML
  private Label labelNo8;

  @FXML
  private Group group9;

  @FXML
  private Label labelNo9;

  @FXML
  private Group group10;

  @FXML
  private Label labelNo10;

  @FXML
  private Group group11;

  @FXML
  private Label labelNo11;

  @FXML
  private Group group12;

  @FXML
  private Label labelNo12;

  @FXML
  private Label pairLabel;

  @FXML
  private Label playerLabel;

  @FXML
  private Label firstPlayer;

  @FXML
  private Label yourScoreLabel;

  @FXML
  private Label player2ScoreLabel;

  private GameViewModel gameViewModel;
  private User thisUser;
  private boolean cardB1 = true, cardB2 = true, cardB3 = true, cardB4 = true, cardB5 = true, cardB6 = true, cardB7 = true
      , cardB8 = true, cardB9 = true, cardB10 = true, cardB11 = true, cardB12 = true;
  private List<String> check, check4Check;

  public void init(GameViewModel gameViewModel, User user)
  {
    this.gameViewModel = gameViewModel;
    thisUser = user;
    this.gameViewModel.getShuffledDeck(user);
    this.gameViewModel.getFirstTurn();

    check = new ArrayList<>();
    check4Check = new ArrayList<>();
    check4Check .add("0");
    check4Check.add("0");
    //check.add("0");
    //check.add("0");

    playerLabel.setText(thisUser.getUsername());

    labelNo1.textProperty().bind(this.gameViewModel.card1Property());
    labelNo2.textProperty().bind(this.gameViewModel.card2Property());
    labelNo3.textProperty().bind(this.gameViewModel.card3Property());
    labelNo4.textProperty().bind(this.gameViewModel.card4Property());
    labelNo5.textProperty().bind(this.gameViewModel.card5Property());
    labelNo6.textProperty().bind(this.gameViewModel.card6Property());
    labelNo7.textProperty().bind(this.gameViewModel.card7Property());
    labelNo8.textProperty().bind(this.gameViewModel.card8Property());
    labelNo9.textProperty().bind(this.gameViewModel.card9Property());
    labelNo10.textProperty().bind(this.gameViewModel.card10Property());
    labelNo11.textProperty().bind(this.gameViewModel.card11Property());
    labelNo12.textProperty().bind(this.gameViewModel.card12Property());
    yourScoreLabel.textProperty().bind(this.gameViewModel.firstPlayerScoreProperty());
    player2ScoreLabel.textProperty().bind(this.gameViewModel.secondPlayerScoreProperty());
    pairLabel.textProperty().bind(this.gameViewModel.pairNotificationProperty());

    Platform.runLater(() -> firstPlayer.textProperty().bind(this.gameViewModel.firstPlayerTurnProperty()));
    //System.out.println("First player turn gggggggggg> " + gameViewModel.firstPlayerTurnProperty().get());
    Runnable runnable = () -> {
      while(true)
      {
        if(!gameViewModel.firstPlayerTurnProperty().get().equals(thisUser.getUsername())) {
          //System.out.println(gameViewModel.firstPlayerTurnProperty().get());
          //System.out.println("disable fields");
          group1.setDisable(true);
          group2.setDisable(true);
          group3.setDisable(true);
          group4.setDisable(true);
          group5.setDisable(true);
          group6.setDisable(true);
          group7.setDisable(true);
          group8.setDisable(true);
          group9.setDisable(true);
          group10.setDisable(true);
          group11.setDisable(true);
          group12.setDisable(true);
        }
        else if(gameViewModel.firstPlayerTurnProperty().get().equals(thisUser.getUsername())) {
          //System.out.println(gameViewModel.firstPlayerTurnProperty().get());
          //System.out.println("enable fields");
          group1.setDisable(false);
          group2.setDisable(false);
          group3.setDisable(false);
          group4.setDisable(false);
          group5.setDisable(false);
          group6.setDisable(false);
          group7.setDisable(false);
          group8.setDisable(false);
          group9.setDisable(false);
          group10.setDisable(false);
          group11.setDisable(false);
          group12.setDisable(false);
        }

        onCheckCall();

        if(gameViewModel.getAllPairedCards().size() % 2 == 0 && !gameViewModel.getAllPairedCards().isEmpty())
        {
          //System.out.println("inside smth");
          for(int i = 0; i < gameViewModel.getAllPairedCards().size(); i++)
          {
            if(gameViewModel.getAllPairedCards().get(i).equals(labelNo1.getText()))
            {
              //System.out.println("Opened 1");
              onOpenCards(1);
              //group1.setDisable(true);
            }
            if(gameViewModel.getAllPairedCards().get(i).equals(labelNo2.getText()))
            {
              //System.out.println("Opened 2");
              onOpenCards(2);
              //group2.setDisable(true);
            }
            if(gameViewModel.getAllPairedCards().get(i).equals(labelNo3.getText()))
            {
              //System.out.println("Opened 3");
              onOpenCards(3);
              //group3.setDisable(true);
            }
            if(gameViewModel.getAllPairedCards().get(i).equals(labelNo4.getText()))
            {
              //System.out.println("Opened 4");
              onOpenCards(4);
              //group4.setDisable(true);
            }
            if(gameViewModel.getAllPairedCards().get(i).equals(labelNo5.getText()))
            {
              //System.out.println("Opened 5");
              onOpenCards(5);
              //group5.setDisable(true);
            }
            if(gameViewModel.getAllPairedCards().get(i).equals(labelNo6.getText()))
            {
              //System.out.println("Opened 6");
              onOpenCards(6);
              //group6.setDisable(true);
            }
            if(gameViewModel.getAllPairedCards().get(i).equals(labelNo7.getText()))
            {
              //System.out.println("Opened 7");
              onOpenCards(7);
              //group7.setDisable(true);
            }
            if(gameViewModel.getAllPairedCards().get(i).equals(labelNo8.getText()))
            {
              //System.out.println("Opened 8");
              onOpenCards(8);
              //group8.setDisable(true);
            }
            if(gameViewModel.getAllPairedCards().get(i).equals(labelNo9.getText()))
            {
              //System.out.println("Opened 9");
              onOpenCards(9);
              //group9.setDisable(true);
            }
            if(gameViewModel.getAllPairedCards().get(i).equals(labelNo10.getText()))
            {
              //System.out.println("Opened 10");
              onOpenCards(10);
              //group10.setDisable(true);
            }
            if(gameViewModel.getAllPairedCards().get(i).equals(labelNo11.getText()))
            {
              //System.out.println("Opened 11");
              onOpenCards(11);
              //group11.setDisable(true);
            }
            if(gameViewModel.getAllPairedCards().get(i).equals(labelNo12.getText()))
            {
              //System.out.println("Opened 12");
              onOpenCards(12);
              //group12.setDisable(true);
            }
          }
        }

      }
    };
    Thread t1 = new Thread(runnable);
    t1.setDaemon(true);
    t1.start();
    memoryStart();
  }

  @FXML
  void onShuffleDeckButton(ActionEvent event) {
    //TODO next round and so on
    check = new ArrayList<>();
    check4Check = new ArrayList<>();
    gameViewModel.reset();
    //gameViewModel.getShuffledDeck(thisUser);
    //gameViewModel.getFirstTurn();
    //memoryStart();
  }

  @FXML
  void onMouseClicked(MouseEvent event) {
    if(event.getSource() == group1)
    {
      if(!cardB1) {
        labelNo1.setVisible(false);
        cardB1 = true;
        //System.out.println("closed");
      }
      else if(cardB1) {
        labelNo1.setVisible(true);
        gameViewModel.openedCard(thisUser, gameViewModel.card1Property().get());
        cardB1 = false;
        check.add(labelNo1.getText());
        //System.out.println("opened");
      }
    }
    else if(event.getSource() == group2)
    {
      if(!cardB2) {
        labelNo2.setVisible(false);
        cardB2 = true;
      }
      else if(cardB2) {
        labelNo2.setVisible(true);
        gameViewModel.openedCard(thisUser, gameViewModel.card2Property().get());
        cardB2 = false;
        check.add(labelNo2.getText());
      }
    }
    else if(event.getSource() == group3)
    {
      check.add(labelNo3.getText());
      if(!cardB3) {
        labelNo3.setVisible(false);
        cardB3 = true;
      }
      else if(cardB3) {
        labelNo3.setVisible(true);
        gameViewModel.openedCard(thisUser, gameViewModel.card3Property().get());
        cardB3 = false;
      }
    }
    else if(event.getSource() == group4)
    {
      check.add(labelNo4.getText());
      if(!cardB4) {
        labelNo4.setVisible(false);
        cardB4 = true;
      }
      else if(cardB4) {
        labelNo4.setVisible(true);
        gameViewModel.openedCard(thisUser, gameViewModel.card4Property().get());
        cardB4 = false;
      }
    }
    else if(event.getSource() == group5)
    {
      check.add(labelNo5.getText());
      if(!cardB5) {
        labelNo5.setVisible(false);
        cardB5 = true;
      }
      else if(cardB5) {
        labelNo5.setVisible(true);
        gameViewModel.openedCard(thisUser, gameViewModel.card5Property().get());
        cardB5 = false;
      }
    }
    else if(event.getSource() == group6)
    {
      check.add(labelNo6.getText());
      if(!cardB6) {
        labelNo6.setVisible(false);
        cardB6 = true;
      }
      else if(cardB6) {
        labelNo6.setVisible(true);
        gameViewModel.openedCard(thisUser, gameViewModel.card6Property().get());
        cardB6 = false;
      }
    }
    else if(event.getSource() == group7)
    {
      check.add(labelNo7.getText());
      if(!cardB7) {
        labelNo7.setVisible(false);
        cardB7 = true;
      }
      else if(cardB7) {
        labelNo7.setVisible(true);
        gameViewModel.openedCard(thisUser, gameViewModel.card7Property().get());
        cardB7 = false;
      }
    }
    else if(event.getSource() == group8)
    {
      check.add(labelNo8.getText());
      if(!cardB8) {
        labelNo8.setVisible(false);
        cardB8 = true;
      }
      else if(cardB8) {
        labelNo8.setVisible(true);
        gameViewModel.openedCard(thisUser, gameViewModel.card8Property().get());
        cardB8 = false;
      }
    }
    else if(event.getSource() == group9)
    {
      check.add(labelNo9.getText());
      if(!cardB9) {
        labelNo9.setVisible(false);
        cardB9 = true;
      }
      else if(cardB9) {
        labelNo9.setVisible(true);
        gameViewModel.openedCard(thisUser, gameViewModel.card9Property().get());
        cardB9 = false;
      }
    }
    else if(event.getSource() == group10)
    {
      check.add(labelNo10.getText());
      if(!cardB10) {
        labelNo10.setVisible(false);
        cardB10 = true;
      }
      else if(cardB10) {
        labelNo10.setVisible(true);
        gameViewModel.openedCard(thisUser, gameViewModel.card10Property().get());
        cardB10 = false;
      }
    }
    else if(event.getSource() == group11)
    {
      check.add(labelNo11.getText());
      if(!cardB11) {
        labelNo11.setVisible(false);
        cardB11 = true;
      }
      else if(cardB11) {
        labelNo11.setVisible(true);
        gameViewModel.openedCard(thisUser, gameViewModel.card11Property().get());
        cardB11 = false;
      }
    }
    else if(event.getSource() == group12)
    {
      check.add(labelNo12.getText());
      if(!cardB12) {
        labelNo12.setVisible(false);
        cardB12 = true;
      }
      else if(cardB12) {
        labelNo12.setVisible(true);
        gameViewModel.openedCard(thisUser, gameViewModel.card12Property().get());
        cardB12 = false;
      }
    }
    System.out.println("Check> " + check);
    System.out.println("Check4Check> " + check4Check);
    //onCheckCall();
    //System.out.println("AllPairedCards> " + gameViewModel.getAllPairedCards());
  }

  private void onCheckCall() {
    if(check.size() % 2 == 0 && check.size() > 1 && (
        !check.get(check.size()-1).equals(check4Check.get(check4Check.size()-1)) ||
        !check.get(check.size()-2).equals(check4Check.get(check4Check.size()-2))))
    {
      for(int x = 0; x < 4; x++)
      {
        try
        {
          Thread.sleep(1000);
          System.out.println("Seconds left " + x);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
      //System.out.println(check.size());
      //System.out.println("sdasdasdads");
      for (int i = 0; i < check.size(); i++)
      {
        if (check.get(i).equals(labelNo1.getText()) && !cardB1)
        {
          System.out.println("Close 1");
          onCloseCards(1);
        }
        if (check.get(i).equals(labelNo2.getText()) && !cardB2)
        {
          System.out.println("Close 2");
          onCloseCards(2);
        }
        if (check.get(i).equals(labelNo3.getText()) && !cardB3)
        {
          System.out.println("Close 3");
          onCloseCards(3);
        }
        if (check.get(i).equals(labelNo4.getText()) && !cardB4)
        {
          System.out.println("Close 4");
          onCloseCards(4);
        }
        if (check.get(i).equals(labelNo5.getText()) && !cardB5)
        {
          System.out.println("Close 5");
          onCloseCards(5);
        }
        if (check.get(i).equals(labelNo6.getText()) && !cardB6)
        {
          System.out.println("Close 6");
          onCloseCards(6);
        }
        if (check.get(i).equals(labelNo7.getText()) && !cardB7)
        {
          System.out.println("Close 7");
          onCloseCards(7);
        }
        if (check.get(i).equals(labelNo8.getText()) && !cardB8)
        {
          System.out.println("Close 8");
          onCloseCards(8);
        }
        if (check.get(i).equals(labelNo9.getText()) && !cardB9)
        {
          System.out.println("Close 9");
          onCloseCards(9);
        }
        if (check.get(i).equals(labelNo10.getText()) && !cardB10)
        {
          System.out.println("Close 10");
          onCloseCards(10);
        }
        if (check.get(i).equals(labelNo11.getText()) && !cardB11)
        {
          System.out.println("Close 11");
          onCloseCards(11);
        }
        if (check.get(i).equals(labelNo12.getText()) && !cardB12)
        {
          System.out.println("Close 12");
          onCloseCards(12);
        }
      }
      check4Check.add(check.get(check.size()-2));
      check4Check.add(check.get(check.size()-1));
      System.out.println("Check4Check " + check4Check);
    }
  }

  private void memoryStart()
  {
    cardB1 = true; cardB2 = true; cardB3 = true; cardB4 = true; cardB5 = true; cardB6 = true;
    cardB7 = true; cardB8 = true; cardB9 = true; cardB10 = true; cardB11 = true; cardB12 = true;
    labelNo1.setVisible(true);
    labelNo2.setVisible(true);
    labelNo3.setVisible(true);
    labelNo4.setVisible(true);
    labelNo5.setVisible(true);
    labelNo6.setVisible(true);
    labelNo7.setVisible(true);
    labelNo8.setVisible(true);
    labelNo9.setVisible(true);
    labelNo10.setVisible(true);
    labelNo11.setVisible(true);
    labelNo12.setVisible(true);
    Runnable runnable = () -> {
      try
      {
        System.out.println("5s and counting");
        Thread.sleep(5000);
        System.out.println("done");
        labelNo1.setVisible(false);
        labelNo2.setVisible(false);
        labelNo3.setVisible(false);
        labelNo4.setVisible(false);
        labelNo5.setVisible(false);
        labelNo6.setVisible(false);
        labelNo7.setVisible(false);
        labelNo8.setVisible(false);
        labelNo9.setVisible(false);
        labelNo10.setVisible(false);
        labelNo11.setVisible(false);
        labelNo12.setVisible(false);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    };
    Thread t = new Thread(runnable);
    t.setDaemon(true);
    t.start();
  }

  void onCloseCards(int i) {
    if(i == 1)
    {
      if(!cardB1) {
        labelNo1.setVisible(false);
        cardB1 = true;
      }
    }
    else if(i == 2)
    {
      if(!cardB2) {
        labelNo2.setVisible(false);
        cardB2 = true;
      }
    }
    else if(i == 3)
    {
      if(!cardB3) {
        labelNo3.setVisible(false);
        cardB3 = true;
      }
    }
    else if(i == 4)
    {
      if(!cardB4) {
        labelNo4.setVisible(false);
        cardB4 = true;
      }
    }
    else if(i == 5)
    {
      if(!cardB5) {
        labelNo5.setVisible(false);
        cardB5 = true;
      }
    }
    else if(i == 6)
    {
      if(!cardB6) {
        labelNo6.setVisible(false);
        cardB6 = true;
      }
    }
    else if(i == 7)
    {
      if(!cardB7) {
        labelNo7.setVisible(false);
        cardB7 = true;
      }
    }
    else if(i == 8)
    {
      if(!cardB8) {
        labelNo8.setVisible(false);
        cardB8 = true;
      }
    }
    else if(i == 9)
    {
      if(!cardB9) {
        labelNo9.setVisible(false);
        cardB9 = true;
      }
    }
    else if(i == 10)
    {
      if(!cardB10) {
        labelNo10.setVisible(false);
        cardB10 = true;
      }
    }
    else if(i == 11)
    {
      if(!cardB11) {
        labelNo11.setVisible(false);
        cardB11 = true;
      }
    }
    else if(i == 12)
    {
      if(!cardB12) {
        labelNo12.setVisible(false);
        cardB12 = true;
      }
    }
  }

  void onOpenCards(int i) {
    if(i == 1)
    {
      //if(cardB1) {
        labelNo1.setVisible(true);
        cardB1 = false;
      //}
    }
    else if(i == 2)
    {
      //if(cardB2) {
        labelNo2.setVisible(true);
        cardB2 = false;
      //}
    }
    else if(i == 3)
    {
      //if(cardB3) {
        labelNo3.setVisible(true);
        cardB3 = false;
      //}
    }
    else if(i == 4)
    {
      //if(cardB4) {
        labelNo4.setVisible(true);
        cardB4 = false;
      //}
    }
    else if(i == 5)
    {
      //if(cardB5) {
        labelNo5.setVisible(true);
        cardB5 = false;
      //}
    }
    else if(i == 6)
    {
      //if(cardB6) {
        labelNo6.setVisible(true);
        cardB6 = false;
      //}
    }
    else if(i == 7)
    {
      //if(cardB7) {
        labelNo7.setVisible(true);
        cardB7 = false;
      //}
    }
    else if(i == 8)
    {
      //if(cardB8) {
        labelNo8.setVisible(true);
        cardB8 = false;
      //}
    }
    else if(i == 9)
    {
      //if(cardB9) {
        labelNo9.setVisible(true);
        cardB9 = false;
      //}
    }
    else if(i == 10)
    {
      //if(cardB10) {
        labelNo10.setVisible(true);
        cardB10 = false;
      //}
    }
    else if(i == 11)
    {
      //if(cardB11) {
        labelNo11.setVisible(true);
        cardB11 = false;
      //}
    }
    else if(i == 12)
    {
      //if(cardB12) {
        labelNo12.setVisible(true);
        cardB12 = false;
      //}
    }
  }
}
