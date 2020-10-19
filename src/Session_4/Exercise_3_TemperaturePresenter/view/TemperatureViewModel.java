package Session_4.Exercise_3_TemperaturePresenter.view;

import Session_4.Exercise_3_TemperaturePresenter.mediator.TemperatureModel;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

public class TemperatureViewModel
{
  private TemperatureModel temperatureModel;
  private DoubleProperty temperature = new SimpleDoubleProperty();
  private StringProperty id;
  private double temp;

  public TemperatureViewModel(TemperatureModel temperatureModel) {
    this.temperatureModel = temperatureModel;
    id = new SimpleStringProperty();
  }

  public StringProperty getLastTemp() {
    id = new SimpleStringProperty(String.valueOf(temperatureModel.getLastInsertedTemperature()));
    return id;
  }

}
