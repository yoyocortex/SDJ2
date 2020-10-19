package Session_4.Exercise_4_TaskList;

public class Task
{
  private String creator, description, timeCreated;

  public Task(String creator, String description, String timeCreated) {
    this.creator = creator;
    this.description = description;
    this.timeCreated = timeCreated;
  }

  public String getCreator() {
    return creator;
  }

  public String getDescription() {
    return description;
  }

  public String getTimeCreated() {
    return timeCreated;
  }

  public String toString() {
    return creator + " " + description + " " + timeCreated;
  }
}
