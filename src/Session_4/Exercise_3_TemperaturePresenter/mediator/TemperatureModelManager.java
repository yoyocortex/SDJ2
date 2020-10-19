package Session_4.Exercise_3_TemperaturePresenter.mediator;

import javafx.beans.value.ObservableValue;

import java.util.ArrayList;

public class TemperatureModelManager implements TemperatureModel
{
  private ArrayList<Double> tempArrayList = new ArrayList<Double>();
  private ArrayList<String> idArrayList = new ArrayList<String>();

  public TemperatureModelManager() {

  }

  @Override public void addTemperature(String id, double temperature)
  {
    tempArrayList.add(temperature);
    idArrayList.add(id);
  }

  @Override public double getLastInsertedTemperature()
  {
    //System.out.println(tempArrayList);
    return tempArrayList.get(tempArrayList.size()-1);
  }

  @Override public String getLastInsertedTemperatureId()
  {
    return (String) idArrayList.get(idArrayList.size());
  }
}
