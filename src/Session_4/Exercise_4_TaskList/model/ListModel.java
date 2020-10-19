package Session_4.Exercise_4_TaskList.model;

import Session_4.Exercise_4_TaskList.Task;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public interface ListModel
{
  public Task getNextTask();
  public void addTask(String creator, String description);
  public List<Task> getAllTasks();
}
