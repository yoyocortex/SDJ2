package standAloneMemory.views.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import standAloneMemory.core.ViewHandler;

import java.util.Arrays;

public class GameController
{
  @FXML
  private Label labelNo1;

  @FXML
  private Label labelNo2;

  @FXML
  private Label labelNo3;

  @FXML
  private Label labelNo4;

  @FXML
  private Label labelNo5;

  @FXML
  private Label labelNo6;

  @FXML
  private Label labelNo7;

  @FXML
  private Label labelNo8;

  @FXML
  private Label labelNo9;

  @FXML
  private Label labelNo10;

  @FXML
  private Label labelNo11;

  @FXML
  private Label labelNo12;

  @FXML
  private Label pairLabel;

  @FXML
  private Group group1;

  @FXML
  private Group group2;

  @FXML
  private Group group3;

  @FXML
  private Group group4;

  @FXML
  private Group group5;

  @FXML
  private Group group6;

  @FXML
  private Group group7;

  @FXML
  private Group group8;

  @FXML
  private Group group9;

  @FXML
  private Group group10;

  @FXML
  private Group group11;

  @FXML
  private Group group12;

  private ViewHandler viewHandler;
  private GameViewModel gameViewModel;
  private boolean cardB1 = true, cardB2 = true, cardB3 = true, cardB4 = true, cardB5 = true, cardB6 = true, cardB7 = true
      , cardB8 = true, cardB9 = true, cardB10 = true, cardB11 = true, cardB12 = true;
  private String[] check = {"0","0"};

  public void init(ViewHandler viewHandler, GameViewModel gameViewModel)
  {
    this.viewHandler = viewHandler;
    this.gameViewModel = gameViewModel;
    labelNo1.textProperty().bind(gameViewModel.card1Property());
    labelNo2.textProperty().bind(gameViewModel.card2Property());
    labelNo3.textProperty().bind(gameViewModel.card3Property());
    labelNo4.textProperty().bind(gameViewModel.card4Property());
    labelNo5.textProperty().bind(gameViewModel.card5Property());
    labelNo6.textProperty().bind(gameViewModel.card6Property());
    labelNo7.textProperty().bind(gameViewModel.card7Property());
    labelNo8.textProperty().bind(gameViewModel.card8Property());
    labelNo9.textProperty().bind(gameViewModel.card9Property());
    labelNo10.textProperty().bind(gameViewModel.card10Property());
    labelNo11.textProperty().bind(gameViewModel.card11Property());
    labelNo12.textProperty().bind(gameViewModel.card12Property());
    pairLabel.textProperty().bind(gameViewModel.pairProperty());
    memoryStart();
  }

  private void closeOpenedCards()
  {
    if (!Arrays.equals(check, gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1))) {
      System.out.println(Arrays.toString(check));
      System.out.println(Arrays.toString(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)));
      Runnable runnable = () -> {
        try
        {
          System.out.println("1s and counting");
          Thread.sleep(1000);
          System.out.println("done");
          if(Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[0]) == Integer.parseInt(labelNo1.getText())
              || Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[1]) == Integer.parseInt(labelNo1.getText()))
            onCloseCards(1);
          if(Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[0]) == Integer.parseInt(labelNo2.getText())
              || Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[1]) == Integer.parseInt(labelNo2.getText()))
            onCloseCards(2);
          if(Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[0]) == Integer.parseInt(labelNo3.getText())
              || Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[1]) == Integer.parseInt(labelNo3.getText()))
            onCloseCards(3);
          if(Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[0]) == Integer.parseInt(labelNo4.getText())
              || Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[1]) == Integer.parseInt(labelNo4.getText()))
            onCloseCards(4);
          if(Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[0]) == Integer.parseInt(labelNo5.getText())
              || Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[1]) == Integer.parseInt(labelNo5.getText()))
            onCloseCards(5);
          if(Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[0]) == Integer.parseInt(labelNo6.getText())
              || Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[1]) == Integer.parseInt(labelNo6.getText()))
            onCloseCards(6);
          if(Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[0]) == Integer.parseInt(labelNo7.getText())
              || Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[1]) == Integer.parseInt(labelNo7.getText()))
            onCloseCards(7);
          if(Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[0]) == Integer.parseInt(labelNo8.getText())
              || Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[1]) == Integer.parseInt(labelNo8.getText()))
            onCloseCards(8);
          if(Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[0]) == Integer.parseInt(labelNo9.getText())
              || Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[1]) == Integer.parseInt(labelNo9.getText()))
            onCloseCards(9);
          if(Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[0]) == Integer.parseInt(labelNo10.getText())
              || Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[1]) == Integer.parseInt(labelNo10.getText()))
            onCloseCards(10);
          if(Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[0]) == Integer.parseInt(labelNo11.getText())
              || Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[1]) == Integer.parseInt(labelNo11.getText()))
            onCloseCards(11);
          if(Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[0]) == Integer.parseInt(labelNo12.getText())
              || Integer.parseInt(gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1)[1]) == Integer.parseInt(labelNo12.getText()))
            onCloseCards(12);
          check = gameViewModel.notPairdCards.get(gameViewModel.notPairdCards.size() - 1);
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
    //Thread.sleep(10000);
  }

  @FXML
  void onShuffleDeckButton(ActionEvent event) {
    gameViewModel.shuffleDeckAgain();
    memoryStart();
  }

  @FXML
  void onMouseClicked(MouseEvent event) {
    if(event.getSource() == group1)
    {
      if(!cardB1) {
        labelNo1.setVisible(false);
        gameViewModel.setCardB1(false);
        cardB1 = true;
        //System.out.println("closed");
      }
      else if(cardB1) {
        labelNo1.setVisible(true);
        gameViewModel.setCardB1(true);
        cardB1 = false;
        //System.out.println("opened");
      }
      //System.out.println("clicked box 1");
    }
    else if(event.getSource() == group2)
    {
      if(!cardB2) {
      labelNo2.setVisible(false);
      gameViewModel.setCardB2(false);
      cardB2 = true;
    }
    else if(cardB2) {
      labelNo2.setVisible(true);
      gameViewModel.setCardB2(true);
      cardB2 = false;
    }
      //System.out.println("clicked box 2");
    }
    else if(event.getSource() == group3)
    {
      if(!cardB3) {
        labelNo3.setVisible(false);
        gameViewModel.setCardB3(false);
        cardB3 = true;
      }
      else if(cardB3) {
        labelNo3.setVisible(true);
        gameViewModel.setCardB3(true);
        cardB3 = false;
      }
      //System.out.println("clicked box 3");
    }
    else if(event.getSource() == group4)
    {
      if(!cardB4) {
        labelNo4.setVisible(false);
        gameViewModel.setCardB4(false);
        cardB4 = true;
      }
      else if(cardB4) {
        labelNo4.setVisible(true);
        gameViewModel.setCardB4(true);
        cardB4 = false;
      }
      //System.out.println("clicked box 4");
    }
    else if(event.getSource() == group5)
    {
      if(!cardB5) {
        labelNo5.setVisible(false);
        gameViewModel.setCardB5(false);
        cardB5 = true;
      }
      else if(cardB5) {
        labelNo5.setVisible(true);
        gameViewModel.setCardB5(true);
        cardB5 = false;
      }
      //System.out.println("clicked box 5");
    }
    else if(event.getSource() == group6)
    {
      if(!cardB6) {
        labelNo6.setVisible(false);
        gameViewModel.setCardB6(false);
        cardB6 = true;
      }
      else if(cardB6) {
        labelNo6.setVisible(true);
        gameViewModel.setCardB6(true);
        cardB6 = false;
      }
      //System.out.println("clicked box 6");
    }
    else if(event.getSource() == group7)
    {
      if(!cardB7) {
        labelNo7.setVisible(false);
        gameViewModel.setCardB7(false);
        cardB7 = true;
      }
      else if(cardB7) {
        labelNo7.setVisible(true);
        gameViewModel.setCardB7(true);
        cardB7 = false;
      }
      //System.out.println("clicked box 7");
    }
    else if(event.getSource() == group8)
    {
      if(!cardB8) {
        labelNo8.setVisible(false);
        gameViewModel.setCardB8(false);
        cardB8 = true;
      }
      else if(cardB8) {
        labelNo8.setVisible(true);
        gameViewModel.setCardB8(true);
        cardB8 = false;
      }
      //System.out.println("clicked box 8");
    }
    else if(event.getSource() == group9)
    {
      if(!cardB9) {
        labelNo9.setVisible(false);
        gameViewModel.setCardB9(false);
        cardB9 = true;
      }
      else if(cardB9) {
        labelNo9.setVisible(true);
        gameViewModel.setCardB9(true);
        cardB9 = false;
      }
      //System.out.println("clicked box 9");
    }
    else if(event.getSource() == group10)
    {
      if(!cardB10) {
        labelNo10.setVisible(false);
        gameViewModel.setCardB10(false);
        cardB10 = true;
      }
      else if(cardB10) {
        labelNo10.setVisible(true);
        gameViewModel.setCardB10(true);
        cardB10 = false;
      }
      //System.out.println("clicked box 10");
    }
    else if(event.getSource() == group11)
    {
      if(!cardB11) {
        labelNo11.setVisible(false);
        gameViewModel.setCardB11(false);
        cardB11 = true;
      }
      else if(cardB11) {
        labelNo11.setVisible(true);
        gameViewModel.setCardB11(true);
        cardB11 = false;
      }
      //System.out.println("clicked box 11");
    }
    else if(event.getSource() == group12)
    {
      if(!cardB12) {
        labelNo12.setVisible(false);
        gameViewModel.setCardB12(false);
        cardB12 = true;
      }
      else if(cardB12) {
        labelNo12.setVisible(true);
        gameViewModel.setCardB12(true);
        cardB12 = false;
      }
      //System.out.println("clicked box 12");
    }
    closeOpenedCards();
  }

  void onCloseCards(int i) {
    if(i == 1)
    {
      if(!cardB1) {
        labelNo1.setVisible(false);
        //gameViewModel.setCardB1(false);
        cardB1 = true;
        //System.out.println("closed");
      }
      //System.out.println("clicked box 1");
    }
    else if(i == 2)
    {
      if(!cardB2) {
        labelNo2.setVisible(false);
        //gameViewModel.setCardB2(false);
        cardB2 = true;
      }
      //System.out.println("clicked box 2");
    }
    else if(i == 3)
    {
      if(!cardB3) {
        labelNo3.setVisible(false);
        //gameViewModel.setCardB3(false);
        cardB3 = true;
      }
      //System.out.println("clicked box 3");
    }
    else if(i == 4)
    {
      if(!cardB4) {
        labelNo4.setVisible(false);
        //gameViewModel.setCardB4(false);
        cardB4 = true;
      }
      //System.out.println("clicked box 4");
    }
    else if(i == 5)
    {
      if(!cardB5) {
        labelNo5.setVisible(false);
        //gameViewModel.setCardB5(false);
        cardB5 = true;
      }
      //System.out.println("clicked box 5");
    }
    else if(i == 6)
    {
      if(!cardB6) {
        labelNo6.setVisible(false);
        //gameViewModel.setCardB6(false);
        cardB6 = true;
      }
      //System.out.println("clicked box 6");
    }
    else if(i == 7)
    {
      if(!cardB7) {
        labelNo7.setVisible(false);
        //gameViewModel.setCardB7(false);
        cardB7 = true;
      }
      //System.out.println("clicked box 7");
    }
    else if(i == 8)
    {
      if(!cardB8) {
        labelNo8.setVisible(false);
        //gameViewModel.setCardB8(false);
        cardB8 = true;
      }
      //System.out.println("clicked box 8");
    }
    else if(i == 9)
    {
      if(!cardB9) {
        labelNo9.setVisible(false);
        //gameViewModel.setCardB9(false);
        cardB9 = true;
      }
      //System.out.println("clicked box 9");
    }
    else if(i == 10)
    {
      if(!cardB10) {
        labelNo10.setVisible(false);
        //gameViewModel.setCardB10(false);
        cardB10 = true;
      }
      //System.out.println("clicked box 10");
    }
    else if(i == 11)
    {
      if(!cardB11) {
        labelNo11.setVisible(false);
        //gameViewModel.setCardB11(false);
        cardB11 = true;
      }
      //System.out.println("clicked box 11");
    }
    else if(i == 12)
    {
      if(!cardB12) {
        labelNo12.setVisible(false);
        //gameViewModel.setCardB12(false);
        cardB12 = true;
      }
      //System.out.println("clicked box 12");
    }
  }
}