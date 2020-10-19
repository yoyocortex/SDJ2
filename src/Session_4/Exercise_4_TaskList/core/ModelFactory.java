package Session_4.Exercise_4_TaskList.core;

import Session_4.Exercise_4_TaskList.model.ListModel;
import Session_4.Exercise_4_TaskList.model.TaskListModel;

public class ModelFactory
{
  private ListModel listModel;

  public ListModel getListModel()
  {
    if(listModel == null)
    {
      listModel = new TaskListModel();
    }
    return listModel;
  }
}
