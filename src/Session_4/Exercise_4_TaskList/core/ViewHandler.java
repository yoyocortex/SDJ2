package Session_4.Exercise_4_TaskList.core;

import Session_4.Exercise_4_TaskList.addTaskView.AddTaskController;
import Session_4.Exercise_4_TaskList.allTasksView.AllTasksController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private Scene scene, addScene;
  private ViewModelFactory viewModelFactory;
  private ViewHandler viewHandler = this;

  public ViewHandler(ViewModelFactory viewModelFactory) {
    this.viewModelFactory = viewModelFactory;
  }

  public void start()
  {
    stage = new Stage();
    openAllTasks();
  }

  public void openAllTasks() {
    if(scene == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../allTasksView/AllTasks.fxml"));
        Parent root = loader.load();

        AllTasksController ctrl = loader.getController();
        ctrl.init(viewHandler, viewModelFactory.getAllTasksViewModel());

        stage.setTitle("Uppercase");
        scene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      stage.setScene(scene);
      stage.show();
      addScene = null;
    }
  }

  public void openAddTask() {
    if(addScene == null) {
      try {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("../addTaskView/AddTask.fxml"));
        Parent root = loader.load();

        AddTaskController ctrl = loader.getController();
        ctrl.init(viewHandler, viewModelFactory.getAddTaskViewModel());

        stage.setTitle("Uppercase");
        addScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      stage.setScene(addScene);
      stage.show();
      scene = null;
    }
  }
}
