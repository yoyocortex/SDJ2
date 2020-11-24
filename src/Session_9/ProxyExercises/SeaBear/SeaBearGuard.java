package Session_9.ProxyExercises.SeaBear;

public class SeaBearGuard implements VisitSeaBear
{
  @Override public void view(String personType)
  {
    SeaBear seaBear = new SeaBear();
    seaBear.view(personType);
  }

  @Override public void feed(String personType)
  {
    if("zookeeper".equalsIgnoreCase(personType))
    {
      SeaBear seaBear = new SeaBear();
      seaBear.feed(personType);
    }
  }

  @Override public void pet(String personType)
  {
    if("children".equalsIgnoreCase(personType))
    {
      SeaBear seaBear = new SeaBear();
      seaBear.pet(personType);
    }
  }
}
