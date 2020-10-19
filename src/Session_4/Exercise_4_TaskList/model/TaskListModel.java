package Session_4.Exercise_4_TaskList.model;

import Session_4.Exercise_4_TaskList.Task;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TaskListModel implements ListModel
{
  private List<Task> list = new ArrayList<>();

  @Override public Task getNextTask()
  {
    return null;
  }

  @Override public void addTask(String creator, String description)
  {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
        "yyyy/MM/dd HH:mm:ss");
    Date now = new Date();
    list.add(new Task(creator, description, simpleDateFormat.format(now)));
    //System.out.println(list.toString());
  }

  @Override public List<Task> getAllTasks()
  {
    return list;
  }
}
