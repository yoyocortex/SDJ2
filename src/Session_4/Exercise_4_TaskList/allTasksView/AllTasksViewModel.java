package Session_4.Exercise_4_TaskList.allTasksView;

import Session_4.Exercise_4_TaskList.Task;
import Session_4.Exercise_4_TaskList.model.ListModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AllTasksViewModel
{
  private ListModel listModel;
  private ObservableList<Task> items;

  public AllTasksViewModel(ListModel listModel)
  {
    this.listModel = listModel;
    items = FXCollections.observableArrayList(listModel.getAllTasks());
    //System.out.println(listModel.getAllTasks());
  }

  public ObservableList<Task> getItems()
  {
    //System.out.println("get items method " + listModel.getAllTasks());
    return items = FXCollections.observableArrayList(listModel.getAllTasks());
  }
}
