package Session_8.SingletonExercises.SingletonExercise1;

public class LogTest
{
  public static void main(String[] args)
  {
    Log log = Log.getLog();
    log.add("Gosia farted again");
    System.out.println(log.getAll());

    Log log2 = Log.getLog();
    log2.add("Yes");
    System.out.println(log.getAll());
    System.out.println(log2.getAll());
  }
}
