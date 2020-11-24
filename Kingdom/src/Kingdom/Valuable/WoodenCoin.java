package Kingdom.Valuable;

public class WoodenCoin implements Valuable
{
  @Override public String getName()
  {
    return "Wooden coin";
  }

  @Override public int getValue()
  {
    return 1;
  }
}
