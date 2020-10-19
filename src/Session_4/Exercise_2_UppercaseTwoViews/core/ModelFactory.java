package Session_4.Exercise_2_UppercaseTwoViews.core;

import Session_4.Exercise_2_UppercaseTwoViews.model.TextConverter;
import Session_4.Exercise_2_UppercaseTwoViews.model.TextConverterModel;

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
