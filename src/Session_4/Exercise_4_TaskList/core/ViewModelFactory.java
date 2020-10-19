package Session_4.Exercise_4_TaskList.core;

import Session_4.Exercise_4_TaskList.addTaskView.AddTaskViewModel;
import Session_4.Exercise_4_TaskList.allTasksView.AllTasksViewModel;

public class ViewModelFactory
{
  private AllTasksViewModel allTasksViewModel;
  private AddTaskViewModel addTaskViewModel;
  private ModelFactory modelFactory;

  public ViewModelFactory(ModelFactory modelFactory) {
    this.modelFactory = modelFactory;
  }

  public AllTasksViewModel getAllTasksViewModel() {
    if(allTasksViewModel == null)
    {
      allTasksViewModel = new AllTasksViewModel(modelFactory.getListModel());
    }
    return allTasksViewModel;
  }

  public AddTaskViewModel getAddTaskViewModel() {
    if(addTaskViewModel == null)
    {
      addTaskViewModel = new AddTaskViewModel(modelFactory.getListModel());
    }
    return addTaskViewModel;
  }
}
