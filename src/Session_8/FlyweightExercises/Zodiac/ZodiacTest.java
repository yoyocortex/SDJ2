package Session_8.FlyweightExercises.Zodiac;

public class ZodiacTest
{
  public static void main(String[] args)
  {
    Person person1 = new Person("Karlo", ZodiacFactory.getZodiac("Aries"));
    Person person2 = new Person("Gosia", ZodiacFactory.getZodiac("Aries"));
    System.out.println(person1.getZodiac() == person2.getZodiac());
    System.out.println(person2);
  }
}
