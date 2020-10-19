package Session_4.Exercise_2_UppercaseTwoViews.core;

import Session_4.Exercise_2_UppercaseTwoViews.log.LogViewController;
import Session_4.Exercise_2_UppercaseTwoViews.view_uppercase.UppercaseViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Scene uppercaseScene, logView;
  private Stage stage, logViewStage;
  private ViewModelFactory viewModelFactory;
  private ViewHandler viewHandler = this;

  public ViewHandler(ViewModelFactory viewModelFactory) {
    this.viewModelFactory = viewModelFactory;
  }

  public void start()
  {
    stage = new Stage();
    logViewStage = new Stage();
    openToUppercase();
    //openLogView();
  }

  public void openToUppercase() {
    if(uppercaseScene == null) {
      try {
        logViewStage.close();
        logView = null;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view_uppercase/UppercaseView.fxml"));
        Parent root = loader.load();

        UppercaseViewController ctrl = loader.getController();
        ctrl.init(viewHandler, viewModelFactory.getUppercaseViewModel());

        stage.setTitle("Uppercase");
        uppercaseScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      stage.setScene(uppercaseScene);
      stage.show();
    }
  }

  public void openLogView() {
    if(logView == null) {
      try {
        stage.close();
        uppercaseScene = null;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../log/LogView.fxml"));
        Parent root = loader.load();

        LogViewController ctrl = loader.getController();
        ctrl.init(viewHandler, viewModelFactory.getLogViewModel());

        logViewStage.setTitle("Uppercase");
        logView = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      logViewStage.setScene(logView);
      logViewStage.show();
    }
  }
}
