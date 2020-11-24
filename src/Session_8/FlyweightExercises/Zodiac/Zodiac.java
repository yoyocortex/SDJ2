package Session_8.FlyweightExercises.Zodiac;

public class Zodiac
{
  private String name;
  private String startDate;
  private String endDate;

  public Zodiac(String name, String startDate, String endDate)
  {
    this.name = name;
    this.startDate = startDate;
    this.endDate = endDate;
  }

  public String getName()
  {
    return name;
  }

  public String getInterval()
  {
    return startDate + " - " + endDate;
  }

  @Override public String toString()
  {
    return "Zodiac{" + "name='" + name + "' '" + getInterval() + "'" + '}';
  }
}
