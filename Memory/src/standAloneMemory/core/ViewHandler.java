package standAloneMemory.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import standAloneMemory.views.game.GameController;
import standAloneMemory.views.startmenu.StartMenuController;

import java.io.IOException;

public class ViewHandler
{
  private Scene firstScene, secondScene;
  private Stage stage;
  private ViewModelFactory viewModelFactory;
  private ViewHandler viewHandler = this;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
    stage = new Stage();
  }

  public void start() {
    openStartMenuView();
  }

  public void openStartMenuView() {
    if (firstScene == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/startmenu/StartMenu.fxml"));
        Parent root = loader.load();

        StartMenuController ctrl = loader.getController();
        ctrl.init(viewHandler, viewModelFactory.getStartMenuViewModel());

        stage.setTitle("Start Menu");
        firstScene = new Scene(root);
      }
      catch (IOException e) {
        e.printStackTrace();
      }
      stage.setScene(firstScene);
      stage.show();
      secondScene = null;
    }
  }

  public void openGameView()
  {
    if (secondScene == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../views/game/Game.fxml"));
        Parent root = loader.load();

        GameController ctrl = loader.getController();
        ctrl.init(viewHandler, viewModelFactory.getGameViewModel());

        stage.setTitle("Game");
        secondScene = new Scene(root);
      }
      catch (IOException e) {
        e.printStackTrace();
      }
      stage.setScene(secondScene);
      stage.show();
      firstScene = null;
    }
  }
}
