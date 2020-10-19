package Session_4.Exercise_2_UppercaseTwoViews.core;

import Session_4.Exercise_2_UppercaseTwoViews.log.LogViewModel;
import Session_4.Exercise_2_UppercaseTwoViews.view_uppercase.UppercaseViewModel;

public class ViewModelFactory
{
  private UppercaseViewModel uppercaseViewModel;
  private ModelFactory modelFactory;
  private LogViewModel logViewModel;

  public ViewModelFactory(ModelFactory modelFactory) {
    this.modelFactory = modelFactory;
  }

  public UppercaseViewModel getUppercaseViewModel() {
    if(uppercaseViewModel == null)
    {
      uppercaseViewModel = new UppercaseViewModel(modelFactory.getTextConverter());
    }
    return uppercaseViewModel;
  }

  public LogViewModel getLogViewModel() {
    if(logViewModel == null)
    {
      logViewModel = new LogViewModel(modelFactory.getTextConverter());
    }
    return logViewModel;
  }
}
