package Kingdom.Valuable;

public class Jewel implements Valuable
{
  @Override public String getName()
  {
    return "Jewel";
  }

  @Override public int getValue()
  {
    return 3;
  }
}
