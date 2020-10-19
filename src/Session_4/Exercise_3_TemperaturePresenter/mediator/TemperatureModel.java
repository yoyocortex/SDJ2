package Session_4.Exercise_3_TemperaturePresenter.mediator;

import javafx.beans.value.ObservableValue;

public interface TemperatureModel
{
  public void addTemperature(String id, double temperature);
  public double getLastInsertedTemperature();
  public String getLastInsertedTemperatureId();
  //public Temperature getLastInsertedTemperature(String id);
}
