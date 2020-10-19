package view.secondView;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import mediator.TemperatureModel;
import client.model.Temperature;

import java.beans.PropertyChangeEvent;
import java.text.DecimalFormat;
import java.util.List;

public class SecondViewViewModel
{
  private TemperatureModel temperatureModel;
  private StringProperty timeProperty, temperatureNear, temperatureFar;

  public SecondViewViewModel(TemperatureModel temperatureModel) {
    this.temperatureModel = temperatureModel;
    timeProperty = new SimpleStringProperty(); timeProperty.setValue("");
    temperatureNear = new SimpleStringProperty();
    temperatureFar = new SimpleStringProperty();
    this.temperatureModel.addListener("NearHeater",  evt -> setChartNearHeaterDate(evt));
    this.temperatureModel.addListener("NearHeater", evt -> setNearHeaterTemp(evt));
    this.temperatureModel.addListener("FarFromHeater", evt -> setFarFromHeaterTemp(evt));

  }

  private void setNearHeaterTemp(PropertyChangeEvent propertyChangeEvent) {
    Platform.runLater(() -> {
      Temperature temperature = (Temperature) propertyChangeEvent.getNewValue();
      DecimalFormat format= new DecimalFormat("0.0");
      try {
        temperatureNear.setValue(String.valueOf(format.format(temperature.getTemperature())));
      }
      catch (java.lang.NullPointerException e) {
        System.out.println("bitch");
      }
    });
  }

  private void setFarFromHeaterTemp(PropertyChangeEvent propertyChangeEvent) {
    Platform.runLater(() -> {
      Temperature temperature = (Temperature) propertyChangeEvent.getNewValue();
      DecimalFormat format= new DecimalFormat("0.0");
      temperatureFar.setValue(String.valueOf(format.format(temperature.getTemperature())));
    });
  }

  private void setChartNearHeaterDate(PropertyChangeEvent evt) {
    Platform.runLater(() -> {
      Temperature temperature = (Temperature) evt.getNewValue();
      timeProperty.setValue(temperature.getLocalDateTimeString());
      });
  }

  public List<Temperature> getNearHeaterList() {
    return temperatureModel.getNearHeaterList();
  }

  public List<Temperature> getFarHeaterList() {
    return temperatureModel.getFarHeaterList();
  }

  public StringProperty temperatureNearProperty()
  {
    return temperatureNear;
  }

}
