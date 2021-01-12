package Kingdom.Valuable;

import Kingdom.Valuable.Valuable;

public class GoldNugget implements Valuable
{
  @Override public String getName()
  {
    return "Gold Nugget";
  }

  @Override public int getValue()
  {
    return 4;
  }
}
