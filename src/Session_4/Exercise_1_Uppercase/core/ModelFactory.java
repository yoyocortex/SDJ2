package Session_4.Exercise_1_Uppercase.core;

import Session_4.Exercise_1_Uppercase.model.TextConverter;
import Session_4.Exercise_1_Uppercase.model.TextConverterModel;

public class ModelFactory
{
  private TextConverter textConverter;

  public TextConverter getTextConverter()
  {
    if(textConverter == null)
    {
      textConverter = new TextConverterModel();
    }
    return textConverter;
  }
}
