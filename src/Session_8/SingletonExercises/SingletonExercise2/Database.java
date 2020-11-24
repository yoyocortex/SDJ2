package Session_8.SingletonExercises.SingletonExercise2;

import java.util.ArrayList;
import java.util.List;

public class Database
{
  private static List<Customer> customers;
  private static List<Car> cars;
  private static Database database;

  private Database()
  {
    customers = new ArrayList<>();
    cars = new ArrayList<>();
  }

  public static synchronized Database getDatabase()
  {
    if(database == null)
    {
      database = new Database();
    }
    return database;
  }

  public List<Customer> getCustomers()
  {
    return customers;
  }

  public synchronized void addCustomers(Customer customer)
  {
    this.customers.add(customer);
  }

  public List<Car> getCars()
  {
    return cars;
  }

  public synchronized void addCars(Car car)
  {
    this.cars.add(car);
  }
}
