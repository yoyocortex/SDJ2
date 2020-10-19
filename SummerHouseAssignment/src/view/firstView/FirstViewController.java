package view.firstView;

import client.core.ViewHandler;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;

public class FirstViewController {

  @FXML
  private Label closeToHeaterLabel;

  @FXML
  private Label farFromHeaterLabel;

  @FXML
  private Label outsideTempLabel;

  @FXML
  private Label warningLabel;

  @FXML
  private Label heaterPowerLabel;

  @FXML
  private ProgressBar progressBar;

  private ViewHandler viewHandler;
  private FirstViewViewModel firstViewViewModel;

  public void init(ViewHandler viewHandler, FirstViewViewModel firstViewViewModel) {
    this.viewHandler = viewHandler;
    this.firstViewViewModel = firstViewViewModel;
    closeToHeaterLabel.textProperty().bind(this.firstViewViewModel.nearHeaterTempProperty());
    farFromHeaterLabel.textProperty().bind(this.firstViewViewModel.farFromHeaterTempProperty());
    outsideTempLabel.textProperty().bind(this.firstViewViewModel.outsideTempProperty());
    heaterPowerLabel.textProperty().bind(this.firstViewViewModel.heaterPowerProperty());
    closeToHeaterLabel.textProperty().addListener(this::setWarningLabel);
  }

  private void setWarningLabel(Observable observable, String old, String newVal) {
    double newValDouble = Double.parseDouble(newVal);
    double averageDouble = 0;

    try {
      double newVal2Double = Double.parseDouble(firstViewViewModel.getFarFromHeaterTemp());
      averageDouble = (newValDouble + newVal2Double)/2;
    }
    catch (java.lang.NullPointerException ignored) {}

    progressBar.setProgress((averageDouble*3.33)/100);

    if(newValDouble > 29) {
      warningLabel.setText("Temperature is TOO HIGH!");
      warningLabel.setTextFill(Color.RED);
    }
    else if(newValDouble < 11) {
      warningLabel.setText("Temperature is TOO LOW!");
      warningLabel.setTextFill(Color.BLUE);
    }
    else warningLabel.setText("Optimal temperature");
  }

  @FXML
  void powerDownButton(ActionEvent event) {
    firstViewViewModel.powerDown();
  }

  @FXML
  void powerUpButton(ActionEvent event) {
    firstViewViewModel.powerUp();
  }

  @FXML
  void onPastData(ActionEvent event) {
    viewHandler.openPastDataView();
  }

}
