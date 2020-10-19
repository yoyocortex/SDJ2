package Session_3.Exercise_5;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class MainFXML extends Application
{
    public void start(Stage window)
        throws IOException
    {
      DataModel dataModel = new DataModel();
      Thread thread = new Thread(dataModel);
      thread.setDaemon(true);
      thread.start();

      window.setTitle("PieChart");
      FXMLLoader loader = new FXMLLoader();
      loader.setLocation(getClass().getResource("DataVisualizer.fxml"));
      Parent load = loader.load();
      Controller controller = loader.getController();
      controller.initialize(dataModel);
      Scene scene = new Scene(load);
      window.setScene(scene);
      window.show();
    }
  }
