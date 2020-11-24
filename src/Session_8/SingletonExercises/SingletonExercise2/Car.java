package Session_8.SingletonExercises.SingletonExercise2;

public class Car
{
  private String licencePlate;

  public Car(String licencePlate)
  {
    this.licencePlate = licencePlate;
  }

  public String getLicencePlate()
  {
    return licencePlate;
  }

  public void setLicencePlate(String licencePlate)
  {
    this.licencePlate = licencePlate;
  }

  @Override public String toString()
  {
    return "Car{" + "licencePlate='" + licencePlate + '\'' + '}';
  }
}
