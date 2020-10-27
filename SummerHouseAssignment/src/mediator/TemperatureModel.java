package mediator;

import client.clientmodel.Temperature;
import sharedClasses.util.Subject;
import java.util.List;

public interface TemperatureModel extends Subject
{
  public void addTemperature(String id, double temperature);
  public Temperature getLastInsertedTemperature(String id);
  public List<Temperature> getNearHeaterList();
  public List<Temperature> getFarHeaterList();
  public List<Temperature> getOutsideList();
  public void setPower(int x);
  public void powerUp();
  public void powerDown();
  public int getPower();
}
