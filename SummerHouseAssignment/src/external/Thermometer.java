package external;

import mediator.TemperatureModel;
import radiator.Radiator;

import java.beans.PropertyChangeEvent;

public class Thermometer
{
  private String id;
  private double t;
  private int d;
  private double t0 = 0;
  private TemperatureModel temperatureModel;
  private Radiator power = new Radiator();

  public Thermometer(String id, double t, int d) {
    this.id = id;
    this.t = t;
    this.d = d;
  }

  public Thermometer(TemperatureModel temperatureModel, String id, double t, int d) {
    this.id = id;
    this.t = t;
    this.d = d;
    this.temperatureModel = temperatureModel;
    this.temperatureModel.addListener("Power", this::setPower);
  }

  private void setPower(PropertyChangeEvent event)
  {
    if(event.getNewValue().equals("PowerUp")) {
      power.turnUp();
      temperatureModel.setPower(power.getPower());
    }
    else if(event.getNewValue().equals("PowerDown")) {
      power.turnDown();
      temperatureModel.setPower(power.getPower());
    }
  }

  public Thermometer(TemperatureModel temperatureModel, String id) {
    this.id = id;
    this.temperatureModel = temperatureModel;
  }

  public synchronized String getId() {
    return id;
  }

  public synchronized double getT() {
    return t;
  }

  public synchronized int getD() {
    return d;
  }

  public synchronized double getT0() {
    return t0;
  }

  public Radiator getRadiator()
  {
    return power;
  }

  public void setT0(double t0)
  {
    this.t0 = t0;
  }

  public synchronized double temperature(double t, int p, int d, double t0, int s) {
    temperatureModel.addTemperature(id, t);
    p = power.getPower();
    temperatureModel.setPower(p); temperatureModel.getPower();

    if((temperatureModel.getLastInsertedTemperature("Outdoor")) == null)
    {
      temperatureModel.addTemperature("Outdoor", 5);
      this.t0 = t0 = temperatureModel.getLastInsertedTemperature("Outdoor").getTemperature();
    }
    else
      this.t0 = t0 = temperatureModel.getLastInsertedTemperature("Outdoor").getTemperature();

    double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);
    tMax = Math.max(Math.max(t, tMax), t0);
    double heaterTerm = 0;
    if (p > 0) {
      double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);
      heaterTerm = 30 * s * Math.abs(tMax - t) / den;
    }
    double outdoorTerm = (t - t0) * s / 250.0;
    t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);
    return this.t = t;
  }

  public synchronized double externalTemperature(double t0, double min, double max) {
    temperatureModel.addTemperature(id, this.t0);
    double left = t0 - min;
    double right = max - t0;
    int sign = Math.random() * (left + right) > left ? 1 : -1;
    t0 += sign * Math.random();
    return this.t0 = t0;
  }
}
