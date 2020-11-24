package Session_8.SingletonExercises.SingletonExercise2;

public class Customer
{
  private String ssn;

  public Customer(String ssn)
  {
    this.ssn = ssn;
  }

  public String getSsn()
  {
    return ssn;
  }

  public void setSsn(String ssn)
  {
    this.ssn = ssn;
  }

  @Override public String toString()
  {
    return "Customer{" + "ssn='" + ssn + '\'' + '}';
  }
}
