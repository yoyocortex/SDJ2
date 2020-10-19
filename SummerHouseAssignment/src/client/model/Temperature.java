package client.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Temperature
{
  private String id;
  private double temperature;
  private LocalDateTime localDateTime;
  private String localDateTimeString;

  public Temperature(String id, double temperature) {
    this.id = id;
    this.temperature = temperature;
    localDateTime = LocalDateTime.now();
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public double getTemperature() {
    return temperature;
  }

  public void setTemperature(double temperature) {
    this.temperature = temperature;
  }

  public LocalDateTime getLocalDateTime() {
    return localDateTime;
  }

  public String getLocalDateTimeString() {
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("HH:mm:ss");
    localDateTime.format(myFormatObj);
    String formattedDate = localDateTime.format(myFormatObj);
    localDateTimeString = formattedDate;
    return formattedDate;
  }
}
