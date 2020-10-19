package Session_4.Exercise_4_TaskList.addTaskView;

import Session_4.Exercise_4_TaskList.model.ListModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class AddTaskViewModel
{
  private StringProperty creator, description;
  private ListModel listModel;

  public AddTaskViewModel(ListModel listModel) {
    this.listModel = listModel;
    creator = new SimpleStringProperty();
    description = new SimpleStringProperty();
  }

  public String getCreator() {
    return creator.get();
  }

  public StringProperty creatorProperty() {
    return creator;
  }

  public String getDescription() {
    return description.get();
  }

  public StringProperty descriptionProperty() {
    return description;
  }

  public void addTask() {
    if(!getCreator().isEmpty() && !getDescription().isEmpty()) {
      listModel.addTask(getCreator(), getDescription());
      creator.set(""); description.set("");
    }
  }
}
