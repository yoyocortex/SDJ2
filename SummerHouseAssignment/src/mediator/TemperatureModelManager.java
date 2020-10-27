package mediator;

import client.clientmodel.Temperature;
import client.clientmodel.TemperatureList;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class TemperatureModelManager implements TemperatureModel

{
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private TemperatureList temperatureList;
  private int powerInt = 0;

  public TemperatureModelManager() {
    temperatureList = new TemperatureList();
  }

  @Override public void addTemperature(String id, double temperature) {
    if("Thermometer 1".equals(id))
    temperatureList.getTemperatureListNear().add(new Temperature(id, temperature));
    if("Thermometer 2".equals(id))
      temperatureList.getTemperatureListFar().add(new Temperature(id, temperature));
    if("Outdoor".equals(id))
      temperatureList.getTemperatureListOutside().add(new Temperature(id, temperature));
    getLastInsertedTemperature(id);
  }

  @Override public Temperature getLastInsertedTemperature(String id) {
    if("Thermometer 1".equals(id)) {
      support.firePropertyChange("NearHeater", null,
          temperatureList.getTemperatureListNear()
              .get(temperatureList.getTemperatureListNear().size() - 1));
    }
    if("Thermometer 2".equals(id)) {
      support.firePropertyChange("FarFromHeater", null,
          temperatureList.getTemperatureListFar()
              .get(temperatureList.getTemperatureListFar().size() - 1));
    }
    if("Outdoor".equals(id))
    {
      support.firePropertyChange("Outdoor", null,
          temperatureList.getTemperatureListOutside()
          .get(temperatureList.getTemperatureListOutside().size() - 1));
      return temperatureList.getTemperatureListOutside().get(temperatureList.getTemperatureListOutside().size() - 1);
    }
    return null;
  }

  @Override public List<Temperature> getNearHeaterList()
  {
    return temperatureList.getTemperatureListNear();
  }

  @Override public List<Temperature> getFarHeaterList()
  {
    return temperatureList.getTemperatureListFar();
  }

  @Override public List<Temperature> getOutsideList()
  {
    return temperatureList.getTemperatureListOutside();
  }

  @Override public void setPower(int x) {
    //System.out.println("this is set power" + x);
    powerInt = x;
  }

  @Override public void powerUp()
  {
    support.firePropertyChange("Power", null, "PowerUp");
  }

  @Override public void powerDown()
  {
    support.firePropertyChange("Power", null, "PowerDown");
  }

  @Override public int getPower()
  {
    support.firePropertyChange("GetPower", null, powerInt);
    return powerInt;
  }

  @Override public void addListener(String name, PropertyChangeListener listener) {
    support.addPropertyChangeListener(name, listener);
  }

  @Override public void removeListener(String name, PropertyChangeListener listener) {
    support.removePropertyChangeListener(name, listener);
  }
}
