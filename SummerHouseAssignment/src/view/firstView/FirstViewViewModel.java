package view.firstView;

import javafx.application.Platform;
import javafx.beans.property.*;
import mediator.TemperatureModel;
import client.model.Temperature;

import java.beans.PropertyChangeEvent;
import java.text.DecimalFormat;

public class FirstViewViewModel
{
  private TemperatureModel temperatureModel;
  private StringProperty nearHeaterTemp, farFromHeaterTemp, outsideTemp, heaterPower;

  public FirstViewViewModel(TemperatureModel temperatureModel) {
    this.temperatureModel = temperatureModel;
    nearHeaterTemp = new SimpleStringProperty();
    farFromHeaterTemp = new SimpleStringProperty();
    outsideTemp = new SimpleStringProperty();
    heaterPower = new SimpleStringProperty(); heaterPower.setValue("0");
    this.temperatureModel.addListener("NearHeater", evt -> setNearHeaterTemp(evt));
    this.temperatureModel.addListener("FarFromHeater", evt -> setFarFromHeaterTemp(evt));
    this.temperatureModel.addListener("Outdoor", evt -> setOutsideTemp(evt));
    this.temperatureModel.addListener("GetPower", evt -> setPower(evt));
  }

  private void setPower(PropertyChangeEvent propertyChangeEvent) {
    Platform.runLater(() -> {
      heaterPower.setValue(String.valueOf(propertyChangeEvent.getNewValue()));
    });
  }

  private void setNearHeaterTemp(PropertyChangeEvent propertyChangeEvent) {
    Platform.runLater(() -> {
      Temperature temperature = (Temperature) propertyChangeEvent.getNewValue();
      DecimalFormat format= new DecimalFormat("0.0");
      try {
        nearHeaterTemp.setValue(String.valueOf(format.format(temperature.getTemperature())));
      }
      catch (java.lang.NullPointerException ignored) {}
    });
  }

  private void setFarFromHeaterTemp(PropertyChangeEvent propertyChangeEvent) {
    Platform.runLater(() -> {
      Temperature temperature = (Temperature) propertyChangeEvent.getNewValue();
      DecimalFormat format= new DecimalFormat("0.0");
      farFromHeaterTemp.setValue(String.valueOf(format.format(temperature.getTemperature())));
    });
  }

  private void setOutsideTemp(PropertyChangeEvent propertyChangeEvent) {
    Platform.runLater(() -> {
      Temperature temperature = (Temperature) propertyChangeEvent.getNewValue();
      DecimalFormat format= new DecimalFormat("0.0");
      outsideTemp.setValue(String.valueOf(format.format(temperature.getTemperature())));
    });
  }

  public void powerUp() {
    temperatureModel.powerUp();
    temperatureModel.getPower();
  }

  public void powerDown() {
    temperatureModel.powerDown();
    temperatureModel.getPower();
  }

  public StringProperty heaterPowerProperty()
  {
    return heaterPower;
  }

  public StringProperty nearHeaterTempProperty() {
    return nearHeaterTemp;
  }

  public String getFarFromHeaterTemp() {
    return farFromHeaterTemp.get();
  }

  public StringProperty farFromHeaterTempProperty() {
    return farFromHeaterTemp;
  }

  public StringProperty outsideTempProperty() {
    return outsideTemp;
  }
}