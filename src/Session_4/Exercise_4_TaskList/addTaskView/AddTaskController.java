package Session_4.Exercise_4_TaskList.addTaskView;

import Session_4.Exercise_4_TaskList.core.ViewHandler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddTaskController {

  @FXML
  private Button addTaskButton;

  @FXML
  private Button backButton;

  @FXML
  private TextField creatorTextField;

  @FXML
  private TextField descriptionTextField;

  private ViewHandler viewHandler;
  private AddTaskViewModel addTaskViewModel;

  @FXML
  void onAddTaskButton(ActionEvent event) {
    addTaskViewModel.addTask();
    viewHandler.openAllTasks();
  }

  @FXML
  void onBackButton(ActionEvent event) {
    System.out.println("back button");
    viewHandler.openAllTasks();
  }

  public void init(ViewHandler viewHandler, AddTaskViewModel addTaskViewModel) {
    this.viewHandler = viewHandler;
    this.addTaskViewModel = addTaskViewModel;
    creatorTextField.textProperty().bindBidirectional(addTaskViewModel.creatorProperty());
    descriptionTextField.textProperty().bindBidirectional(addTaskViewModel.descriptionProperty());
  }
}
