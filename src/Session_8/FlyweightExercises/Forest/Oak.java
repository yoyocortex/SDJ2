package Session_8.FlyweightExercises.Forest;

public class Oak implements Tree
{

  @Override public String getBarkColour()
  {
    return "Brown";
  }

  @Override public String getLeafCoulour()
  {
    return "Light Green";
  }

  @Override public boolean hasLeaves()
  {
    return true;
  }

  @Override public String[] commonlyFoundInAreas()
  {
    return new String[]{"Europe", "NA", "Asia"};
  }
}
