package Session_8.FlyweightExercises.Zodiac;

import java.util.HashMap;

public class ZodiacFactory
{
  private static HashMap<String, Zodiac> zodiacs = new HashMap<>();

  public static Zodiac getZodiac(String z)
  {
    Zodiac zodiac = zodiacs.get(z);
    if(zodiac == null)
    {
      if("Aries".equals(z))
      {
        zodiac = new Zodiac("Aries", "March 21st", "April 19th");
      }
      else if("Taurus".equals(z))
      {
        zodiac = new Zodiac("Taurus", "April 20th", "May 20th");
      }
      else if("Gemini".equals(z))
      {
        zodiac = new Zodiac("Gemini", "May 21st", "June 20th");
      }
      zodiacs.put(z, zodiac);
    }
    return zodiac;
  }
}
