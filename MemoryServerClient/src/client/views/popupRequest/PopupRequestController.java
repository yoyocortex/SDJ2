package client.views.popupRequest;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class PopupRequestController {

  @FXML
  private Label userLabel;

  private PopupRequestViewModel popupRequestViewModel;
  private ViewHandler viewHandler;
  private String enemy, host;

  public void init(PopupRequestViewModel popupRequestViewModel, ViewHandler viewHandler,
      String enemyUser, String host) {
    this.viewHandler = viewHandler;
    this.popupRequestViewModel = popupRequestViewModel;
    this.enemy = enemyUser;
    this.host = host;
    userLabel.setText(enemyUser);
  }

  @FXML
  void onNoButton(ActionEvent event) {
    Stage stage = (Stage) userLabel.getScene().getWindow();
    stage.close();
  }

  @FXML
  void onYesButton(ActionEvent event) {
    popupRequestViewModel.openGameView(enemy, host);
    Stage stage = (Stage) userLabel.getScene().getWindow();
    stage.close();
  }

}
