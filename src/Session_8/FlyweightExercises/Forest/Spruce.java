package Session_8.FlyweightExercises.Forest;

public class Spruce implements Tree
{
  @Override public String getBarkColour()
  {
    return "Dark Brown";
  }

  @Override public String getLeafCoulour()
  {
    return "Dark Green";
  }

  @Override public boolean hasLeaves()
  {
    return true;
  }

  @Override public String[] commonlyFoundInAreas()
  {
    return new String[]{"Sweden", "Norway"};
  }
}
