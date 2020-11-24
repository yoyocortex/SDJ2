package Session_9.ProxyExercises.SeaBear;

public class SeaBear implements VisitSeaBear
{

  @Override public void view(String personType)
  {
    System.out.println("Sea bear is viewed by " + personType + ".");
  }

  @Override public void feed(String personType)
  {
    System.out.println("Sea bear is being feed by " + personType + ".");
  }

  @Override public void pet(String personType)
  {
    System.out.println("Sea bear is being pet by " + personType + ".");
  }
}
