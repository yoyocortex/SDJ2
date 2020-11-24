package Session_9.ProxyExercises.SeaBear;

public class SeaBearTest
{
  public static void main(String[] args)
  {
    VisitSeaBear seaBear = new SeaBear();

    VisitSeaBear proxySeaBearGuard = new SeaBearGuard();

    seaBear.view("ZooKeeper");

    seaBear.feed("Children");

    seaBear.pet("Someone");

    proxySeaBearGuard.view("Someone");

    proxySeaBearGuard.feed("Zookeeper");

    proxySeaBearGuard.feed("Children");

    proxySeaBearGuard.pet("Children");

    proxySeaBearGuard.pet("Someone");
  }
}
