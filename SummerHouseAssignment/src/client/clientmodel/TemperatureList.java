package client.clientmodel;

import java.util.ArrayList;
import java.util.List;

public class TemperatureList
{
  private List<Temperature> temperatureListNear;
  private List<Temperature> temperatureListFar;
  private List<Temperature> temperatureListOutside;

  public TemperatureList() {
    temperatureListNear = new ArrayList<>();
    temperatureListFar = new ArrayList<>();
    temperatureListOutside = new ArrayList<>();
  }

  public List<Temperature> getTemperatureListNear()
  {
    return temperatureListNear;
  }

  public List<Temperature> getTemperatureListFar()
  {
    return temperatureListFar;
  }

  public List<Temperature> getTemperatureListOutside()
  {
    return temperatureListOutside;
  }
}
