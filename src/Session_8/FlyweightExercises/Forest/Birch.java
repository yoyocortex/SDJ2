package Session_8.FlyweightExercises.Forest;

public class Birch implements Tree
{
  @Override public String getBarkColour()
  {
    return "White";
  }

  @Override public String getLeafCoulour()
  {
    return "Green";
  }

  @Override public boolean hasLeaves()
  {
    return true;
  }

  @Override public String[] commonlyFoundInAreas()
  {
    return new String[]{"NA", "NE"};
  }
}
