package client.views.startmenu;

import client.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class StartMenuController {

  @FXML
  private ListView<String> onlinePlayersList;

  @FXML
  private Label warningLabel;

  @FXML
  private Label loggedInUser;

  private StartMenuViewModel startMenuViewModel;
  private ViewHandler viewHandler;

  public void init(StartMenuViewModel startMenuViewModel, ViewHandler viewHandler)
  {
    this.viewHandler = viewHandler;
    this.startMenuViewModel = startMenuViewModel;

    startMenuViewModel.populateList();
    onlinePlayersList.itemsProperty().bind(startMenuViewModel.listPropertyProperty());
    loggedInUser.textProperty().bind(startMenuViewModel.loggedInUserProperty());
  }


  @FXML
  void onExitButton(ActionEvent event) {
    System.exit(0);
  }

  @FXML
  void onPlayButton(ActionEvent event) {
    String selectedItem = onlinePlayersList.getSelectionModel().getSelectedItem();

    if(("You are logged in with; " + selectedItem).equals(loggedInUser.getText()))
      warningLabel.setText("Select a user that is not you.");
    else
    {
      warningLabel.setText("");
      startMenuViewModel.requestDuel(selectedItem);
    }
  }
}
