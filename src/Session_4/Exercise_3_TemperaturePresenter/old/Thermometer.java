package Session_4.Exercise_3_TemperaturePresenter.old;

import Session_4.Exercise_3_TemperaturePresenter.mediator.TemperatureModel;

public class Thermometer
{
  public String id;
  public double t;
  public int d;
  private TemperatureModel temperatureModel;

  public Thermometer(TemperatureModel temperatureModel, String id, double t, int d) {
    this.id = id;
    this.t = t;
    this.d = d;
    this.temperatureModel = temperatureModel;
    temperatureModel.addTemperature(id, t);
  }

  public synchronized double temperature(double t, int p, int d, double t0, int s) {
    double tMax = Math.min(11 * p + 10, 11 * p + 10 + t0);

    tMax = Math.max(Math.max(t, tMax), t0);

    double heaterTerm = 0;

    if (p > 0) {

      double den = Math.max((tMax * (20 - 5 * p) * (d + 5)), 0.1);

      heaterTerm = 30 * s * Math.abs(tMax - t) / den;
    }

    double outdoorTerm = (t - t0) * s / 250.0;

    t = Math.min(Math.max(t - outdoorTerm + heaterTerm, t0), tMax);

    //System.out.println(t);
    temperatureModel.addTemperature(id, t);
    return this.t = t;
  }
}
