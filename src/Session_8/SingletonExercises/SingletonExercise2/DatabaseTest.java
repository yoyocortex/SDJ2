package Session_8.SingletonExercises.SingletonExercise2;

public class DatabaseTest
{
  public static void main(String[] args)
  {
    Database database = Database.getDatabase();
    database.addCustomers(new Customer("5465465465465"));
    database.addCustomers(new Customer("54654"));
    System.out.println(database);
    System.out.println(database.getCustomers());

    Database database1 = Database.getDatabase();
    System.out.println(database1);
    System.out.println(database1.getCustomers());
  }
}
