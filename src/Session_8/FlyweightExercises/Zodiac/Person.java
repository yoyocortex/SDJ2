package Session_8.FlyweightExercises.Zodiac;

public class Person
{
  private String name;
  private Zodiac zodiac;

  public Person(String name, Zodiac zodiac)
  {
    this.name = name;
    this.zodiac = zodiac;
  }

  public String getName()
  {
    return name;
  }

  public Zodiac getZodiac()
  {
    return zodiac;
  }

  @Override public String toString()
  {
    return "Person{" + "name='" + name + '\'' + ", zodiac=" + zodiac + '}';
  }
}
