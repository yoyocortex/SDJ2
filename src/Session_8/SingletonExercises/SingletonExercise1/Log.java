package Session_8.SingletonExercises.SingletonExercise1;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Log
{
  private static List<LogLine> queue;
  private static Log log;

  private Log()
  {
    queue = new ArrayList<>();
  }

  public static synchronized Log getLog()
  {
    if(log == null)
    {
      log = new Log();
    }
    return log;
  }

  public synchronized void add(String logEntry)
  {
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    String formattedDate = myDateObj.format(myFormatObj);
    queue.add(new LogLine(logEntry, formattedDate));
  }

  public List<LogLine> getAll()
  {
    return queue;
  }
}
