package Session_4.Exercise_1_Uppercase.core;

import Session_4.Exercise_1_Uppercase.view_uppercase.UppercaseViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Scene uppercaseScene;
  private Stage stage;
  private ViewModelFactory viewModelFactory;

  public ViewHandler(ViewModelFactory viewModelFactory) {
    this.viewModelFactory = viewModelFactory;
  }

  public void start()
  {
    stage = new Stage();
    openToUppercase();
  }

  public void openToUppercase() {
    if(uppercaseScene == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../view_uppercase/UppercaseView.fxml"));
        Parent root = loader.load();

        UppercaseViewController ctrl = loader.getController();
        ctrl.init(viewModelFactory.getUppercaseViewModel());

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
}
