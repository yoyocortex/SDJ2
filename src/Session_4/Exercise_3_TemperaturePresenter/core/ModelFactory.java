package Session_4.Exercise_3_TemperaturePresenter.core;

import Session_4.Exercise_3_TemperaturePresenter.mediator.TemperatureModel;
import Session_4.Exercise_3_TemperaturePresenter.mediator.TemperatureModelManager;

public class ModelFactory
{
  private TemperatureModel temperatureModel;

  public TemperatureModel getTemperatureModel() {
    if(temperatureModel == null)
    {
      temperatureModel = new TemperatureModelManager();
    }
    return temperatureModel;
  }
}
