package Session_4.Exercise_1_Uppercase.core;

import Session_4.Exercise_1_Uppercase.view_uppercase.UppercaseViewModel;

public class ViewModelFactory
{
  private UppercaseViewModel uppercaseViewModel;
  private ModelFactory modelFactory;

  public ViewModelFactory(ModelFactory modelFactory) {
    this.modelFactory = modelFactory;
  }

  public UppercaseViewModel getUppercaseViewModel()
  {
    if(uppercaseViewModel == null)
    {
      uppercaseViewModel = new UppercaseViewModel(modelFactory.getTextConverter());
    }
    return uppercaseViewModel;
  }
}
