package Session_8.SingletonExercises.SingletonExercise1;

public class LogLine
{
  private String logEntry;
  private String time;

  public LogLine(String logEntry, String time)
  {
    this.logEntry = logEntry;
    this.time = time;
  }

  public String getLogEntry()
  {
    return logEntry;
  }

  @Override public String toString()
  {
    return "LogLine{" + "logEntry='" + logEntry + '\'' + ", time='" + time
        + '\'' + '}';
  }
}
