package Kingdom.GemMining;

import Kingdom.Valuable.*;

import java.util.HashMap;

public class GemMine
{
  private static HashMap<String, Valuable> map = new HashMap();

  public static Valuable getValuable(String type)
  {
    Valuable valuable = map.get(type);
    if(valuable == null)
    {
      if("Diamond".equals(type)) valuable = new Diamond();
      else if("Gold Nugget".equals(type)) valuable = new GoldNugget();
      else if("Jewel".equals(type)) valuable = new Jewel();
      else if("Ruby".equals(type)) valuable = new Ruby();
      else if("Wooden Coin".equals(type)) valuable = new WoodenCoin();
      map.put(type, valuable);
    }
    return valuable;
  }
}
