package Session_4.Exercise_3_TemperaturePresenter.core;

import Session_4.Exercise_3_TemperaturePresenter.view.TemperatureViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Scene currentScene;
  private Stage currentStage;
  private ViewModelFactory viewModelFactory;
  private ViewHandler viewHandler = this;

  public ViewHandler(ViewModelFactory viewModelFactory) {
    this.viewModelFactory = viewModelFactory;
  }

  public void start() {
    currentStage = new Stage();
    openTemperatureView();
  }

  public void openTemperatureView() {
    if(currentScene == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view/TemperatureView.fxml"));
        Parent root = loader.load();

        TemperatureViewController ctrl = loader.getController();
        ctrl.init(viewHandler, viewModelFactory.getTemperatureViewModel());

        currentStage.setTitle("Temperature View");
        currentScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      currentStage.setScene(currentScene);
      currentStage.show();
    }
  }
}
