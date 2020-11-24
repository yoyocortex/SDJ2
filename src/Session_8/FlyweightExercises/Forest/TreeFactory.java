package Session_8.FlyweightExercises.Forest;

import java.util.HashMap;

public class TreeFactory
{
  private static HashMap<String, Tree> map = new HashMap<>();

  public static Tree getTree(String type)
  {
    Tree tree = map.get(type);
    if(tree == null)
    {
      switch (type)
      {
        case "oak":
        {
          tree = new Oak();
        }
        case "birch":
        {
          tree = new Birch();
        }
        case "spruce":
        {
          tree = new Spruce();
        }
      }
      map.put(type, tree);
    }
    return tree;
  }
}
