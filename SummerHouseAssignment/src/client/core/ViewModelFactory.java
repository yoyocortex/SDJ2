package client.core;

import view.firstView.FirstViewViewModel;
import view.secondView.SecondViewViewModel;

public class ViewModelFactory
{
  private ModelFactory modelFactory;
  private FirstViewViewModel firstViewViewModel;
  private SecondViewViewModel secondViewViewModel;

  public ViewModelFactory(ModelFactory modelFactory) {
    this.modelFactory = modelFactory;
  }

  public FirstViewViewModel getFirstViewViewModel() {
    if(firstViewViewModel == null)
      firstViewViewModel = new FirstViewViewModel(modelFactory.getTemperatureModel());
    return firstViewViewModel;
  }

  public SecondViewViewModel getSecondViewViewModel() {
    if(secondViewViewModel == null)
      secondViewViewModel = new SecondViewViewModel(modelFactory.getTemperatureModel());
    return secondViewViewModel;
  }
}
