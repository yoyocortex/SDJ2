package Session_4.Exercise_1_Uppercase.model;

public class TextConverterModel implements TextConverter
{
  @Override public String toUppercase(String text)
  {
    return text.toUpperCase();
  }
}
