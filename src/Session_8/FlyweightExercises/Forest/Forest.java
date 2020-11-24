package Session_8.FlyweightExercises.Forest;

import java.util.ArrayList;

public class Forest
{
  private ArrayList<Tree> trees;

  public Forest(int oak, int birch, int spruce)
  {
    trees = new ArrayList<>();
    for (int i = 0; i < oak; i++)
    {
      Tree oakTree = TreeFactory.getTree("oak");
      trees.add(oakTree);
    }
    for (int i = 0; i < birch; i++)
    {
      Tree birchTree = TreeFactory.getTree("birch");
      trees.add(birchTree);
    }
    for (int i = 0; i < spruce; i++)
    {
      Tree spruceTree = TreeFactory.getTree("spruce");
      trees.add(spruceTree);
    }
  }
}
