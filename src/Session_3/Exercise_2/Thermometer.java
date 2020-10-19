package Session_3.Exercise_2;

public class Thermometer
{
  public String id;
  public double t;
  public int d;

  public Thermometer(String id, double t) {
    this.id = id;
    this.t = t;
  }

  public Thermometer(String id, double t, int d) {
    this.id = id;
    this.t = t;
    this.d = d;
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

    return this.t = t;
  }
}
