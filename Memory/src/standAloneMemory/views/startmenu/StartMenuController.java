package standAloneMemory.views.startmenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import standAloneMemory.core.ViewHandler;

public class StartMenuController
{
  private ViewHandler viewHandler;
  private StartMenuViewModel startMenuViewModel;

  public void init(ViewHandler viewHandler, StartMenuViewModel startMenuViewModel)
  {
    this.viewHandler = viewHandler;
    this.startMenuViewModel = startMenuViewModel;
  }

  @FXML
  void onMultiplayerButton(ActionEvent event) {

  }

  @FXML
  void onSingleplayerButton(ActionEvent event) {
    viewHandler.openGameView();
  }
}
