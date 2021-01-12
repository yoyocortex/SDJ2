package Kingdom.Valuable;

import Kingdom.Valuable.Valuable;

public class Diamond implements Valuable
{
  @Override public String getName()
  {
    return "Diamond";
  }

  @Override public int getValue()
  {
    return 5;
  }
}
