package client.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.firstView.FirstViewController;
import view.secondView.SecondViewController;

import java.io.IOException;

public class ViewHandler
{
  private Scene firstScene, secondScene;
  private Stage stage;
  private ViewModelFactory viewModelFactory;
  private ViewHandler viewHandler = this;

  public ViewHandler(ViewModelFactory viewModelFactory) {
    this.viewModelFactory = viewModelFactory;
    stage = new Stage();
  }

  public void Start() {
    openTemperatureView();
  }

  public void openTemperatureView() {
    if (firstScene == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../view/firstView/FirstView.fxml"));
        Parent root = loader.load();

        FirstViewController ctrl = loader.getController();
        ctrl.init(viewHandler, viewModelFactory.getFirstViewViewModel());

        stage.setTitle("idk yet");
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

  public void openPastDataView()
  {
    if (secondScene == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../../view/secondView/SecondView.fxml"));
        Parent root = loader.load();

        SecondViewController ctrl = loader.getController();
        ctrl.init(viewHandler, viewModelFactory.getSecondViewViewModel());

        stage.setTitle("idk yet2");
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
