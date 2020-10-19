package Session_4.Exercise_4_TaskList.allTasksView;

import Session_4.Exercise_4_TaskList.Task;
import Session_4.Exercise_4_TaskList.core.ViewHandler;
import Session_4.Exercise_4_TaskList.core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class AllTasksController {

  @FXML
  private Button addTaskButton;

  @FXML
  private Button nextTaskButton;

  @FXML
  private Button updateButton;

  @FXML
  private TableView<Task> tableView;

  @FXML
  private TableColumn<String, Task> creatorColumn;

  @FXML
  private TableColumn<String, Task> descColumn;

  @FXML
  private TableColumn<String, Task> dateColumn;

  private ViewHandler viewHandler;
  private AllTasksViewModel allTasksViewModel;

  @FXML
  void onAddTaskButton(ActionEvent event) {
    System.out.println("add button");
    viewHandler.openAddTask();
  }

  @FXML
  void onNextTaskButton(ActionEvent event) {

  }

  @FXML
  void onUpdateButton(ActionEvent event) {
    tableView.setItems(allTasksViewModel.getItems());
    System.out.println("update button " + allTasksViewModel.getItems());
  }

  public void init(ViewHandler viewHandler, AllTasksViewModel allTasksViewModel) {
    this.viewHandler = viewHandler;
    this.allTasksViewModel = allTasksViewModel;
    creatorColumn.setCellValueFactory(new PropertyValueFactory<>("creator"));
    descColumn.setCellValueFactory(new PropertyValueFactory<>("description"));
    dateColumn.setCellValueFactory(new PropertyValueFactory<>("timeCreated"));
    tableView.setItems(allTasksViewModel.getItems());
  }

}
