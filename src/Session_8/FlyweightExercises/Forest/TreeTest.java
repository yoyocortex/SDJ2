package Session_8.FlyweightExercises.Forest;

public class TreeTest
{
  public static void main(String[] args)
  {
    Tree o1 = TreeFactory.getTree("oak");
    Tree o2 = TreeFactory.getTree("oak");
    System.out.println(o1 == o2);
    System.out.println(o1.equals(o2));
  }
}
