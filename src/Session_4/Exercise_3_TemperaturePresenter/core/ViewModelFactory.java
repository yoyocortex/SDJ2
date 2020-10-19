package Session_4.Exercise_3_TemperaturePresenter.core;

import Session_4.Exercise_3_TemperaturePresenter.view.TemperatureViewModel;

public class ViewModelFactory
{
  private TemperatureViewModel temperatureViewModel;
  private ModelFactory modelFactory;

  public ViewModelFactory(ModelFactory modelFactory) {
    this.modelFactory = modelFactory;
  }
  public TemperatureViewModel getTemperatureViewModel() {
    if(temperatureViewModel == null)
    {
      temperatureViewModel = new TemperatureViewModel(modelFactory.getTemperatureModel());
    }
    return temperatureViewModel;
  }
}
